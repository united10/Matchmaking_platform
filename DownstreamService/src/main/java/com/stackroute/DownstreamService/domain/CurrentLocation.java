package com.stackroute.DownstreamService.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrentLocation {
    private  String currentLocationId;
    private  String cityName;
    private String stateName;
    private String pincode;
}
