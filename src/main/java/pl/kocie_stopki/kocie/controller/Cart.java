package pl.kocie_stopki.kocie.controller;


import pl.kocie_stopki.kocie.entity.Item;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items;

    public Cart(){
        items = new ArrayList<>();

    }
    public void addItem(final String name,final Double price,final String description,final int quantity, final String imageLink){
        double FinalPrice = 0;
        items.add(new Item( name, price,  description, quantity, imageLink));
        System.out.println("Added Item id" + "name " + name );
        System.out.println(", quantity " +quantity + ", price " + price);
        for (int i = 0; i<items.size(); i++){
            FinalPrice+= quantity * price;
            System.out.println("Cart value  = " + FinalPrice);
        }
    }
}
