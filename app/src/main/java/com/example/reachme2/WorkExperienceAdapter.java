package com.example.reachme2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class WorkExperienceAdapter extends BaseAdapter {
    private Context context;
    private List<WorkExperienceItem> workExperienceList;
    private LayoutInflater inflater;

    public WorkExperienceAdapter(Context context,List<WorkExperienceItem> workExperienceList){
        this.context = context;
        this.workExperienceList = workExperienceList;
        this.inflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return workExperienceList.size();
    }

    @Override
    public WorkExperienceItem getItem(int position) {
        return workExperienceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_work_experience_item,null);

        return view;
    }
}
