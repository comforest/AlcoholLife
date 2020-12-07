package com.software.engineering.alcohollife.ui.review;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.software.engineering.alcohollife.R;

import org.w3c.dom.Text;

public class WriteReview extends AppCompatActivity {
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_review);


        final EditText editText = findViewById(R.id.editTextTextPersonName);
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s = editText.getText().toString();
                review_submit(s);

            }
        });

    }

    public void review_submit(String s){
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();

    }
}