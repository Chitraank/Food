package com.example.intern_food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Signup extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText Name,Email,Password,MobNo,RollNo,Branch,Hostel,RoomNo;
    String name,email,password,mobNo,rollNo,branch,hostel,roomNo;
    FirebaseDatabase db=FirebaseDatabase.getInstance();
    DatabaseReference userRef= db.getReference().child("User");
    DatabaseReference test=FirebaseDatabase.getInstance().getReference();

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
