package com.instantsystem.bordeaux.controller;

import com.instantsystem.bordeaux.support.AbstractEndToEndTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


public class ParkingRestControllerTest extends AbstractEndToEndTest {

  @Autowired
  private ParkingRestController restController;

  @Before
  public void setup() {
    configureStandAloneMockMvc(restController);
  }

  @Test
  public void findAll() throws Exception {
    this.mockMvc
        .perform(MockMvcRequestBuilders.get(restController.RESOURCE_ROOT))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void findAllAround() throws Exception {
    this.mockMvc
        .perform(MockMvcRequestBuilders
            .get(restController.RESOURCE_ROOT + restController.RESOURCE_AROUND + "/{" + restController.PARAM_LATITUDE + "}" + "/{"
                + restController.PARAM_LONGITUDE + "}" + "/{" + restController.PARAM_MAX_DISTANCE + "}", 44.888824, -0.517676, 1500))
        .andExpect(MockMvcResultMatchers.status().isOk());
  }
}
