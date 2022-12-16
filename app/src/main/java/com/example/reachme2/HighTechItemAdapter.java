package com.example.reachme2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HighTechItemAdapter extends BaseAdapter {
    //fields
    private Context context;
    private List<HighTechItem> HighTechItemList;
    private LayoutInflater inflater;

    public HighTechItemAdapter(Context context, List<HighTechItem> highTechItemList) {
        this.context = context;
        this.HighTechItemList = highTechItemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return HighTechItemList.size();
    }

    @Override
    public HighTechItem getItem(int position) {
        return HighTechItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.singleframe,null);
        HighTechItem currentItem = getItem(position);
        String ItemName = currentItem.getName();
        String ItemMnemonic = currentItem.getMnemonic();

        //get icon item view
        ImageView itemImage = convertView.findViewById(R.id.imgSearch);

        int resId=context.getResources().getIdentifier(ItemMnemonic,"drawable",context.getPackageName());
        itemImage.setImageResource(resId);
        //get Item view
        TextView itemNameView = convertView.findViewById(R.id.item_spec);
        itemNameView.setText(ItemName);
        return convertView;
    }
}
