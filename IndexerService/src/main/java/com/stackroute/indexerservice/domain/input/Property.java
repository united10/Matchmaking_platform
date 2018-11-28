package com.stackroute.indexerservice.domain.input;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Property {
    private String propertyName;
    private String propertyValue;
}
