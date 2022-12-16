package com.example.reachme2;

import android.app.Application;

public  class userEmailClass extends Application {
    static public String email = "";

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        email = email;
    }


}