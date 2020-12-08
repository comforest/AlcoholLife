package com.software.engineering.alcohollife.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.software.engineering.alcohollife.App;
import com.software.engineering.alcohollife.R;
import com.software.engineering.alcohollife.model.data.LoginData;
import com.software.engineering.alcohollife.model.data.SignUpData;
import com.software.engineering.alcohollife.model.data.TokenData;
import com.software.engineering.alcohollife.model.network.DrinkRetrofit;
import com.software.engineering.alcohollife.model.network.base.ApiStatus;
import com.software.engineering.alcohollife.model.network.base.RestClient;
import com.software.engineering.alcohollife.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity {
    private DrinkRetrofit model = RestClient.INSTANCE.getDrinkService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(!App.Companion.getPrefs().getIdToken().isEmpty()){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }

        final EditText usernameEditText = findViewById(R.id.username);
        final EditText passwordEditText = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login);
        TextView textview = findViewById(R.id.textView9);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login_clicked(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        });

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup_clicked();
            }
        });
    }

    public void login_clicked(final String username, String password){
        model.login(new LoginData(username, password)).observe(this, new Observer<ApiStatus<TokenData>>() {
            @Override
            public void onChanged(ApiStatus<TokenData> objectApiStatus) {
                if (objectApiStatus instanceof ApiStatus.Success){
                    Toast.makeText(getApplicationContext(), "로그인에 성공했습니다.", Toast.LENGTH_SHORT).show();
                    TokenData token = ((ApiStatus.Success<TokenData>) objectApiStatus).getData();
                    App.Companion.getPrefs().setIdToken(token.getToken());
                    App.Companion.getPrefs().setUserName(username);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else if (objectApiStatus instanceof ApiStatus.Error){
                    Toast.makeText(getApplicationContext(), "아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void signup_clicked(){
        Intent intent2 = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(intent2);
    }




}