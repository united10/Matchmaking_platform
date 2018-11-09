package com.example.UpstreamService.Domain.Certificate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDetails {
    private String certificateName;
    private String certificateAuthority;
    private String licenseNumber;
    private String fromDate;
    private String toDate;
}
