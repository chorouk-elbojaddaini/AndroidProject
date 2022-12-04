package com.example.reachme2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LanguagesListView extends AppCompatActivity {
    TextView cancelLanguagesListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cancelLanguagesListView = findViewById(R.id.cancelLanguagesListView);
        /*
        cancelLanguagesListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LanguagesListView.this,AddLanguages.class);
                startActivity(intent);
            }
        });*/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages_list_view);

        //list of languages
        List<LanguageItem> languagesList = new ArrayList<LanguageItem>();
        languagesList.add(new LanguageItem("Arabic"));
        languagesList.add(new LanguageItem("English"));
        languagesList.add(new LanguageItem("Frensh"));
        languagesList.add(new LanguageItem("German"));

        //get list view
        ListView languagesListView = findViewById(R.id.languages_list_view);
        languagesListView.setAdapter(new languageItemAdapter(this,languagesList));
    }
}