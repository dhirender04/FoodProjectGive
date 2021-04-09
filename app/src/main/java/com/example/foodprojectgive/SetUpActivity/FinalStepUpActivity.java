package com.example.foodprojectgive.SetUpActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodprojectgive.R;

public class FinalStepUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_step_up);
    }
    public void finalstep(View view){
        Toast.makeText(this, "Step is completed !!!!", Toast.LENGTH_SHORT).show();
    }
}