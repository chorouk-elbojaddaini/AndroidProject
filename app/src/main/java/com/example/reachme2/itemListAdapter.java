package com.example.reachme2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class itemListAdapter extends BaseAdapter{

    //fields
    private Context context;
    private List<itemList> itemLists;
    private LayoutInflater inflater;
    public void setFilteredList(List<itemList> filteredList){
        this.itemLists = filteredList;
        notifyDataSetChanged();
    }

    //constructor
    public itemListAdapter(Context context,List<itemList> itemLists){
        this.context = context;
        this.itemLists = itemLists;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemLists.size();
    }

    @Override
    public itemList getItem(int position) {
        return itemLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    //personnaliser chaque item
    public View getView(int position, View view, ViewGroup parent) {
        view = inflater.inflate(R.layout.adapter_item,null);

        itemList currentItem = getItem(position);
        String itemName = currentItem.getName();
        String itemMnemonic = currentItem.getMnemonic();
        String itemDescription = currentItem.getDescription();
        String image = currentItem.getImage();
        //get item name and description view
        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);
        TextView itemPriceView = view.findViewById(R.id.item_description);
        itemPriceView.setText(itemDescription);
        //get image
        ImageView itemMnemonicView = view.findViewById(R.id.item_image);

        String RessourceName = itemMnemonic;
        int RId = context.getResources().getIdentifier(RessourceName,"drawable",context.getPackageName());
        itemMnemonicView.setImageResource(RId);

        ImageView imageView = view.findViewById(R.id.image_logo);

        String resourceLogoImage = image;
        int rLogoImage = context.getResources().getIdentifier(resourceLogoImage,"drawable",context.getPackageName());
        imageView.setImageResource(rLogoImage);

        return view;
}
}