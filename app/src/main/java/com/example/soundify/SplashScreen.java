package com.example.soundify;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_landingscreen);


        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();

        //if user is already logged in and haven't logged out auto login



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
              if (mUser!=null)
              {
                  Intent landingIntent = new Intent(SplashScreen.this, MainActivity.class);
                  startActivity(landingIntent);
                  finish();
              }else
              {
                  Intent landingIntent = new Intent(SplashScreen.this, LoginActivity.class);
                  startActivity(landingIntent);
                  finish();
              }
            }
        },SPLASH_TIME_OUT);
    }
}