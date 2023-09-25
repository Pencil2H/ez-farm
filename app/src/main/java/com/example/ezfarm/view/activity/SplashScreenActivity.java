package com.example.ezfarm.view.activity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ezfarm.R;
import com.example.poe_life.view.additional.Navbar;

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("MyUserData", Context.MODE_PRIVATE);
                String loginToken = sharedPreferences.getString("loginToken",null);
                if (loginToken == null){
                    startActivity(new Intent(getApplicationContext(), LandingPageActivity.class));
                }else {
                    startActivity(new Intent(SplashScreenActivity.this, Navbar.class));
                }
                finish();
            }
        },2000L);
    }
}