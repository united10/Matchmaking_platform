package com.example.UpstreamService.Domain.Location;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String sectionId;
    private String userId;
    private String operationType;
    private Chicklets chicklets[];
}
