package com.lukas.shop;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Profile("pro")
@Data
//@ConfigurationProperties(prefix = "shop-service-pro")
public class ShopServicePRO implements ShopService {
    private final List<Product> productList;

    private double vat;

    private double discount;

    public ShopServicePRO(@Value("${shop-service-pro.vat}") double vat, @Value("${shop-service-pro.discount}") double discount) {
        this.vat = vat;
        this.discount = discount;

        Random rand = new Random();

        Product p1 = new Product("Telefon - pro", round((rand.nextInt(250) + 50) * (1 + vat / 100) * (1 - discount / 100), 2));
        Product p2 = new Product("Ksiazka - pro", round((rand.nextInt(250) + 50) * (1 + vat / 100) * (1 - discount / 100), 2));
        Product p3 = new Product("Wazon - pro", round((rand.nextInt(250) + 50) * (1 + vat / 100) * (1 - discount / 100), 2));
        Product p4 = new Product("Monitor - pro", round((rand.nextInt(250) + 50) * (1 + vat / 100) * (1 - discount / 100), 2));
        Product p5 = new Product("krzeslo - pro", round((rand.nextInt(250) + 50) * (1 + vat / 100) * (1 - discount / 100), 2));

        productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
    }
    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
    @EventListener(ApplicationReadyEvent.class)
    public List<Product> getProductList() {

        System.out.println(productList.get(0).name);
        return productList;
    }
}
