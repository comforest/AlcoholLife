package com.software.engineering.alcohollife.ui.review;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Notification;
import android.os.Bundle;
import android.view.MenuItem;
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

        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowTitleEnabled(false);
        ab.setDisplayHomeAsUpEnabled(true);

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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }
}