package com.stackroute.DownstreamService.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {
    private CurrentLocation currentLocation;
    private PastLocation pastLocation;
}
