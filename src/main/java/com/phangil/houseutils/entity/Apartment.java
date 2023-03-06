package com.phangil.houseutils.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Apartment", indexes = {
    @Index(name = "idx_apartment_name", columnList = "name")
})
@Getter
@Setter
public class Apartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Long price;

    @Builder
    public Apartment(String name, String address, Long price) {
        this.name = name;
        this.address = address;
        this.price = price;
    }
}
