package com.example.beadser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Intertwined extends AppCompatActivity {

    TextView label;
    ImageView img;
    ImageView toLeft;
    ImageView toRight;

    int countImg = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intertwined);
        label = findViewById(R.id.label);
        img = findViewById(R.id.imageView);
        toLeft = findViewById(R.id.toleftButt);
        toRight = findViewById(R.id.torightButt);
    }

    public void Back(View view) {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void check(){ //проверка на количество изображений
        if (countImg == 2) {
            label.setText("\t\t\t1 из 4");
            img.setImageResource(R.drawable.intertwined02);
            //если изображение первое, левая стрелочка не доступна
            toLeft.setImageResource(R.drawable.toleftpassiv);
        }
        else if (countImg == 3)
        {
            label.setText("\t\t\t2 из 4");
            img.setImageResource(R.drawable.intertwined03);
            toLeft.setImageResource(R.drawable.toleftactive);
        }
        else if (countImg == 4) {
            label.setText("\t\t\t3 из 4");
            img.setImageResource(R.drawable.intertwined04);
            toRight.setImageResource(R.drawable.torightactive);
        }
        else if (countImg == 5) {
            label.setText("\t\t\t4 из 4");
            img.setImageResource(R.drawable.intertwined01);
            //если изображение последнее, правая стрелочка не доступна
            toRight.setImageResource(R.drawable.torightpassiv);
        }

        else if (countImg == 1)
            countImg = 2;
        else if (countImg == 6)
            countImg = 5;

    }
    //нажатие на правую стрелочку
    public void clickToRight(View view) {
        countImg += 1;
        check();
    }
    //нажатие на левую стрелочку
    public void clickToLeft(View view) {
        countImg -= 1;
        check();
    }
}