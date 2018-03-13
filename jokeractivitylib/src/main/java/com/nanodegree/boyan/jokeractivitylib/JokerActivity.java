package com.nanodegree.boyan.jokeractivitylib;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class JokerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker);
        TextView jokeTv = findViewById(R.id.joke_tv);

        if (getIntent().getExtras() != null) {
            String joke = getIntent().getStringExtra("joke");
            jokeTv.setText(joke);
        }
    }
}
