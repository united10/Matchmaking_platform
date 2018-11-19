package com.stackroute.service;

import com.stackroute.domain.CommonOutput;
import com.stackroute.domain.Section;

public interface CertificateService {
    CommonOutput processCertificateDetails(Section section);
}
