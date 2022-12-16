package com.example.reachme2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.Calendar;

public class addWorkExperience extends AppCompatActivity implements Serializable {
    TextView cancelWorkExp ,saveWorkExperience,startDateTextView,endDateTextView;
    EditText jobTitle , companyName,specialization,companyIndustry,positionLevel,startDate ,endDate,jobDescription;
    DialogInterface.OnClickListener setListner;
    DBHelper DB;
    private CheckBox currentlyWorkHere;
    int isCurrentlyWorkHereTxt =0;
    String startDateDate;
    String endDateDate;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_work_experience);
        startDate = findViewById(R.id.start_date);
        startDateTextView = findViewById(R.id.start_date_text_view);
        endDate   = findViewById(R.id.end_date);
        endDateTextView = findViewById(R.id.end_date_text_view);






        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        startDateTextView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 DatePickerDialog dialog = new DatePickerDialog(addWorkExperience.this, new DatePickerDialog.OnDateSetListener() {
                     @Override
                     public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                         month = month + 1;
                         startDateDate = dayOfMonth + "/" + month + "/" + year;
                         startDate.setText(startDateDate);
                     }

                 }, year, month, day);
                 dialog.show();
             }
         });
        endDateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(addWorkExperience.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        endDateDate = dayOfMonth + "/" + month + "/" + year;
                        endDate.setText(endDateDate);
                    }

                }, year, month, day);
                dialog.show();
            }
        });

        cancelWorkExp = findViewById(R.id.cancelWorkExp);
        cancelWorkExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        jobTitle = findViewById(R.id.job_title_edit_text);
        companyName = findViewById(R.id.company_name_edit_text);
        specialization = findViewById(R.id.specialization_edit_text);
        companyIndustry = findViewById(R.id.company_industry_edit_text);
        positionLevel = findViewById(R.id.position_edit_text);
        saveWorkExperience = findViewById(R.id.saveWorkExperience);
        currentlyWorkHere = findViewById(R.id.checkbox_work_here);
        jobDescription = findViewById(R.id.job_description);
        currentlyWorkHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // isCurrentlyWorkHereTxt =1;
            }
        });
        String isWorking = isCurrentlyWorkHereTxt+"";

        DB= new DBHelper(addWorkExperience.this);

       String name = this.getIntent().getStringExtra("email");
        Cursor cursor = DB.viewData(name);

        StringBuilder email = new StringBuilder();


        while(cursor.moveToNext()){

            email.append(""+cursor.getString(0));

        }
        //String emailString = email.toString();


        saveWorkExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailString ="";
                Cursor userEmailCursor =  DB.getEmail();

                if(userEmailCursor.moveToFirst()){
                     emailString =    userEmailCursor.getString(0);
                    String jobTitleTxt =jobTitle.getText().toString();
                    String companyNameTxt = companyName.getText().toString();
                    String specializationTxt =specialization.getText().toString();
                    String companyIndustryTxt = companyIndustry.getText().toString();
                    String positionLevelTxt = positionLevel.getText().toString();
                    String startDateTxt = startDate.getText().toString();
                    String endDateTxt = endDate.getText().toString();
                    String jobDescriptionTxt = jobDescription.getText().toString();


                    workExperience wE = new workExperience(jobTitleTxt,companyNameTxt,specializationTxt,companyIndustryTxt,positionLevelTxt,startDateDate,endDateDate,isCurrentlyWorkHereTxt,jobDescriptionTxt);
                    boolean isInserted = DB.insertWorkExperience(wE,userEmailClass.email);
                    if(isInserted){
                        Toast.makeText(addWorkExperience.this, "data succefuly inserted", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(addWorkExperience.this, "somting went wrong", Toast.LENGTH_SHORT).show();
                    }
                    finish();
                }




            }

        });

    }





}

