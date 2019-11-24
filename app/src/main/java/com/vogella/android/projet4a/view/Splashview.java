package com.vogella.android.projet4a.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.vogella.android.projet4a.R;

public class Splashview extends AppCompatActivity {

    private static int TIME = 2000;

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splashview.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },TIME);
    }
}
