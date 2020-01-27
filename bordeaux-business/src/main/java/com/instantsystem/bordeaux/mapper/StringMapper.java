package com.instantsystem.bordeaux.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StringMapper {

  /**
   * Tweak for mapstruct as it does not handle empty strings
   * @param value
   * @return parsed int or 0
   */
  default int stringToInt(String value) {
    return value != null && !value.isEmpty() ? Integer.valueOf( value ) : 0;
  }

  /**
   * Tweak for mapstruct as it does not handle empty strings
   * @param value
   * @return parsed long or 0
   */
  default long stringToLong(String value) {
    return value != null && !value.isEmpty() ? Long.valueOf( value ) : 0L;
  }
}
