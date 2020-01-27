package com.instantsystem.bordeaux.mapper;

import com.instantsystem.bordeaux.dto.ParkingDTO;
import com.instantsystem.bordeaux.enums.ParkingStatus;
import com.instantsystem.bordeaux.lacub.model.STPARKP;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.util.Assert;

@Mapper(componentModel = "spring", uses = StringMapper.class)
public interface ParkingMapper {

  @Mapping(target = "name", source = "nom")
  @Mapping(target = "spots", source = "total")
  @Mapping(target = "spotsLeft", source = "libres")
  @Mapping(target = "status", source = "etat")
  @Mapping(target = "latitude", expression = "java(mapCoordinate(stparkp.getGeometry(), 0))")
  @Mapping(target = "longitude", expression = "java(mapCoordinate(stparkp.getGeometry(), 1))")
  @Mapping(target = "address", source = "adresse")
  ParkingDTO toParkingDto(STPARKP stparkp);

  default ParkingDTO toParkingDto(STPARKP stparkp, double distanceInMeters) {
    ParkingDTO dto = toParkingDto(stparkp);
    dto.setDistanceInMeters((int) distanceInMeters);
    return dto;
  }

  default ParkingStatus toParkingStatus(String etat){
    if(etat == null){
      return ParkingStatus.UNKOWN;
    }
    switch (etat){
      case "LIBRE" : return ParkingStatus.FREE;
      case "COMPLET" : return ParkingStatus.FULL;
      case "OUVERT" : return ParkingStatus.OPEN;
      case "FERME" : return ParkingStatus.CLOSED;
      default: return ParkingStatus.UNKOWN;
    }
  }

  default double mapCoordinate(STPARKP.Geometry geometry, int position) {
    Assert.isTrue(position == 0 || position == 1, "position should be 0 or 1 to get left or right coordinate");
    return Double.parseDouble(geometry.getPoint().getPos().split(" ")[position]);
  }
}
