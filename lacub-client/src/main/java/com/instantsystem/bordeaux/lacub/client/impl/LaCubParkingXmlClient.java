package com.instantsystem.bordeaux.lacub.client.impl;

import com.instantsystem.bordeaux.lacub.client.LaCubParkingClient;
import com.instantsystem.bordeaux.lacub.jaxb.JaxbParser;
import com.instantsystem.bordeaux.lacub.model.FeatureCollection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
public class LaCubParkingXmlClient implements LaCubParkingClient {

  // ===========================================================
  // Constants
  // ===========================================================

  public static final String API_KEY = "key";

  // ===========================================================
  // Fields
  // ===========================================================

  private HttpClient httpClient;
  private String apiUrl;

  // ===========================================================
  // Constructors
  // ===========================================================

  /**
   * LaCubParking Client Implementation
   * @param baseURL : the base URL
   * @param apiKey : the private API key
   */
  public LaCubParkingXmlClient(String baseURL, String apiKey) {
    Assert.notNull(baseURL, "baseURL cannot be null");
    Assert.notNull(apiKey, "apiKey cannot be null");
    httpClient = HttpClient.newBuilder().build();
    apiUrl = UriComponentsBuilder.fromUri(URI.create(baseURL)).queryParam(API_KEY, apiKey).build().toUriString();
  }

  // ===========================================================
  // Methods
  // ===========================================================

  @Override
  public FeatureCollection findAll() throws Exception {
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).GET().build();
    try {
      HttpResponse response = httpClient.send(request, BodyHandlers.ofString());
      log.trace("findAll(...) OK, response = {}", response.body());
      return (FeatureCollection) JaxbParser.parseXmlString(response.body().toString());
    } catch (Exception e) {
      log.error("findAll(...) KO : " + e.getMessage(), e);
      throw e;
    }
  }
}
