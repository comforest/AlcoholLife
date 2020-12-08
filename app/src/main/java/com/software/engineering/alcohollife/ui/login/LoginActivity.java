package com.software.engineering.alcohollife.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.software.engineering.alcohollife.R;
import com.software.engineering.alcohollife.ui.main.MainActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

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

    public void login_clicked(String username, String password){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void signup_clicked(){
        Intent intent2 = new Intent(getApplicationContext(), SignUpActivity.class);
        startActivity(intent2);
    }




}