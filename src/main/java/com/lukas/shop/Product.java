package com.lukas.shop;

import lombok.Data;
import lombok.NonNull;

@Data
public class Product {
    @NonNull
    String name;

    @NonNull
    double price;

    public Product(@NonNull String name, @NonNull double price) {
        this.name = name;
        this.price = price;
    }
}
