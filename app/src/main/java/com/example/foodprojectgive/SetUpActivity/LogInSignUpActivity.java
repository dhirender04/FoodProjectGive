package com.example.foodprojectgive.SetUpActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.foodprojectgive.R;

public class LogInSignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //getSupportActionBar().hide();
        setContentView(R.layout.activity_log_in_sign_up);


    }

    public void btnLogin(View view){
        Intent intent = new Intent(LogInSignUpActivity.this,LogInActivity.class);
        startActivity(intent);
    }
    public void btn_signup(View view){
        Intent intent = new Intent(LogInSignUpActivity.this,SignUpActivity.class);
        startActivity(intent);
    }
}