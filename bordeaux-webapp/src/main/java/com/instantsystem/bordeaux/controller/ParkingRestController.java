package com.instantsystem.bordeaux.controller;

import static com.instantsystem.bordeaux.controller.ParkingRestController.RESOURCE_ROOT;

import com.instantsystem.bordeaux.dto.ParkingDTO;
import com.instantsystem.bordeaux.service.ParkingService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RESOURCE_ROOT)
public class ParkingRestController {

  public static final String RESOURCE_ROOT = "/parkings";
  public static final String RESOURCE_AROUND = "/around";

  public static final String PARAM_LATITUDE = "latitude";
  public static final String PARAM_LONGITUDE = "longitude";
  public static final String PARAM_MAX_DISTANCE = "maxDistance";

  @Autowired
  private ParkingService parkingService;

  @GetMapping
  @ApiOperation("Liste des parkings")
  public List<ParkingDTO> findAll() throws Exception {
    return parkingService.findAll();
  }

  @GetMapping(RESOURCE_AROUND+"/{"+PARAM_LATITUDE+"}"+"/{"+PARAM_LONGITUDE+"}/{"+PARAM_MAX_DISTANCE+"}")
  @ApiOperation("Liste des parkings à proximité.")
  public List<ParkingDTO> findAllAround(
      @PathVariable(PARAM_LATITUDE) double latitude,
      @PathVariable(PARAM_LONGITUDE) double longitude,
      @PathVariable(PARAM_MAX_DISTANCE) int maxDistance) throws Exception {
    return parkingService.findAllAround(latitude, longitude, maxDistance);
  }
}
