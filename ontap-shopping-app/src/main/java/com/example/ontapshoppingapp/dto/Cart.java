package com.example.ontapshoppingapp.dto;

import com.example.ontapshoppingapp.model.Product;
import lombok.*;

@Data
@Builder
public class Cart {
    private int quantity;
    private Product product;
}
