package com.stackroute.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class User {

    @Id
    @Column(name = "email",length = 200)
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    public String password;
    @Column(name = "role")
    private String role;

}
