package com.example.UpstreamService.Domain.Certificate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Chicklets {
    private CertificateDetails certificateDetails;
}
