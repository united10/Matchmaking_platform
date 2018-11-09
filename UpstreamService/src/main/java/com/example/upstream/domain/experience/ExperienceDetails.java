package com.example.upstream.domain.experience;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceDetails {
    private String organisation;
    private String role;
    private int fromDate;
    private int fromMonth;
    private int fromYear;
    private int toDate;
    private int toMonth;
    private int toYear;
}