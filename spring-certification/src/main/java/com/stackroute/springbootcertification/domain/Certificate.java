package com.stackroute.springbootcertification.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Certificate {
    private String certificateName;
    private String certificateAuthority;
    private String licenseNumber;
    private String fromDate;
    private String toDate;
}
