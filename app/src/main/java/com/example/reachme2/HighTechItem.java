package com.example.reachme2;

public class HighTechItem {
    //fields
    private String name;
    private String mnemonic;

    //constructor

    public HighTechItem(String name ,String mnemonic) {

        this.name = name;
        this.mnemonic = mnemonic;
    }

    //methods
    public String getName(){return name;}
    public String getMnemonic(){return mnemonic;}
}
