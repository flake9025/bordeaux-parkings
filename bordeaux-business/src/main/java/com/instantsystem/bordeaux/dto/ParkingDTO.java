package com.instantsystem.bordeaux.dto;

import com.instantsystem.bordeaux.enums.ParkingStatus;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingDTO implements Serializable {

  private String name;
  private int spots;
  private int spotsLeft;
  private ParkingStatus status;
  private double latitude;
  private double longitude;
  private int distanceInMeters;
  private String address;
  private String url;
}
