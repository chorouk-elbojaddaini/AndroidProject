
package com.example.reachme2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AddLanguages extends AppCompatActivity implements View.OnClickListener {
    TextView cancelLanguage;
    TextView addLanguage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_languages);
        cancelLanguage = findViewById(R.id.cancelLanguages);

        cancelLanguage.setOnClickListener(this);
        addLanguage = findViewById(R.id.addLangugelink);
        addLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddLanguages.this,LanguagesListView.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onClick(View view) {
        finish();
    }
}
