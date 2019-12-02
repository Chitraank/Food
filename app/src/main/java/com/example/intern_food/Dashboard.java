package com.example.intern_food;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.intern_food.Model.UserClass;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private TextView textView,Roll,Branch,Hostel,Name,BranchM;
    DatabaseReference userref= FirebaseDatabase.getInstance().getReference("User");
    String username,rollno,branch,currentUserID;
    private FirebaseAuth mAuth;
    UserClass userClass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Hostel=findViewById(R.id.hostel_name);
        Name=findViewById(R.id.name);
        BranchM=findViewById(R.id.branch);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_dashboard);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(this);
        getIntentValue();
        fetchDataForHomePage();


    }

    private void fetchDataForHomePage() {
        userref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                    userClass=ds.getValue(UserClass.class);
                }
//                username=dataSnapshot.child(id).child("name").getValue().toString();
                Name.setText(userClass.getName());
                Hostel.setText(userClass.getHostel());
                BranchM.setText(userClass.getBranch());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getIntentValue() {
        if(getIntent().hasExtra("UserId"))
        {
            currentUserID=getIntent().getStringExtra("UserId");
        }
    }

    public void fetchUserDetails() {
        userref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren())
                {
                     userClass=ds.getValue(UserClass.class);
                }
                username=userClass.getName();
//                username=dataSnapshot.child(id).child("name").getValue().toString();
                textView.setText(username);
                Roll.setText(userClass.getRollNo());
                Branch.setText(userClass.getBranch());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void signOut() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(Dashboard.this,Sign_in_up.class));
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        textView=findViewById(R.id.user_name);
        Roll=findViewById(R.id.user_rno);
        Branch=findViewById(R.id.user_branch);
        switch (item.getItemId()){

            case R.id.nav_dashboard:
                fetchUserDetails();
                break;
            case R.id.nav_logout:
                signOut();
                break;

            case R.id.nav_meals:   startActivity(new Intent(Dashboard.this, Meals.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;

            case R.id.nav_menu:    startActivity(new Intent(Dashboard.this, My_test.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;

            case R.id.nav_feedback:      startActivity(new Intent(Dashboard.this, Feedback.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;

            case R.id.nav_suggestions:      startActivity(new Intent(Dashboard.this, Suggestions.class));
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
