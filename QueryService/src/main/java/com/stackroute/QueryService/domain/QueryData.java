package com.stackroute.QueryService.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//This class is to model the query data
@Document(collection = "queries")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryData {
    @Id
    private String userId;
    private String query;
    private String timeStamp;
}
