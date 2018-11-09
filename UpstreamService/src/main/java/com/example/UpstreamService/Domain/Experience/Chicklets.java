package com.example.UpstreamService.Domain.Experience;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chicklets {
    private ExperienceDetails experienceDetails;
}
