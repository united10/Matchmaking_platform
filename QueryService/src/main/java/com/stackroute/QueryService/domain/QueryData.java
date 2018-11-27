package com.stackroute.QueryService.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//This class is to model the query data
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryData {
    private String userId;
    private String query;
    private String timeStamp;
}
