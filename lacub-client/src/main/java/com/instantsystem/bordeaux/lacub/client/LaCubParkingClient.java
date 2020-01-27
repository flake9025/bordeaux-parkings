package com.instantsystem.bordeaux.lacub.client;

import com.instantsystem.bordeaux.lacub.model.FeatureCollection;

public interface LaCubParkingClient {

  FeatureCollection findAll() throws Exception;
}
