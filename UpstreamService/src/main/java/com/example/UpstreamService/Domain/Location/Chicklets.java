package com.example.UpstreamService.Domain.Location;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chicklets {
    private CurrentLocation currentLocation;
    private PastLocation pastLocation[];
}