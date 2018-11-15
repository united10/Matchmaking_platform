package com.stackroute.experienceservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Experience {
    private String organisation;
    private String role;
    private int fromDate;
    private int fromMonth;
    private int fromYear;
    private int toDate;
    private int toMonth;
    private int toYear;
}