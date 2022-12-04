package com.example.reachme2;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class SignIn extends AppCompatActivity implements View.OnClickListener{
private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btnSignIn = (Button) findViewById(R.id.signIn);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent myIntent = new Intent(getApplicationContext(),ProfileActivity.class);
        startActivity(myIntent);
    }
}