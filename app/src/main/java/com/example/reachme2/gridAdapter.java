package com.example.reachme2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class gridAdapter extends BaseAdapter {
    private Context context;
    private List<itemlistsearch> itemLists;
    private LayoutInflater inflater;

    //constructor
    public gridAdapter(Context context,List<itemlistsearch> itemLists){
        this.context = context;
        this.itemLists = itemLists;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount()  {
        return itemLists.size();
    }

    @Override
    public itemlistsearch getItem(int position) {
        return itemLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.singleframe,null);

        itemlistsearch currentItem = getItem(position);
        String itemName = currentItem.getName();
        String itemMnemonic = currentItem.getMnemonic();


        //get item name and description view
        TextView itemNameView = view.findViewById(R.id.item_spec);
        itemNameView.setText(itemName);


        //get image
        ImageView itemMnemonicView = view.findViewById(R.id.grid_image);
        String RessourceName = itemMnemonic;
        int RId = context.getResources().getIdentifier(RessourceName,"drawable",context.getPackageName());
        itemMnemonicView.setImageResource(RId);

        return view;
    }
}
