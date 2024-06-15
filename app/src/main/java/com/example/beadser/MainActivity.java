package com.example.beadser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.time.LocalTime;

public class MainActivity extends AppCompatActivity {
    TextView tvTime;

    private static final int SPLASH_SCREEN_TIMEOUT = 1500; // задержка в 1,5 секунды

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTime = findViewById(R.id.textViewTime); //поле текста
        LocalTime currentTime = LocalTime.now(); //определение текущего времени
        currentTime.getHour();
        currentTime.getMinute();
        String time = "С возвращением!";
        int hour = currentTime.getHour() + 3;
        if (((hour >= 4 && currentTime.getMinute() >= 0) && (hour <= 10 && currentTime.getMinute() < 60)) || (hour == 11 && currentTime.getMinute() == 0))
            time = "Доброе утро!\n";
        else if (((hour >= 11 && currentTime.getMinute() >= 0) && (hour <= 17 && currentTime.getMinute() < 60)) || (hour == 18 && currentTime.getMinute() == 0))
            time = "Добрый день!\n";
        else if (((hour >= 18 && currentTime.getMinute() >= 0) && (hour <= 23 && currentTime.getMinute() < 60)) || (hour == 24 && currentTime.getMinute() == 0))
            time = "Добрый вечер!\n";
        else
            time = "Доброй ночи!\n";
        tvTime.setText(time);

        new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(MainActivity.this, MainMenu.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out); //настройки анимации перехода между двумя активностями
                            finish();
                        }
                    }, SPLASH_SCREEN_TIMEOUT);
    }

}