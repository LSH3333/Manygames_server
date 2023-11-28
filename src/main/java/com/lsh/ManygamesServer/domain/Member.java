package com.lsh.ManygamesServer.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String password;

    public Member() {}

    public Member(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
