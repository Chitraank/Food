package com.example.intern_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Suggestions extends AppCompatActivity {
    FloatingActionButton fabSuggestions;
    ImageView img_sad, img_nuetral, img_satis, img_happy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);

        fabSuggestions= findViewById(R.id.fab_suggestions);
        fabSuggestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Suggestions.this, Dashboard.class);
                startActivity(i);
            }
        });

        img_sad= findViewById(R.id.sad);
        img_nuetral= findViewById(R.id.nuetral);
        img_satis= findViewById(R.id.satisfactory);
        img_happy= findViewById(R.id.happy);

//        img_sad.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                img_sad.set
//            }
//        });
    }
}
