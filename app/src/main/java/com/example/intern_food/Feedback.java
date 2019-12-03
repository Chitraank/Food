package com.example.intern_food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Feedback extends AppCompatActivity {

    CardView brkfast, lunch, snacks, dinner;
    FloatingActionButton fabFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        fabFeedback= findViewById(R.id.fab_feedback);
        fabFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Feedback.this, Dashboard.class);
                startActivity(i);
            }
        });

        brkfast = findViewById(R.id.card_breakfast_item);
        lunch = findViewById(R.id.card_lunch_item);
        snacks = findViewById(R.id.card_snack_item);
        dinner = findViewById(R.id.card_dinner_item);

//
//        brkfast.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadFragment(new FeedbackFragment());
//
//            }
//        });
//
//        lunch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                loadFragment(new FeedbackFragment());
//            }
//        });
//
//        snacks.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadFragment(new FeedbackFragment());
//
//            }
//        });
//
//        dinner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                loadFragment(new FeedbackFragment());
//
//            }
//        });
//
//    }
//
//    private void loadFragment(Fragment fragment) {
//// create a FragmentManager
//        FragmentManager fm = getFragmentManager();
//// create a FragmentTransaction to begin the transaction and replace the Fragment
//        FragmentTransaction fragmentTransaction = fm.beginTransaction();
//// replace the FrameLayout with new Fragment
//        fragmentTransaction.replace(R.id.feedback_fragment, fragment);
//        fragmentTransaction.commit(); // save the changes
    }
}
