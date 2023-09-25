package com.example.ezfarm.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezfarm.R;

public class LandingPageActivity extends AppCompatActivity {

    Button WPbtnReg,WPbtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        WPbtnReg = findViewById(R.id.WPbtnReg);
        WPbtnLogin = findViewById(R.id.WPbtnLogin);

        WPbtnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingPageActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        WPbtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LandingPageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}