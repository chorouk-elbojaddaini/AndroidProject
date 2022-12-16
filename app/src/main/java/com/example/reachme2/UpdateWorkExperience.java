package com.example.reachme2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UpdateWorkExperience extends AppCompatActivity {

    EditText jobTitleEdit,companyNameEdit ,specialization,companyIndustry,positionLevel,startDate,endDate,jobDescription ;
    CheckBox iCurrenltyWorkHere;
    DBHelper DB ;
    TextView saveUpdatedWork;
    TextView startDateTextView,endDateTextView;
    int isCurrentlyWorkHereTxt;
    String startDateDate;
    String endDateDate;
    String email="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_work_experience);

        //Intent intent = getIntent();
        //Bundle extras = intent.getExtras();
       /* String name = extras.getString("email");
        Cursor cursor = DB.viewData(name);

        StringBuilder email = new StringBuilder();


        while(cursor.moveToNext()){

            email.append(""+cursor.getString(0));

        }
        String emailString = email.toString();
        */
        DB= new DBHelper(UpdateWorkExperience.this);
         Cursor userEmailCursor =  DB.getEmail();

        if(userEmailCursor.moveToFirst()){
              email =    userEmailCursor.getString(0);
                Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
        }




        Intent intent  = getIntent();
        workExperience workExperienceItem = (workExperience) intent.getSerializableExtra("workExperienceItem");

        startDate = findViewById(R.id.start_date_update);
        startDateTextView = findViewById(R.id.start_date_text_view_update);
        endDate   = findViewById(R.id.end_date_update);
        endDateTextView = findViewById(R.id.end_date_text_view_update);

        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        startDateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog = new DatePickerDialog(UpdateWorkExperience.this, new DatePickerDialog.OnDateSetListener() {
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
                DatePickerDialog dialog = new DatePickerDialog(UpdateWorkExperience.this, new DatePickerDialog.OnDateSetListener() {
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


        jobTitleEdit = findViewById(R.id.job_title_edit_text_update);
        companyNameEdit = findViewById(R.id.company_name_edit_text_update);
        specialization = findViewById(R.id.specialization_edit_text_update);
        companyIndustry = findViewById(R.id.company_industry_edit_text_update);
        positionLevel  = findViewById(R.id.position_edit_text_update);
        startDate = findViewById(R.id.start_date_update);
        endDate = findViewById(R.id.end_date_update);
        iCurrenltyWorkHere = findViewById(R.id.checkbox_work_here_update);
        saveUpdatedWork = findViewById(R.id.saveWorkExperienceUpdate);

        iCurrenltyWorkHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        jobDescription = findViewById(R.id.job_description_update);



        int id = workExperienceItem.getId();
        String idText = id+"";
        jobTitleEdit.setText(workExperienceItem.getJobTitle());
        companyNameEdit.setText(workExperienceItem.getCompanyName());
        specialization.setText(workExperienceItem.getSpecialization());
        companyIndustry.setText(workExperienceItem.getCompanyIndustry());
        positionLevel.setText(workExperienceItem.getPositionLevel());
        startDate.setText(workExperienceItem.getStartDate());
        String startDateTxt = workExperienceItem.getStartDate().toString();

        endDate.setText(workExperienceItem.getEndDate());
        jobDescription.setText(workExperienceItem.getJobDescription());
        if(workExperienceItem.getICurrentlyWorkHere()==1){
            iCurrenltyWorkHere.setChecked(true);

        }
        else{
            iCurrenltyWorkHere.setChecked(false);

        }





        saveUpdatedWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String jobTitleTxt = jobTitleEdit.getText().toString();
                String companyNameTxt = companyNameEdit.getText().toString();
                String specializationTxt =specialization.getText().toString();
                String companyIndustryTxt = companyIndustry.getText().toString();
                String positionLevelTxt = positionLevel.getText().toString();
                String startDateTxt = startDate.getText().toString();
                String endDateTxt = endDate.getText().toString();
                String jobDescriptionTxt = jobDescription.getText().toString();
                if(iCurrenltyWorkHere.isChecked()){
                    isCurrentlyWorkHereTxt=1;
                }
                else{
                    isCurrentlyWorkHereTxt = 0;
                }
                 //workExperience wE = new workExperience(jobTitleTxt,companyNameTxt,specializationTxt,companyIndustryTxt,positionLevelTxt,startDateTxt,endDateTxt,isworking,jobDescriptionTxt);
                workExperience wE = new workExperience(jobTitleTxt,companyNameTxt,companyIndustryTxt,specializationTxt,positionLevelTxt,startDateDate,endDateDate,isCurrentlyWorkHereTxt,jobDescriptionTxt);
                boolean isUpdated =  DB.updateWorkExperience(wE,id,userEmailClass.email);
                if(isUpdated){
                    Toast.makeText(UpdateWorkExperience.this, "data succefuly updated", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(UpdateWorkExperience.this, "somting went wrong", Toast.LENGTH_SHORT).show();
                }
                finish();

            }
        });


        /*if(isInserted){
            Toast.makeText(UpdateWorkExperience.this, "data succefuly updated", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(UpdateWorkExperience.this, "somting went wrong", Toast.LENGTH_SHORT).show();
        }
        finish();
*/

    }
}