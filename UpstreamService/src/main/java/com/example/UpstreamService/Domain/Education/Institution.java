package com.example.UpstreamService.Domain.Education;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Institution {
    String institutionId;
    String institutionName;
    String startDate;
    String endDate;


}
