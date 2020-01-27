package com.instantsystem.bordeaux;

import com.instantsystem.bordeaux.lacub.model.BoundedBy;
import com.instantsystem.bordeaux.lacub.model.BoundedBy.Envelope;
import com.instantsystem.bordeaux.lacub.model.Point;
import com.instantsystem.bordeaux.lacub.model.STPARKP;
import com.instantsystem.bordeaux.lacub.model.STPARKP.Geometry;

public class DatasetFactory {

  public static STPARKP createSTPARKP() {
    return STPARKP.builder()
        .boundedBy(createBoundedBy())
        .geometry(createGeometry())
        .gid(211)
        .ident("CUBPK49")
        .nom("Parc-Relais La Gardette (Tout Public) - Tbm Keolis")
        .libres("66")
        .total("242")
        .etat("LIBRE")
        .url("https://www.infotbm.com/les-parc-relais-tout-public")
        .adresse("Chemin du Grand Came 33310 Lormont")
        .build();
  }

  public static BoundedBy createBoundedBy(){
    return BoundedBy.builder()
        .envelope(createEnvelope())
        .build();
  }

  public static Envelope createEnvelope(){
    return Envelope.builder()
        .srsName("EPSG:4326")
        .lowerCorner("44.888824 -0.517676")
        .upperCorner("44.888824 -0.517676")
        .build();
  }

  public static Geometry createGeometry(){
    return Geometry.builder()
        .point(createPoint())
        .build();
  }

  private static Point createPoint() {
    return Point.builder()
        .srsName("EPSG:4326")
        .pos("44.888824 -0.517676")
        .build();
  }
}
