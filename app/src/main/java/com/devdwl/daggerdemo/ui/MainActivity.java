package com.devdwl.daggerdemo.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.devdwl.daggerdemo.R;
import com.devdwl.daggerdemo.utills.Prefs;

import javax.inject.Inject;

public class MainActivity extends BaseActivity {

    @Inject
    Prefs prefs;

    @Inject
    RequestManager glideRequestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ivDagger = findViewById(R.id.ivDagger);

        String url = "https://i2.wp.com/codingsonata.com/wp-content/uploads/2017/12/Android-dagger-2.png?resize=300%2C208";

        if (isInternetAvailable())
            glideRequestManager.load(url).into(ivDagger);
        else
            Toast.makeText(this, "Please check your internet connection!", Toast.LENGTH_SHORT).show();

    }
}
