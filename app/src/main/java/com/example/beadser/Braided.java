package com.example.beadser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Braided extends AppCompatActivity {
    TextView label;
    ImageView img, toLeft, toRight;
    int countImg = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braided);
        label = findViewById(R.id.label);
        img = findViewById(R.id.imageView);
        toLeft = findViewById(R.id.toleftButt);
        toRight = findViewById(R.id.torightButt);
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

    public void Back(View view) {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }


    public void check() {
        if (countImg == 2) {
            label.setText("\t\t\t1 из 17");
            img.setImageResource(R.drawable.braided02);
            toLeft.setImageResource(R.drawable.toleftpassiv);
        } else if (countImg == 3) {
            label.setText("\t\t\t2 из 17");
            img.setImageResource(R.drawable.braided03);
            toLeft.setImageResource(R.drawable.toleftactive);
        } else if (countImg == 4) {
            label.setText("\t\t\t3 из 17");
            img.setImageResource(R.drawable.braided04);
        } else if (countImg == 5) {
            label.setText("\t\t\t4 из 17");
            img.setImageResource(R.drawable.braided05);
        } else if (countImg == 6) {
            label.setText("\t\t\t5 из 17");
            img.setImageResource(R.drawable.braided06);
        } else if (countImg == 7) {
            label.setText("\t\t\t6 из 17");
            img.setImageResource(R.drawable.braided07);
        } else if (countImg == 8) {
            label.setText("\t\t\t7 из 17");
            img.setImageResource(R.drawable.braided08);
        } else if (countImg == 9) {
            label.setText("\t\t\t8 из 17");
            img.setImageResource(R.drawable.braided09);
        } else if (countImg == 10) {
            label.setText("\t\t\t9 из 17");
            img.setImageResource(R.drawable.braided10);
        } else if (countImg == 11) {
            label.setText("\t\t\t10 из 17");
            img.setImageResource(R.drawable.braided11);
        } else if (countImg == 12) {
            label.setText("\t\t\t11 из 17");
            img.setImageResource(R.drawable.braided12);
        } else if (countImg == 13) {
            label.setText("\t\t\t12 из 17");
            img.setImageResource(R.drawable.braided13);
        } else if (countImg == 14) {
            label.setText("\t\t\t13 из 17");
            img.setImageResource(R.drawable.braided14);
        } else if (countImg == 15) {
            label.setText("\t\t\t14 из 17");
            img.setImageResource(R.drawable.braided15);
        } else if (countImg == 16) {
            label.setText("\t\t\t15 из 17");
            img.setImageResource(R.drawable.braided16);
        } else if (countImg == 17) {
            label.setText("\t\t\t16 из 17");
            img.setImageResource(R.drawable.braided17);
            toRight.setImageResource(R.drawable.torightactive);
        } else if (countImg == 18) {
            label.setText("\t\t\t17 из 17");
            img.setImageResource(R.drawable.braided18);
            toRight.setImageResource(R.drawable.torightpassiv);
        }
        else if (countImg == 18)
            countImg = 17;
        else if (countImg == 1)
            countImg = 2;
    }

    public void clickToRight(View view) {
        countImg += 1;
        check();

    }

    public void clickToLeft(View view) {
        countImg -= 1;
        check();

    }
}