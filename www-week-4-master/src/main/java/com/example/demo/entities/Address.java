package com.example.demo.entities;
import lombok.*;

import java.util.UUID;
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Address {
    private UUID id;
    private String city;
    private Short country;
    private String number;
    private String street;
    private String zipcode;

    public Address(UUID id) {
        this.id = id;
    }
}
