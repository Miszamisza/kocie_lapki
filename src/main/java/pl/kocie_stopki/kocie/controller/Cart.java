package pl.kocie_stopki.kocie.controller;


import pl.kocie_stopki.kocie.entity.Item;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> items;

    public Cart(){
        items = new ArrayList<>();

    }
    public void addItem(final int id,final String name,final Double price,final int quantity){
        double FinalPrice = 0;
        items.add(new Item(id, name, price,quantity));
        System.out.println("Added Item id = " + id + ", name " + name );
        System.out.println(", quantity " +quantity + ", price " + price);
        for (int i = 0; i<items.size(); i++){
            FinalPrice+= quantity * price;
        }
    }
}
