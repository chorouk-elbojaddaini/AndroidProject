package com.example.reachme2;

import android.content.ClipData;
import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class WorkExperienceAdapter extends BaseAdapter {
    private Context context;
    private List<workExperience> workExperienceList;
    private LayoutInflater inflater;
    private ItemClickListener mItemListener;
    public WorkExperienceAdapter(Context context,List<workExperience> workExperienceList){
        this.context = context;
        this.workExperienceList = workExperienceList;
        this.inflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return workExperienceList.size();
    }

    public interface ItemClickListener{
        void onItemClick(Call.Details details);
    }

    @Override
    public workExperience getItem(int position) {
        return workExperienceList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.adapter_work_experience_item,null);
        workExperience currentItem = getItem(position);
        String workExperienceItemJobTitle = currentItem.getJobTitle();
        TextView itemJobTitle = view.findViewById(R.id.job_title);
        itemJobTitle.setText(workExperienceItemJobTitle);
        return view;
    }
}
