package com.example.intern_food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Login extends AppCompatActivity {
    EditText Email, Password;
    String email, password;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
        }
    }
    public void signIn(View view)
    {
        email=Email.getText().toString();
        password=Password.getText().toString();

        if(!(email.isEmpty()||password.isEmpty()))
        {
            mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful())
                            {
                                Toast.makeText(Login.this, "SignedIn", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Login.this,Dashboard.class));

                            }
                            else
                                Toast.makeText(Login.this, "Error:"+task.getException(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
        else
        {
            Toast.makeText(this, "Invalid Fields", Toast.LENGTH_SHORT).show();
        }
    }
}
