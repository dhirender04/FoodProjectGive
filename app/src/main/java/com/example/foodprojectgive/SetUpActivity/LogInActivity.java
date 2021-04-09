package com.example.foodprojectgive.SetUpActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.foodprojectgive.Interface.HttpsInterface;
import com.example.foodprojectgive.Models.LogInModel;
import com.example.foodprojectgive.R;
import com.example.foodprojectgive.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LogInActivity extends AppCompatActivity {
    TextView  forget_password;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText login_mail,password_login;
    final String ERROR_RETROFIT = "Error occur in Retrofit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
      //  getSupportActionBar().hide();
        setContentView(R.layout.activity_log_in);

        login_mail = findViewById(R.id.login_mail);
        password_login = findViewById(R.id.password_login);

        sharedPreferences = getSharedPreferences("auth_table",MODE_PRIVATE);
        editor = sharedPreferences.edit();

        forget_password = findViewById(R.id.forget_password);
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, ResetActivity.class);
                startActivity(intent);
            }
        });
    }

    public void login_single(View view){
        AwesomeValidation awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(LogInActivity.this,R.id.login_mail,"\\w+@\\w+.\\w+",R.string.email_error);
        awesomeValidation.addValidation(LogInActivity.this,R.id.password_login,"[a-zA-Z\\s]+",R.string.password_error);


        String _login_mail = login_mail.getText().toString();
        String _password_login = password_login.getText().toString();
        Retrofit retrofit = RetrofitInstance.get();
        HttpsInterface httpsInterface = retrofit.create(HttpsInterface.class);
        Call<LogInModel> call = httpsInterface.logInUser(_login_mail,_password_login);
        call.enqueue(new Callback<LogInModel>() {
            @Override
            public void onResponse(Call<LogInModel> call, Response<LogInModel> response) {
                LogInModel logInModel = response.body();

                    if (response.isSuccessful()==false){
                        Log.v(ERROR_RETROFIT,"Response Error when fetching data from server");
                        Toast.makeText(LogInActivity.this, "pooooos", Toast.LENGTH_SHORT).show();
                    }
                    if (logInModel.getStatus()==false){
                        Log.v(ERROR_RETROFIT,"LogIn Model Error when fetching data from server");
                        Toast.makeText(LogInActivity.this, "pooooos", Toast.LENGTH_SHORT).show();
                    }

                if (awesomeValidation.validate()){
                    String token = logInModel.getUserModel().getToken();
                    editor.putString("token", token);
                    int id = logInModel.getUserModel().getId();
                    editor.putInt("id", id);
                    editor.apply();
                    movieLogInActivityToOtpActivity();
                }else{
                    Toast.makeText(LogInActivity.this, "pooooos", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LogInModel> call, Throwable t) {
                Log.v(ERROR_RETROFIT,"failure on Login ");
            }
        });


    }

    public void signup_inLogin(View view){
        Intent intent = new Intent(LogInActivity.this,SignUpActivity.class);
        startActivity(intent);
    }

    public void movieLogInActivityToOtpActivity(){ // it is a right place to fill awswomevalidation schema//

            Intent intent = new Intent(LogInActivity.this,OtpActivity.class);
            startActivity(intent);
    }
}