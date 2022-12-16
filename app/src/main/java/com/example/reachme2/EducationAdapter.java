package com.example.reachme2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class EducationAdapter extends BaseAdapter {
    private Context context;
    private List<Education> educationList;
    private LayoutInflater inflater;

    public EducationAdapter(Context context,List<Education> educationList){
        this.context  = context;
        this.educationList = educationList;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return educationList.size() ;
    }

    @Override
    public Education getItem(int position) {
        return educationList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_education_item,null);
        Education currentItem = getItem(position);

        String institute = currentItem.getInstitute();
        String yearOfGraduation = currentItem.getYearOfGraduation();
        String fieldOfStudies = currentItem.getFieldOfStudies();

        TextView instituteTextView  = view.findViewById(R.id.institute);
        TextView yearOfGraduationTextView  = view.findViewById(R.id.year_of_graduation);
        TextView fieldOfStudiesTextView = view.findViewById(R.id.field_of_studies);

        instituteTextView.setText(institute);
        yearOfGraduationTextView.setText(yearOfGraduation);
        fieldOfStudiesTextView.setText(fieldOfStudies);
        return view;
    }
}
