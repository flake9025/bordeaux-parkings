package com.instantsystem.bordeaux.service;

import com.instantsystem.bordeaux.dto.ParkingDTO;
import java.util.List;

public interface ParkingService {

  /**
   * find all parkings with cache
   * @return parkings list
   * @throws Exception
   */
  List<ParkingDTO> findAll() throws Exception;

  /**
   * force refresh parkings list
   * @return parkings list
   * @throws Exception
   */
  List<ParkingDTO> refreshAll() throws Exception;

  /**
   * find all parkings around a location
   * @param userLatitude
   * @param userLongitude
   * @param maxDistance
   * @return parkings list
   * @throws Exception
   */
  List<ParkingDTO> findAllAround(double userLatitude, double userLongitude, int maxDistance) throws Exception;
}
