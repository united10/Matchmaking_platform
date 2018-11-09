package com.stackroute.educationservice.domain;

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
}
