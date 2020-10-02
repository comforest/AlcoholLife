package com.software.engineering.alcohollife.ui.main;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.software.engineering.alcohollife.R;
import com.software.engineering.alcohollife.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
