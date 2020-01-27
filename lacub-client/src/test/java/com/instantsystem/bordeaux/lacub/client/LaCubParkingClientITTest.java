package com.instantsystem.bordeaux.lacub.client;

import com.instantsystem.bordeaux.lacub.client.impl.LaCubParkingXmlClient;
import com.instantsystem.bordeaux.lacub.model.FeatureCollection;
import com.instantsystem.bordeaux.lacub.model.FeatureMember;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class LaCubParkingClientITTest {

  private LaCubParkingClient laCubParkingClient;

  @Before
  public void setUp(){
    String apiUrl = "http://data.lacub.fr/wfs?SERVICE=WFS&VERSION=1.1.0&REQUEST=GetFeature&TYPENAME=ST_PARK_P&SRSNAME=EPSG:4326";
    String apiKey = "9Y2RU3FTE8";
    laCubParkingClient = new LaCubParkingXmlClient(apiUrl, apiKey);
  }

  @Test
  public void getParkingsTest() throws Exception{
    FeatureCollection fc = laCubParkingClient.findAll();
    // check xml mapping is ok
    Assert.assertNotNull(fc);
    Assert.assertNotNull(fc.getFeatureMember());
    for(FeatureMember fm : fc.getFeatureMember()){
      Assert.assertNotNull(fm.getStparkp());
      Assert.assertNotNull(fm.getStparkp().getGeometry());
    }
  }
}
