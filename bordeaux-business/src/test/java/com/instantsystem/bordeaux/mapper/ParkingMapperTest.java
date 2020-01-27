package com.instantsystem.bordeaux.mapper;

import com.instantsystem.bordeaux.Assertions;
import com.instantsystem.bordeaux.DatasetFactory;
import com.instantsystem.bordeaux.dto.ParkingDTO;
import com.instantsystem.bordeaux.enums.ParkingStatus;
import com.instantsystem.bordeaux.lacub.model.STPARKP;
import com.instantsystem.bordeaux.support.AbstractIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ParkingMapperTest extends AbstractIntegrationTest {

  @Autowired
  private ParkingMapper parkingMapper;

  @Test
  public void toParkingDto() {
    STPARKP stparkp = DatasetFactory.createSTPARKP();
    ParkingDTO dto = parkingMapper.toParkingDto(stparkp);

    Assertions.assertThat(dto)
        .hasName("Parc-Relais La Gardette (Tout Public) - Tbm Keolis")
        .hasSpots(242)
        .hasSpotsLeft(66)
        .hasStatus(ParkingStatus.FREE)
        .hasLatitude(44.888824)
        .hasLongitude(-0.517676)
        .hasDistanceInMeters(0)
        .hasAddress("Chemin du Grand Came 33310 Lormont")
        .hasUrl("https://www.infotbm.com/les-parc-relais-tout-public");
  }

  @Test
  public void toParkingStatus(){
    Assert.assertEquals(ParkingStatus.UNKOWN, parkingMapper.toParkingStatus(null));
    Assert.assertEquals(ParkingStatus.FREE, parkingMapper.toParkingStatus("LIBRE"));
    Assert.assertEquals(ParkingStatus.FULL, parkingMapper.toParkingStatus("COMPLET"));
    Assert.assertEquals(ParkingStatus.OPEN, parkingMapper.toParkingStatus("OUVERT"));
    Assert.assertEquals(ParkingStatus.CLOSED, parkingMapper.toParkingStatus("FERME"));
    Assert.assertEquals(ParkingStatus.UNKOWN, parkingMapper.toParkingStatus("TEST"));
  }

  @Test
  public void mapCoordinate(){
    double lat = parkingMapper.mapCoordinate(DatasetFactory.createGeometry(), 0);
    Assert.assertEquals(44.888824, lat, 0.0);
    double lon = parkingMapper.mapCoordinate(DatasetFactory.createGeometry(), 1);
    Assert.assertEquals(-0.517676, lon, 0.0);
  }
}
