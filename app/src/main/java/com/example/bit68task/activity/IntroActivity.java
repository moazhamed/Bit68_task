package com.example.bit68task.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.bit68task.fragment.FirstSlide;
import com.example.bit68task.fragment.SecondSlide;
import com.example.bit68task.fragment.ThirdSlide;
import com.github.paolorotolo.appintro.AppIntro;

public class IntroActivity extends AppIntro {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addSlide(new FirstSlide());
        addSlide(new SecondSlide());
        addSlide(new ThirdSlide());
        showSkipButton(false);
        showSeparator(false);
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        startActivity(new Intent(IntroActivity.this, HomeActivity.class));
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        startActivity(new Intent(IntroActivity.this, HomeActivity.class));
        finish();
    }
}