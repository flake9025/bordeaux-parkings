package com.instantsystem.bordeaux.service;

import com.instantsystem.bordeaux.Assertions;
import com.instantsystem.bordeaux.dto.ParkingDTO;
import com.instantsystem.bordeaux.support.AbstractIntegrationTest;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ParkingServiceITTest extends AbstractIntegrationTest {

  @Autowired
  private ParkingService parkingService;

  @Test
  public void findAll() throws Exception {
    List<ParkingDTO> parkingDTOList = parkingService.findAll();
    Assert.assertNotNull(parkingDTOList);
    Assert.assertFalse(parkingDTOList.isEmpty());
    parkingDTOList.stream().forEach(pk -> {
      Assertions.assertThat(pk).isNotNull();
    });
  }

  @Test
  public void refresh() throws Exception {
    List<ParkingDTO> parkingDTOList = parkingService.refreshAll();
    Assert.assertNotNull(parkingDTOList);
    Assert.assertFalse(parkingDTOList.isEmpty());
    parkingDTOList.stream().forEach(pk -> {
      Assertions.assertThat(pk).isNotNull();
    });
  }

  @Test
  public void findAllAround() throws Exception {
    List<ParkingDTO> parkingDTOList = parkingService.findAllAround(44.888824, -0.517676, 1500);
    Assert.assertNotNull(parkingDTOList);
    Assert.assertFalse(parkingDTOList.isEmpty());
    parkingDTOList.stream().forEach(pk -> {
      Assertions.assertThat(pk).isNotNull();
      Assert.assertTrue(pk.getDistanceInMeters() < 1500);
    });
  }
}
