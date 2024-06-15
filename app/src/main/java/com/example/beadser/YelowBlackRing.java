package com.example.beadser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class YelowBlackRing extends AppCompatActivity {
    TextView label;
    ImageView img;
    ImageView toLeft;
    ImageView toRight;

    int countImg = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yelow_black_ring);
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

    public void check(){
        if (countImg == 2) {
            label.setText("\t\t\t1 из 8");
            img.setImageResource(R.drawable.yelowblackring02);
            toLeft.setImageResource(R.drawable.toleftpassiv);
        }
        else if (countImg == 3)
        {
            label.setText("\t\t\t2 из 8");
            img.setImageResource(R.drawable.yelowblackring03);
            toLeft.setImageResource(R.drawable.toleftactive);
        }
        else if (countImg == 4) {
            label.setText("\t\t\t3 из 8");
            img.setImageResource(R.drawable.yelowblackring04);
        }
        else if (countImg == 5) {
            label.setText("\t\t\t4 из 8");
            img.setImageResource(R.drawable.yelowblackring05);
        }
        else if (countImg == 6) {
            label.setText("\t\t\t5 из 8");
            img.setImageResource(R.drawable.yelowblackring06);
        }
        else if (countImg == 7) {
            label.setText("\t\t\t6 из 8");
            img.setImageResource(R.drawable.yelowblackring07);
        }
        else if (countImg == 8) {
            label.setText("\t\t\t7 из 8");
            img.setImageResource(R.drawable.yelowblackring08);
            toRight.setImageResource(R.drawable.torightactive);
        }
        else if (countImg == 9) {
            label.setText("\t\t\t8 из 8");
            img.setImageResource(R.drawable.yelowblackring09);
            toRight.setImageResource(R.drawable.torightpassiv);
        }
        else if (countImg == 1)
            countImg = 2;
        else if (countImg == 10)
            countImg = 9;

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