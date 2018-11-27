package com.stackroute.indexerservice.domain.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonOutput {
    private String operationType;
    private String sourceNode;
    private String sourceNodeProperty;
    private String targetNode;
    private TargetProperty[] targetNodeProperty;
    private String relationships;
    private Property[] properties;

    @Override
    public String toString() {
        return "CommonOutput{" +
                "operationType='" + operationType + '\'' +
                ", sourceNode='" + sourceNode + '\'' +
                ", sourceNodeProperty='" + sourceNodeProperty + '\'' +
                ", targetNode='" + targetNode + '\'' +
                ", targetNodeProperty=" + Arrays.toString(targetNodeProperty) +
                ", relationship='" + relationships + '\'' +
                ", properties=" + Arrays.toString(properties) +
                '}';
    }
}
