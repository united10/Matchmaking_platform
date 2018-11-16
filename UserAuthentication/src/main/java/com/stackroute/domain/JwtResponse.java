package com.stackroute.domain;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JwtResponse {
    String token;
    String email;
}
