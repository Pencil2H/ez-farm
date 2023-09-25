package com.example.ezfarm.view.activity;

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

import com.example.poe_life.R;
import com.example.poe_life.data.api.ApiClient;
import com.example.poe_life.data.interfaces.AuthInterface;
import com.example.poe_life.data.model.RegisterData;
import com.example.poe_life.view.additional.Navbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText RegisterETusername,RegisterETNIM,RegisterETEmail,RegisterETPassword;
    Button Registerbtnlogin;
    String usernameRegister,passwordRegister,NimRegister;
    RegisterData registerData;
    AuthInterface apiClient;
    AlertDialog.Builder builder;

    TextView RegisterTVlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        apiClient = ApiClient.getRetrofitInstance().create(AuthInterface.class);
        builder = new AlertDialog.Builder(this);

        RegisterETusername = findViewById(R.id.RegisterETUsername);
        RegisterETNIM = findViewById(R.id.RegisterETNIM);
        RegisterETEmail = findViewById(R.id.RegisterETEmail);
        RegisterETPassword = findViewById(R.id.RegisterETPassword);
        Registerbtnlogin = findViewById(R.id.Registerbtnlogin);

        RegisterETPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;

                if (event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX() >= (RegisterETPassword.getRight() - RegisterETPassword.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        if (RegisterETPassword.getTransformationMethod() instanceof PasswordTransformationMethod) {
                            RegisterETPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            RegisterETPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_hidepass, 0);  // show striked eye
                        } else {
                            RegisterETPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            RegisterETPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_seepassword, 0);  // show eye
                        }
                        return true;
                    }
                }
                return false;
            }
        });

        usernameRegister = RegisterETusername.getText().toString();
        passwordRegister = RegisterETPassword.getText().toString();
        NimRegister = RegisterETNIM.getText().toString();

        RegisterETusername.addTextChangedListener(new TextWatcher() {
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
                    RegisterETusername.setError("No special characters or space allowed");
                }else {
                    RegisterETusername.setError(null);
                }
            }
        });

        Registerbtnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               doregister();
            }
        });

        RegisterTVlogin = findViewById(R.id.registerTVlogin);

        RegisterTVlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

   public void doregister(){
        String usernameReg = RegisterETusername.getText().toString();
        String nim = RegisterETNIM.getText().toString();
        String Email=RegisterETEmail.getText().toString();
        String PasswordReg =RegisterETPassword.getText().toString();

       Call<RegisterData> call = apiClient.Register(usernameReg,nim,Email,PasswordReg);
       call.enqueue(new Callback<RegisterData>() {
           @Override
           public void onResponse(Call<RegisterData> call, Response<RegisterData> response) {
               Log.d("Tag",response.code()+"");
               registerData = response.body();
               int rescode = registerData.getCode();
               if(rescode == 0){
                   String userId = registerData.getData().getUserId();
                   String userName = registerData.getData().getUserName();
                   String userEmail = registerData.getData().getUserEmail();
                   String userImage = registerData.getData().getUserImage();
                   String loginToken = registerData.getData().getLoginToken();

                   SharedPreferences sharedPreferences = getSharedPreferences("MyUserData",MODE_PRIVATE);
                   SharedPreferences.Editor myEditor = sharedPreferences.edit();
                   myEditor.putString("userId",userId);
                   myEditor.putString("userName",userName);
                   myEditor.putString("userEmail",userEmail);
                   myEditor.putString("userImage",userImage);
                   myEditor.putString("loginToken",loginToken);
                   myEditor.commit();
                   Intent intent = new Intent(RegisterActivity.this, Navbar.class);
                   Toast.makeText(RegisterActivity.this,"Welcome "+userName,Toast.LENGTH_SHORT).show();
                   finishAffinity();
                   startActivity(intent);
               }
           }

           @Override
           public void onFailure(Call<RegisterData> call, Throwable t) {
               Toast.makeText(RegisterActivity.this, "Failed to Register", Toast.LENGTH_SHORT).show();
               Log.e("error Api","failed to login");
           }
       });
   }
}

