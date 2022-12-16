package com.example.reachme2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddSkill extends AppCompatActivity implements View.OnClickListener {
    TextView cancelSkill ,addSkill ;
    EditText skillNameET,proficiencyET;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_skill);
        cancelSkill = findViewById(R.id.cancelSkill);
        cancelSkill.setOnClickListener(this);
        skillNameET = findViewById(R.id.skill_name);
        proficiencyET = findViewById(R.id.proficiency);
        addSkill = findViewById(R.id.addSkillBtn);
        addSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DB = new DBHelper(AddSkill.this);
                String skillNameTxt = skillNameET.getText().toString();
                String proficiencyTxt = proficiencyET.getText().toString();
                Skill skill = new Skill(skillNameTxt,proficiencyTxt);
                boolean isInserted = DB.insertSkill(skill,userEmailClass.email);
                if(isInserted){
                    Toast.makeText(AddSkill.this, "data succefuly inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AddSkill.this, "somting went wrong", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        finish();
    }

}