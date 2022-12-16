package com.example.reachme2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddEducation extends AppCompatActivity implements View.OnClickListener {
    TextView cancelEducation , saveEducation;
    EditText educationLevel , institute,fieldOfStudies,location,yearOfGraduation,monthOfGraduation,grade,additionalInformation;
    DBHelper DB;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_education);
        cancelEducation = findViewById(R.id.cancelEducation);
        cancelEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            };
        });
        saveEducation = findViewById(R.id.save_education);

       educationLevel = findViewById(R.id.educationLevel);
        institute = findViewById(R.id.institute);
        fieldOfStudies = findViewById(R.id.field_of_studies_add);
        location = findViewById(R.id.location);
        yearOfGraduation = findViewById(R.id.year_of_graduation);
        monthOfGraduation = findViewById(R.id.month_of_graduation);
        grade = findViewById(R.id.grade);
        additionalInformation = findViewById(R.id.additional_information);

        saveEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String educationLeveltxt = educationLevel.getText().toString();
                DB= new DBHelper(AddEducation.this);
                Cursor userEmailCursor =  DB.getEmail();

                if(userEmailCursor.moveToFirst()){
                    email =    userEmailCursor.getString(0);

                }
                String instituteTxt = institute.getText().toString();
                String fieldOfStudiesTxt = fieldOfStudies.getText().toString();
                String locationTxt  = location.getText().toString();
                String yearOfGraduationTxt = yearOfGraduation.getText().toString();
                String monthOfGraduationTxt = monthOfGraduation.getText().toString();
                String gradeTxt = grade.getText().toString();
                String additionalInformationTxt = additionalInformation.getText().toString();
               // Education education = new Education(educationLeveltxt,instituteTxt,fieldOfStudiesTxt,locationTxt,yearOfGraduationTxt,monthOfGraduationTxt,gradeTxt,additionalInformationTxt);
               Education education = new Education(educationLeveltxt,instituteTxt,fieldOfStudiesTxt,locationTxt,yearOfGraduationTxt,monthOfGraduationTxt,gradeTxt,additionalInformationTxt);
               boolean isInserted = DB.insertEducation(education,userEmailClass.email);
                if(isInserted){
                    Toast.makeText(AddEducation.this, "data succefuly inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AddEducation.this, "somting went wrong", Toast.LENGTH_SHORT).show();
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