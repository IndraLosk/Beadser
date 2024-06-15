package com.example.beadser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Umyum extends AppCompatActivity {
    TextView label;
    ImageView img;
    ImageView toLeft;
    ImageView toRight;

    int countImg = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_umyum);
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
            label.setText("\t\t\t1 из 11. Голова ч.1");
            img.setImageResource(R.drawable.umyum02);
            toLeft.setImageResource(R.drawable.toleftpassiv);
        } else if (countImg == 3) {
            label.setText("\t\t\t2 из 11. Голова ч.2");
            img.setImageResource(R.drawable.umyum03);
            toLeft.setImageResource(R.drawable.toleftactive);
        } else if (countImg == 4) {
            label.setText("\t\t\t3 из 11. Левый глаз");
            img.setImageResource(R.drawable.umyum04);
        } else if (countImg == 5) {
            label.setText("\t\t\t4 из 11. Правый глаз");
            img.setImageResource(R.drawable.umyum05);
        } else if (countImg == 6) {
            label.setText("\t\t\t5 из 11. Зрачок");
            img.setImageResource(R.drawable.umyum06);
        } else if (countImg == 7) {
            label.setText("\t\t\t6 из 11. Зубы (4шт)");
            img.setImageResource(R.drawable.umyum07);
        } else if (countImg == 8) {
            label.setText("\t\t\t7 из 11. Рот");
            img.setImageResource(R.drawable.umyum08);
        } else if (countImg == 9) {
            label.setText("\t\t\t8 из 11. Рог на голове");
            img.setImageResource(R.drawable.umyum09);
        } else if (countImg == 10) {
            label.setText("\t\t\t9 из 11. Передние лапки");
            img.setImageResource(R.drawable.umyum10);
        } else if (countImg == 11) {
            label.setText("\t\t\t10 из 11. Задние лапки ч.1");
            img.setImageResource(R.drawable.umyum11);
            toRight.setImageResource(R.drawable.torightactive);
        } else if (countImg == 12) {
            label.setText("\t\t\t11 из 11. Задние лапки ч.2");
            img.setImageResource(R.drawable.umyum12);
            toRight.setImageResource(R.drawable.torightpassiv);
        }
        else if (countImg == 13)
            countImg = 12;
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