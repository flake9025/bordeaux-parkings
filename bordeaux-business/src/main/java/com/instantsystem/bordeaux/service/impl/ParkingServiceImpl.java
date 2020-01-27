package com.instantsystem.bordeaux.service.impl;

import com.instantsystem.bordeaux.dto.ParkingDTO;
import com.instantsystem.bordeaux.lacub.client.LaCubParkingClient;
import com.instantsystem.bordeaux.lacub.client.impl.LaCubParkingXmlClient;
import com.instantsystem.bordeaux.mapper.ParkingMapper;
import com.instantsystem.bordeaux.service.ParkingService;
import com.instantsystem.bordeaux.lacub.model.FeatureCollection;
import com.instantsystem.bordeaux.lacub.model.STPARKP;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.util.SloppyMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class ParkingServiceImpl implements ParkingService {

  // ===========================================================
  // Constants
  // ===========================================================

  private static final String CACHE_NAME = "ParkingService";

  // ===========================================================
  // Fields
  // ===========================================================

  @Autowired
  private ParkingMapper parkingMapper;
  @Value("${lacub.api.url}")
  private String laCubApiUrl;
  @Value("${lacub.api.key.value}")
  private String laCubApiKey;
  private LaCubParkingClient laCubParkingClient;

  // ===========================================================
  // Constructors
  // ===========================================================

  @PostConstruct
  private void initLaCubParkingClient(){
    laCubParkingClient = new LaCubParkingXmlClient(laCubApiUrl, laCubApiKey);
  }

  // ===========================================================
  // Methods for/from SuperClass/Interfaces
  // ===========================================================

  @Override
  public List<ParkingDTO> findAll() throws Exception {
    FeatureCollection fc = findAllParkingsWithCache();
    return fc.getFeatureMember().stream().map(fm -> parkingMapper.toParkingDto(fm.getStparkp())).collect(Collectors.toList());
  }

  @CacheEvict(CACHE_NAME)
  public List<ParkingDTO> refreshAll() throws Exception {
    return findAll();
  }

  @Override
  public List<ParkingDTO> findAllAround(double userLatitude, double userLongitude, int maxDistance) throws Exception {
    try {
      FeatureCollection fc = findAllParkingsWithCache();
      List<ParkingDTO> parkingDTOS = fc.getFeatureMember().stream()
          .map(fm -> parkingMapper.toParkingDto(fm.getStparkp(), calculateDistance(userLatitude, userLongitude, fm.getStparkp())))
          .collect(Collectors.toList());

      return parkingDTOS.stream()
          .filter(dto -> dto.getDistanceInMeters() < maxDistance)
          .sorted(Comparator.comparingDouble(ParkingDTO::getDistanceInMeters))
          .collect(Collectors.toList());
    } catch (Exception e){
      log.error("findAll(...) KO : " + e.getMessage(), e);
      throw new Exception("findAll(...) KO" + e.getMessage());
    }
  }

  // ===========================================================
  // Methods
  // ===========================================================

  @Cacheable(CACHE_NAME)
  private FeatureCollection findAllParkingsWithCache() throws Exception {
    try {
      return laCubParkingClient.findAll();
    } catch (Exception e){
      log.error("findAllParkingsWithCache(...) KO : " + e.getMessage(), e);
      throw new Exception("Impossible de récupérer les parkings : " + e.getMessage());
    }
  }

  private double calculateDistance(double userLatitude, double userLongitude, @NotNull STPARKP parking){
    double parkingLatitude = parkingMapper.mapCoordinate(parking.getGeometry(), 0);
    double parkingLongitude = parkingMapper.mapCoordinate(parking.getGeometry(), 1);
    return SloppyMath.haversinMeters(userLatitude, userLongitude, parkingLatitude, parkingLongitude);
  }
}
