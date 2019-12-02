package com.example.intern_food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText Email, Password;
    String email, password;
    private FirebaseAuth mAuth;


    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signIn= findViewById(R.id.btn_sign_in);
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
