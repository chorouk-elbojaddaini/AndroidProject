package com.example.reachme2;

import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SkillAdapter extends BaseAdapter {

    private Context context;
    private List<Skill> SkillList;
    private LayoutInflater inflater;
    private SkillAdapter.ItemClickListener mItemListener;


    public SkillAdapter(Context context,List<Skill> SkillList){
        this.context = context;
        this.SkillList = SkillList;
        this.inflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return SkillList.size();
    }

    public interface ItemClickListener{
        void onItemClick(Call.Details details);
    }

    @Override
    public Skill getItem(int position) {
        return SkillList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.skill_item_layout,null);
        Skill currentItem = getItem(position);
        String skillName1 = currentItem.getSkillName();
        TextView skillName = view.findViewById(R.id.skill_name_item);
        skillName.setText(skillName1);
        return view;
    }
}
