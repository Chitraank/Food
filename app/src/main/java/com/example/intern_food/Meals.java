package com.example.intern_food;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class Meals extends AppCompatActivity {
    FirebaseAuth mAuth;
    private CheckBox BreakFast,Lunch,Snacks,Dinner;
    private Boolean isBrkfst,isLnch,isSncks,isDinnr;
    private HashMap<String,Object>mealSelect=new HashMap<>();
    DatabaseReference mealref= FirebaseDatabase.getInstance().getReference().child("MealSelected");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        mAuth=FirebaseAuth.getInstance();
        BreakFast=findViewById(R.id.check_breakfast);
        Lunch=findViewById(R.id.check_lunch);
        Snacks=findViewById(R.id.check_snacks);
        Dinner=findViewById(R.id.check_dinner);

    }

    public void addDataToHashMap(View view) {
    if(BreakFast.isChecked())
    {
        mealSelect.put("breakfast",true);
    }
    else
    {
        mealSelect.put("breakfast",false);
    }
    if(Lunch.isChecked())
        {
            mealSelect.put("lunch",true);
        }
    else
        {
            mealSelect.put("lunch",false);
        }
    if(Snacks.isChecked())
        {
            mealSelect.put("snacks",true);
        }
    else
        {
            mealSelect.put("snacks",false);
        }
    if(Dinner.isChecked())
        {
            mealSelect.put("dinner",true);
        }
    else
        {
            mealSelect.put("dinner",false);
        }
        addDataToDb();
    }

    private void addDataToDb() {



    }

}
