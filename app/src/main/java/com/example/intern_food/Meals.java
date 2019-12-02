package com.example.intern_food;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Meals extends AppCompatActivity {
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        submit= findViewById(R.id.submit_meals);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OnSubmit();
            }
        });
    }

    public void OnSubmit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Meals.this);
        builder.setMessage("Are you sure ?");
        builder.setTitle("Alert");
        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                             @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {
                                Intent i = new Intent(Meals.this, Load.class);
                                startActivity(i);
                            }
                        });


        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // If user click no
                                // then dialog box is canceled.
                                dialog.cancel();
                            }
                        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
