package com.example.reachme2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AddEducation extends AppCompatActivity implements View.OnClickListener {
    TextView cancelEducation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_education);
        cancelEducation = findViewById(R.id.cancelEducation);
        cancelEducation.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}