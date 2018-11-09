package com.example.UpstreamService.Domain.Education;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chicklets {
    Institution institution;
    Qualification qualification;
    String summary;

   }
