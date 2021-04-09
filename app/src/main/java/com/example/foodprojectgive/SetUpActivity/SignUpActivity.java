package com.example.foodprojectgive.SetUpActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.custom.SimpleCustomValidation;
import com.example.foodprojectgive.R;

public class SignUpActivity extends AppCompatActivity {

    EditText password_signup,comfirm_password_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_up);
        password_signup = findViewById(R.id.password_signup);
        comfirm_password_signup = findViewById(R.id.comfirm_password_signup);

    }
    public void signup_main(View view){
        AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.name_signu,"\\w+",R.string.name_error);
        awesomeValidation.addValidation(this,R.id.email_signup,"\\w+@\\w+.\\w+",R.string.email_error);
        awesomeValidation.addValidation(this,R.id.mobile_error,"\\w[0-9]+",R.string.mobile_error);
        awesomeValidation.addValidation(this,R.id.address_error,"\\w+",R.string.address_error);
        awesomeValidation.addValidation(this,R.id.password_signup,"\\w+",R.string.password_error);
        awesomeValidation.addValidation(this,R.id.comfirm_password_signup,"\\w+",R.string.password_error);
        String password = password_signup.getText().toString();
        String com_password = comfirm_password_signup.getText().toString();


            if (awesomeValidation.validate() && password.equals(com_password)){
                Intent intent = new Intent(SignUpActivity.this , OtpActivity.class);
                startActivity(intent);
            } else{
            awesomeValidation.addValidation(SignUpActivity.this, R.id.password_signup, new SimpleCustomValidation() {
                @Override
                public boolean compare(String s) {
                    try {
                        if (password.equals(com_password)){
                            return true;
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    return false;
                }
            },R.string.com_error);

        }


    }
    public void login_signup(View view){
        Intent intent = new Intent(SignUpActivity.this,LogInActivity.class);
        startActivity(intent);
    }
}