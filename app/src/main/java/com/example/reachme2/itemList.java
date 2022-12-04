package com.example.reachme2;

public class itemList {

    //fields
    private String name;
    private String mnemonic;
    private double price;


    //constructor
    public itemList(String name,String mnemonic,double price) {
        this.name = name;
        this.price = price;
        this.mnemonic = mnemonic;
    }
    //methods
    public String getName() { return name; }
    public String getMnemonic(){ return mnemonic;}
    public double getPrice(){ return price;}


}