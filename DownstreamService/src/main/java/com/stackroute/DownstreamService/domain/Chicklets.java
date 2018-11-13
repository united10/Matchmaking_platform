package com.stackroute.DownstreamService.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chicklets {
    private Qualification qualification;
    private Institution institution;
    private String summary;
    private Skills skill;
    private CurrentLocation currentLocation;
    private PastLocation pastLocation;
}
