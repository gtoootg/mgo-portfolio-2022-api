package com.mgoportfolio2022api.mgoportfolio2022api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id",nullable = false)
    private Integer userId;

    @Column(name="user_name",nullable = false)
    private String userName;

    @Column(name="mail",nullable = false)
    private String mail;

    @JsonIgnore
    @Column(name="password", nullable = false)
    private String password;

    @Column(name="enabled", nullable = false)
    private Integer enabled;
}
