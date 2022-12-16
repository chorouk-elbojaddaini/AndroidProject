package com.example.reachme2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LanguagesListView extends AppCompatActivity {
    TextView cancelLanguagesListView;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages_list_view);
        cancelLanguagesListView = findViewById(R.id.cancelLanguagesListView);
        DB = new DBHelper(LanguagesListView.this);
        /*
        cancelLanguagesListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LanguagesListView.this,AddLanguages.class);
                startActivity(intent);
            }
        });*/



        //list of languages
        List<Languages> languagesList = new ArrayList<Languages>();
        languagesList.add(new Languages("Arabic"));
        languagesList.add(new Languages("English"));
        languagesList.add(new Languages("Frensh"));
        languagesList.add(new Languages("German"));
        languagesList.add(new Languages("Mandarin Chinese"));
        languagesList.add(new Languages("spanish"));
        languagesList.add(new Languages("Russian"));
        languagesList.add(new Languages("Portuguese"));
        languagesList.add(new Languages("Urdu"));
        languagesList.add(new Languages("Japanese"));
        languagesList.add(new Languages("Turkish"));
        languagesList.add(new Languages("Tamil"));

        //get list view
        ListView languagesListView = findViewById(R.id.languages_list_view);
        languagesListView.setAdapter(new languageItemAdapter(this,languagesList));


        languagesListView.setClickable(true);

        languagesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Languages item = (Languages) languagesListView.getItemAtPosition(i);
                boolean isInserted = DB.insertLanguage(item,userEmailClass.email);
                if(isInserted){
                    Toast.makeText(LanguagesListView.this, "your language has been inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(LanguagesListView.this, "somting went wrong", Toast.LENGTH_SHORT).show();
                }
                finish();



            }
        });
    }
}