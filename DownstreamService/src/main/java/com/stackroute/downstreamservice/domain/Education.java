package com.stackroute.downstreamservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Education {
    private Qualification qualification;
    private Institution institution;
    private String summary;
}
