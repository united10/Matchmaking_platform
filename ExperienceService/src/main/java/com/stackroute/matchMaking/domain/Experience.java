package com.stackroute.matchMaking.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.Id;

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