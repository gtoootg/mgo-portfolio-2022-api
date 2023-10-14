package com.mgoportfolio2022api.mgoportfolio2022api.model.common;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="common_category")
@Data
public class CommonCategoryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="label",nullable = false)
    private String label;

}
