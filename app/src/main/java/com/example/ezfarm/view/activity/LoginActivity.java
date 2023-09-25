package com.example.ezfarm.view.activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ezfarm.R;
import com.example.poe_life.data.api.ApiClient;
import com.example.poe_life.data.interfaces.AuthInterface;
import com.example.poe_life.data.model.LoginData;
import com.example.poe_life.view.additional.Navbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    EditText LoginETusername,LoginETpassword;
    Button loginBtnLogin;
    AuthInterface apiClient;
    LoginData loginData;
    AlertDialog.Builder builder;
    TextView LoginTVregister;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        apiClient = ApiClient.getRetrofitInstance().create(AuthInterface.class);
        builder = new AlertDialog.Builder(this);

        LoginETusername = findViewById(R.id.LoginETusername);
        LoginETpassword = findViewById(R.id.LoginETpassword);
        loginBtnLogin = findViewById(R.id.loginBtnLogin);

        LoginETusername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString();
                if (!input.matches("[a-zA-Z0-9]*")){
                    LoginETusername.setError("No special characters or space allowed");
                }else {
                    LoginETusername.setError(null);
                }
            }
        });

        LoginETpassword.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;

                if (event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX() >= (LoginETpassword.getRight() - LoginETpassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        if (LoginETpassword.getTransformationMethod() instanceof PasswordTransformationMethod) {
                            LoginETpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            LoginETpassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_hidepass, 0);  // show striked eye
                        } else {
                            LoginETpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            LoginETpassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_seepassword, 0);  // show eye
                        }
                        return true;
                    }
                }
                return false;
            }
        });
        loginBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();

            }
        });

        LoginTVregister = findViewById(R.id.loginTVregister);

        LoginTVregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void doLogin(){
        String username = LoginETusername.getText().toString();
        String password = LoginETpassword.getText().toString();

        Call<LoginData> call = apiClient.login(username,password);
        call.enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {
                Log.d("Tag",response.code()+"");
                loginData = response.body();
                int rescode = loginData.getCode();
                if (rescode == 0){
                    String userId = loginData.getData().getUserId();
                    String userName = loginData.getData().getUserName();
                    String userEmail = loginData.getData().getUserEmail();
                    String userImage = loginData.getData().getUserImage();
                    String loginToken = loginData.getData().getLoginToken();

                    SharedPreferences sharedPreferences = getSharedPreferences("MyUserData",MODE_PRIVATE);
                    SharedPreferences.Editor myEditor = sharedPreferences.edit();
                    myEditor.putString("userId",userId);
                    myEditor.putString("userName",userName);
                    myEditor.putString("userEmail",userEmail);
                    myEditor.putString("userImage",userImage);
                    myEditor.putString("loginToken",loginToken);
                    myEditor.commit();
                    Intent intent = new Intent(LoginActivity.this, Navbar.class);
                    Toast.makeText(LoginActivity.this,"Welcome "+userName,Toast.LENGTH_SHORT).show();
                    finishAffinity();
                    startActivity(intent);
                }else {
                    builder.setMessage(loginData.getMessage())
                            .setTitle("Error").setCancelable(false)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                        AlertDialog alert = builder.create();
                        alert.show();


                }
            }

            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {
            Toast.makeText(LoginActivity.this, "Failed to Login", Toast.LENGTH_SHORT).show();
            Log.e("error Api","failed to login");
            }
        });

    }

}
