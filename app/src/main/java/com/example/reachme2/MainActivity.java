package com.example.reachme2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button submit;
    private Button signUp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.submit = findViewById(R.id.login);
        this.signUp = findViewById(R.id.signUp);

        submit.setOnClickListener(this);
        signUp.setOnClickListener(this);




    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login :
                startActivity(new Intent(this,SignIn.class));
                break;
            case R.id.signUp:
                startActivity(new Intent(this,SignUp.class));

                break;
        }

    }
}