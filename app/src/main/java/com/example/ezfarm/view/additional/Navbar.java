package com.example.ezfarm.view.additional;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.poe_life.R;
import com.example.poe_life.view.activity.WritePoemFirstStepActivity;
import com.example.poe_life.view.fragment.BookmarkFragment;
import com.example.poe_life.view.fragment.HomeFragment;
import com.example.poe_life.view.fragment.NotificationsFragment;
import com.example.poe_life.view.fragment.UserProfileFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class Navbar extends AppCompatActivity {
    FloatingActionButton fabNN;
    private MeowBottomNavigation meowBottomNavigation;
    private HomeFragment homeFragment = new HomeFragment();
    private NotificationsFragment notificationsFragment = new NotificationsFragment();
    private WritePoemFirstStepActivity newPostFragment = new WritePoemFirstStepActivity();
    private BookmarkFragment bookmarkFragment = new BookmarkFragment();
    private UserProfileFragment userprofileFragment = new UserProfileFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navbar);


        meowBottomNavigation = findViewById(R.id.bottomView);
        MeowBottomNavigation bottomNavigation = findViewById(R.id.bottomView);
        bottomNavigation.setBackgroundColor(Color.parseColor("#00000000"));
        meowBottomNavigation.show(1,true);
        fabNN = findViewById(R.id.fab);


        meowBottomNavigation.add(new MeowBottomNavigation.Model(1,R.drawable.home));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2,R.drawable.notifications));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3,'0'));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(4,R.drawable.bookmark_filled_ico));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(5,R.drawable.user));

        meowBottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                Fragment fragment =null;

                switch (model.getId()){
                    case 1:
                        fragment = new HomeFragment();
                        break;
                    case 2:
                        fragment = new NotificationsFragment();
                        break;
                    case 3:
                        fragment = null;
                        break;
                    case 4:
                        fragment = new BookmarkFragment();
                        break;
                    case 5:
                        fragment = new UserProfileFragment();
                        break;
                }
                loadFragment(fragment);
                return null;
            }
        });
        fabNN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Navbar.this, WritePoemFirstStepActivity.class);
                startActivityForResult(intent, 123);
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment, fragment).commit();
    }
}