package com.example.demo_splash;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class SplashAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);




        // Created imageview instance by using the findview by id method.
        ImageView imageView = findViewById(R.id.logoSplash);


        // Created animator obj instance
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(
                imageView,
                PropertyValuesHolder.ofFloat("scaleX",1.2f),
                PropertyValuesHolder.ofFloat("scaleY",1.2f)
        );

        objectAnimator.setDuration(500);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.start();



        // this is used to eliminate actionbar;
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }



//        this handler class does the parallel threading work which in bg counts the time given by user and till the time other thread starts
//        with the splash activity. Once splash is done, the bg process that is main activity gets executed.


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent iHome = new Intent(SplashAct.this, MainActivity.class);
                startActivity(iHome);
                finish();

            }
        }, 4000);

    }
}