package com.example.intern_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Signup extends AppCompatActivity {

    Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signUp= findViewById(R.id.btn_sign_in);
        Intent i = new Intent(Signup.this, Dashboard.class);
        startActivity(i);
    }
}
