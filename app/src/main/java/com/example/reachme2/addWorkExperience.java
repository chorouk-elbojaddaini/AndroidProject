package com.example.reachme2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class addWorkExperience extends AppCompatActivity implements View.OnClickListener {
    TextView cancelWorkExp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work_experience);
        cancelWorkExp = findViewById(R.id.cancelWorkExp);
        cancelWorkExp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}