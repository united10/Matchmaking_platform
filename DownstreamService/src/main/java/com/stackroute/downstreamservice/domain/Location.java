package com.stackroute.downstreamservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {
    private CurrentLocation currentLocation;
    private List<PastLocation> pastLocation;
}
