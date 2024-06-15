package com.example.beadser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Lizard extends AppCompatActivity {
    TextView label;
    ImageView img;
    ImageView toLeft;
    ImageView toRight;

    int countImg = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lizard);
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

    public void check() {
        if (countImg == 2) {
            label.setText("\t\t\t1 из 18. Перед головы");
            img.setImageResource(R.drawable.lizard02);
            toLeft.setImageResource(R.drawable.toleftpassiv);
        } else if (countImg == 3) {
            label.setText("\t\t\t2 из 18. Левый бок головы");
            img.setImageResource(R.drawable.lizard03);
            toLeft.setImageResource(R.drawable.toleftactive);
        } else if (countImg == 4) {
            label.setText("\t\t\t3 из 18. Правый бок головы");
            img.setImageResource(R.drawable.lizard04);
        } else if (countImg == 5) {
            label.setText("\t\t\t4 из 18. Верх головы");
            img.setImageResource(R.drawable.lizard05);
        } else if (countImg == 6) {
            label.setText("\t\t\t5 из 18. Низ головы");
            img.setImageResource(R.drawable.lizard06);
        } else if (countImg == 7) {
            label.setText("\t\t\t6 из 18. Голова сзади");
            img.setImageResource(R.drawable.lizard07);
        } else if (countImg == 8) {
            label.setText("\t\t\t7 из 18. Шея");
            img.setImageResource(R.drawable.lizard08);
        } else if (countImg == 9) {
            label.setText("\t\t\t8 из 18. Шея 1");
            img.setImageResource(R.drawable.lizard09);
        } else if (countImg == 10) {
            label.setText("\t\t\t9 из 18. Шея 2");
            img.setImageResource(R.drawable.lizard10);
        } else if (countImg == 11) {
            label.setText("\t\t\t10 из 18. Начало тела");
            img.setImageResource(R.drawable.lizard11);
        } else if (countImg == 12) {
            label.setText("\t\t\t11 из 18. Гребень 1");
            img.setImageResource(R.drawable.lizard12);
        } else if (countImg == 13) {
            label.setText("\t\t\t12 из 18. Гребень 1");
            img.setImageResource(R.drawable.lizard13);
        } else if (countImg == 14) {
            label.setText("\t\t\t13 из 18. Хвост");
            img.setImageResource(R.drawable.lizard14);
        } else if (countImg == 15) {
            label.setText("\t\t\t14 из 18. Тело 1");
            img.setImageResource(R.drawable.lizard15);
        } else if (countImg == 16) {
            label.setText("\t\t\t15 из 18. Тело 2");
            img.setImageResource(R.drawable.lizard16);
        } else if (countImg == 17) {
            label.setText("\t\t\t16 из 18. Лапки");
            img.setImageResource(R.drawable.lizard17);
        } else if (countImg == 18) {
            label.setText("\t\t\t17 из 18. Место крепления лапок");
            img.setImageResource(R.drawable.lizard18);
            toRight.setImageResource(R.drawable.torightactive);
        } else if (countImg == 19) {
            label.setText("\t\t\t18 из 18. Результат");
            img.setImageResource(R.drawable.lizard01);
            toRight.setImageResource(R.drawable.torightpassiv);
        }
        else if (countImg == 20)
            countImg = 19;
        else if (countImg == 1)
            countImg = 2;
    }

    public void clickToLeft(View view) {
            countImg -= 1;
            check();
    }

    public void clickToRight(View view) {
            countImg += 1;
            check();
    }
}