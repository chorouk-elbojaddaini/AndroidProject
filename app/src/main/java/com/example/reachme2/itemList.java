package com.example.reachme2;

import java.io.Serializable;

public class itemList implements Serializable {

    //fields
    private int id;
    private String name;
    private String mnemonic;
    private String description;
    private String image;
    private String domaine;
    private int isSaved;
    //constructor
    public itemList(int id,String name,String mnemonic,String description,String image,String domaine,int isSaved) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.mnemonic = mnemonic;
        this.image = image;
        this.domaine = domaine;
        this.isSaved = isSaved;
    }

    //methods
    public String getName() { return name; }
    public String getMnemonic(){ return mnemonic;}
    public String getDescription(){ return description;}
    public String getImage(){return image;}
    public String getDomaine(){return domaine;}
    public int getIsSaved(){return isSaved;}

}