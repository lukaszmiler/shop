package com.lukas.shop;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Profile("start")
public class ShopServiceSTART implements ShopService{

    private final List<Product> productList;


    public ShopServiceSTART(){
        Random rand = new Random();

        Product p1 = new Product("Telefon", rand.nextInt(250) + 50);
        Product p2 = new Product("Ksiazka", rand.nextInt(250) + 50);
        Product p3 = new Product("Wazon", rand.nextInt(250) + 50);
        Product p4 = new Product("Monitor", rand.nextInt(250) + 50);
        Product p5 = new Product("krzeslo", rand.nextInt(250) + 50);

        productList = new ArrayList<>();
        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
    }

    @EventListener(ApplicationReadyEvent.class)
    public List<Product> getProductList() {
        return productList;
    }
}
