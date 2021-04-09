package com.example.foodprojectgive.SetUpActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.foodprojectgive.R;

public class ResetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
    }
    public void reset_click(View view){
    AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
    awesomeValidation.addValidation(this,R.id.email_reset,"\\w+@\\w+.\\w+",R.string.address_error);

       if(awesomeValidation.validate() ){
           Intent intent = new Intent(ResetActivity.this,FinalStepUpActivity.class);
           startActivity(intent);
       }

    }
}