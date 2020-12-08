package com.software.engineering.alcohollife.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.software.engineering.alcohollife.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final EditText textViewID = findViewById(R.id.editTextTextPersonName2);
        final EditText textViewEmail = findViewById(R.id.editTextTextPersonName5);
        final EditText textViewPassword = findViewById(R.id.editTextTextPersonName6);
        final EditText textViewPassword2 = findViewById(R.id.editTextTextPersonName7);
        Button button_signup = findViewById(R.id.button4);


        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup_clicked(textViewID.getText().toString(), textViewEmail.getText().toString(),
                        textViewPassword.getText().toString(), textViewPassword2.getText().toString());
            }
        });



    }

    void signup_clicked(String id, String email, String pwd1, String pwd2){
        if (!pwd1.equals(pwd2)){
            Toast.makeText(getApplicationContext(), "비밀번호와 비밀번호확인이 같아야합니다.", Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), pwd1+pwd2, Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(getApplicationContext(), id+email+pwd1, Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}