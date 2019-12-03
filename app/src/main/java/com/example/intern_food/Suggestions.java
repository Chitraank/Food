package com.example.intern_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Suggestions extends AppCompatActivity {
    FloatingActionButton fabSuggestions;
    ImageView img_sad, img_nuetral, img_satis, img_happy;
    EditText title,suggestion;
    RadioButton radioButton;
    RadioGroup radioGroup;
    String overallExp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestions);
        title=findViewById(R.id.suggestion_title);
        suggestion=findViewById(R.id.suggestion);
        radioGroup=findViewById(R.id.radio_grp_issue_type);

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
    public void submitSuggestions(View view)
    {

        int radioId=radioGroup.getCheckedRadioButtonId();
        radioButton=findViewById(radioId);


    }
    public void happy(View view)
    {
        overallExp="Happy";
        img_happy.setImageResource(R.drawable.mood_happy_pink);
        img_satis.setImageResource(R.drawable.mood_satisfy);
        img_nuetral.setImageResource(R.drawable.mood_nuetral);
        img_sad.setImageResource(R.drawable.mood_bad);
    }
    public void satis(View view)
    {
        overallExp="Satisfactory";
        img_happy.setImageResource(R.drawable.mood_happy);
        img_satis.setImageResource(R.drawable.mood_satisfy);
        img_nuetral.setImageResource(R.drawable.mood_nuetral);
        img_sad.setImageResource(R.drawable.mood_bad);
    }
    public void neut(View view)
    {
        overallExp="Neutral";
        img_happy.setImageResource(R.drawable.mood_happy);
        img_satis.setImageResource(R.drawable.mood_satisfy);
        img_nuetral.setImageResource(R.drawable.mood_nuetral_pink);
        img_sad.setImageResource(R.drawable.mood_bad);
    }
    public void sad(View view)
    {
        overallExp="Sad";
        img_happy.setImageResource(R.drawable.mood_happy);
        img_satis.setImageResource(R.drawable.mood_satisfy);
        img_nuetral.setImageResource(R.drawable.mood_nuetral);
        img_sad.setImageResource(R.drawable.mood_bad_pink);
    }
}
