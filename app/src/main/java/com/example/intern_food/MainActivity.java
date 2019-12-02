package com.example.intern_food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        //reference.setValue("Hello");
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser!=null)
        {
            Intent intent=new Intent(MainActivity.this,Dashboard.class);
            intent.putExtra("UserId",mAuth.getUid());
            startActivity(intent);
           // startActivity(new Intent(MainActivity.this,Dashboard.class));
        }
        else
        {
            startActivity(new Intent(MainActivity.this,Sign_in_up.class));
        }
        // updateUI(currentUser);
    }
}
