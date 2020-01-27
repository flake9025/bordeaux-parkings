package com.instantsystem.bordeaux.mapper;

import com.instantsystem.bordeaux.support.AbstractIntegrationTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StringMapperTest extends AbstractIntegrationTest {

  @Autowired
  private StringMapper stringMapper;

  @Test
  public void stringToInt(){
    Assert.assertEquals(0, stringMapper.stringToInt(null));
    Assert.assertEquals(0, stringMapper.stringToInt(""));
    Assert.assertEquals(10, stringMapper.stringToInt("10"));
  }

  @Test
  public void stringToLong(){
    Assert.assertEquals(0, stringMapper.stringToLong(null));
    Assert.assertEquals(0, stringMapper.stringToLong(""));
    Assert.assertEquals(10, stringMapper.stringToLong("10"));
  }
}
