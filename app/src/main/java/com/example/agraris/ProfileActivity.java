package com.example.agraris;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class ProfileActivity extends AppCompatActivity {

    Button btnLogout;
    FirebaseAuth mFirebaseAuth;
    private  FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem nmenuitem) {
                switch (nmenuitem.getItemId()){
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),
                                HomeActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.sell:
                        startActivity(new Intent(getApplicationContext(),
                                SellActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(),
                                CartActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profile:
                        return true;
                }
                return false;
            }
        });

        btnLogout = findViewById(R.id.logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intoMain = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intoMain);
            }
        });
    }
}
