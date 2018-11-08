package com.stackroute.springlocation.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrentLocation {
    private String currentLocationId;
    private String cityName;
    private String stateName;
    private String pincode;
}
