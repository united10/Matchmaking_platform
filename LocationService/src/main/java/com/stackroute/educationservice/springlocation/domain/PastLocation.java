package com.stackroute.educationservice.springlocation.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PastLocation {
    private String pastLocationId;
    private String cityName;
    private String stateName;
    private String pincode;
}
