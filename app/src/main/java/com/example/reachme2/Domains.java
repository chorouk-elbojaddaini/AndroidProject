package com.example.reachme2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Domains extends AppCompatActivity {
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domains);
        List<HighTechItem> itemListse = new ArrayList<>();
        DB = new DBHelper(this);
        itemListse.add(new HighTechItem("Computer/Information Technology","computer"));
       // itemListse.add(new HighTechItem("Accounting","finance"));
        itemListse.add(new HighTechItem("Admin/Human Ressources","admin"));
        //itemListse.add(new HighTechItem("Building","building"));
        //LitemListse.add(new HighTechItem("Arts/Media/Communication","media"));
        //itemListse.add(new HighTechItem("Education/Training","education"));
        itemListse.add(new HighTechItem("Enginnering","engineering"));
       // itemListse.add(new HighTechItem("Hotel/Restaurant","hotel"));
        //itemListse.add(new HighTechItem("Education","education"));
        itemListse.add(new HighTechItem("Healthcare","health"));
        itemListse.add(new HighTechItem("Sales/Marketing","marketing"));
        itemListse.add(new HighTechItem("Manufacturing","manufacturing"));

        ListView listview = findViewById(R.id.domains_list_view);
        listview.setAdapter(new HighTechItemAdapter(this,itemListse));

        listview.setClickable(true);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HighTechItem item = (HighTechItem) listview.getItemAtPosition(i);
                boolean isInserted = DB.insertDomaine(item.getName(),userEmailClass.email);
                if(isInserted){
                    Toast.makeText(Domains.this, "your domaine has been inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Domains.this, "somting went wrong", Toast.LENGTH_SHORT).show();
                }
                finish();



            }
        });
    }
}