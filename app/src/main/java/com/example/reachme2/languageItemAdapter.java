package com.example.reachme2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class languageItemAdapter extends BaseAdapter {

    //fields
    private Context context;
    private List<LanguageItem> languageItemList;
    private LayoutInflater inflater;

    //constructor
    public languageItemAdapter(Context context , List<LanguageItem> languageItemList){
        this.context  = context;
        this.languageItemList = languageItemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return languageItemList.size();
    }

    @Override
    public LanguageItem getItem(int position) {
        return languageItemList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_language_item,null);



        //getInformation about item
        LanguageItem currentItem = getItem(i);
        String languageName = currentItem.getLanguageName();

        //get item name view
        TextView itemNameView = view.findViewById(R.id.language_item);
        itemNameView.setText(languageName);

        return view;
    }
}
