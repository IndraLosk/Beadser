package com.example.beadser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Fox extends AppCompatActivity {

    TextView label;
    ImageView img;
    ImageView toLeft;
    ImageView toRight;

    int countImg = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fox);
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
            label.setText("\t\t\t1 из 14. Голова сзади");
            img.setImageResource(R.drawable.fox02);
            toLeft.setImageResource(R.drawable.toleftpassiv);
        } else if (countImg == 3) {
            label.setText("\t\t\t2 из 14. Макушка");
            img.setImageResource(R.drawable.fox03);
            toLeft.setImageResource(R.drawable.toleftactive);
        } else if (countImg == 4) {
            label.setText("\t\t\t3 из 14. Бок");
            img.setImageResource(R.drawable.fox04);
        } else if (countImg == 5) {
            label.setText("\t\t\t4 из 14. Голова спереди");
            img.setImageResource(R.drawable.fox05);
        } else if (countImg == 6) {
            label.setText("\t\t\t5 из 14. Бок");
            img.setImageResource(R.drawable.fox06);
        } else if (countImg == 7) {
            label.setText("\t\t\t6 из 14. Голова снизу");
            img.setImageResource(R.drawable.fox07);
        } else if (countImg == 8) {
            label.setText("\t\t\t7 из 14. Мордочка");
            img.setImageResource(R.drawable.fox08);
        } else if (countImg == 9) {
            label.setText("\t\t\t8 из 14. Ухо (второе зеркально)");
            img.setImageResource(R.drawable.fox09);
        } else if (countImg == 10) {
            label.setText("\t\t\t9 из 14. Левый бок животика (второе зеркально)");
            img.setImageResource(R.drawable.fox10);
        } else if (countImg == 11) {
            label.setText("\t\t\t10 из 14. Животик");
            img.setImageResource(R.drawable.fox11);
        } else if (countImg == 12) {
            label.setText("\t\t\t11 из 14. Животик сзади");
            img.setImageResource(R.drawable.fox12);
        } else if (countImg == 13) {
            label.setText("\t\t\t12 из 14. Животик снизу");
            img.setImageResource(R.drawable.fox13);
        } else if (countImg == 14) {
            label.setText("\t\t\t13 из 14. Лапы (сплести 4)");
            toRight.setImageResource(R.drawable.torightactive);
            img.setImageResource(R.drawable.fox14);
        } else if (countImg == 15) {
            label.setText("\t\t\t14 из 14. Хвост");
            img.setImageResource(R.drawable.fox15);
            toRight.setImageResource(R.drawable.torightpassiv);
        }

        else if (countImg == 16)
            countImg = 15;
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