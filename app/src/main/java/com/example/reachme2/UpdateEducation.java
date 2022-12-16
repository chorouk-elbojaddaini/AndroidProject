package com.example.reachme2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateEducation extends AppCompatActivity implements View.OnClickListener {
    TextView cancelEducation , saveEducation;
    EditText educationLevel , institute,fieldOfStudies,location,yearOfGraduation,monthOfGraduation,grade,additionalInformation;
    DBHelper DB;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_education);

        Intent intent  = getIntent();
        Education educationItem = (Education) intent.getSerializableExtra("educationItem");
        DB= new DBHelper(UpdateEducation.this);
        cancelEducation = findViewById(R.id.cancel_Education_update);
        saveEducation = findViewById(R.id.save_education_update);

        educationLevel = findViewById(R.id.educationLevel_update);
        institute = findViewById(R.id.institute_update);
        fieldOfStudies = findViewById(R.id.field_of_studies_update);
        location = findViewById(R.id.location_update);
        yearOfGraduation = findViewById(R.id.year_of_graduation_update);
        monthOfGraduation = findViewById(R.id.month_of_graduation_update);
        grade = findViewById(R.id.grade_update);
        additionalInformation = findViewById(R.id.additional_information_update);

        cancelEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        int id = educationItem.getId();
        educationLevel.setText(educationItem.getEducationLevel());
        institute.setText(educationItem.getInstitute());
        fieldOfStudies.setText(educationItem.getFieldOfStudies());
        location.setText(educationItem.getLocation());
        yearOfGraduation.setText(educationItem.getYearOfGraduation());
        monthOfGraduation.setText(educationItem.getMonthOfGraduation());
        grade.setText(educationItem.getGrade());
        additionalInformation.setText(educationItem.getAdditionalInformation());
        saveEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor userEmailCursor =  DB.getEmail();

                if(userEmailCursor.moveToFirst()){
                    email =    userEmailCursor.getString(0);

                }
                String educationLevelTxt = educationLevel.getText().toString();
                String instituteTxt = institute.getText().toString();
                String fieldOfStudiesTxt = fieldOfStudies.getText().toString();
                String locationTxt = location.getText().toString();
                String yearOfGraduationTxt = yearOfGraduation.getText().toString();
                String monthOfGraduationTxt = monthOfGraduation.getText().toString();
                String gradeTxt = grade.getText().toString();
                String additionalInformationTxt = additionalInformation.getText().toString();

               Education education = new Education(educationLevelTxt,instituteTxt,fieldOfStudiesTxt,locationTxt,yearOfGraduationTxt,monthOfGraduationTxt,gradeTxt,additionalInformationTxt);
               boolean isUpdated =  DB.updateEducation(education,id,userEmailClass.email);
                if(isUpdated){
                    Toast.makeText(UpdateEducation.this, "data succefuly updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(UpdateEducation.this, "somting went wrong", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });


    }

    @Override
    public void onClick(View view) {

    }
}