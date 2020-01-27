package com.instantsystem.bordeaux.support;

import com.instantsystem.bordeaux.BordeauxApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BordeauxApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
public abstract class AbstractEndToEndTest {

  protected MockMvc mockMvc;

  public void configureStandAloneMockMvc(Object restController) {
    mockMvc = MockMvcBuilders.standaloneSetup(restController)
        .setMessageConverters(new MappingJackson2HttpMessageConverter())
        .build();
  }
}
