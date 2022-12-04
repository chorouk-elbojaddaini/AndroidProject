package com.example.reachme2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AddSkill extends AppCompatActivity implements View.OnClickListener {
    TextView cancelSkill ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_skill);
        cancelSkill = findViewById(R.id.cancelSkill);
        cancelSkill.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }

}