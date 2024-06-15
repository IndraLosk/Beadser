package com.example.beadser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Chamomile extends AppCompatActivity {

    TextView riv7;
    TextView label;
    ImageView img;
    ImageView toLeft;
    ImageView toRight;

    int countImg = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chamomile);

        riv7 = findViewById(R.id.back);
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
            label.setText("\t\t\t1 из 6");
            img.setImageResource(R.drawable.chamomile02);
            toLeft.setImageResource(R.drawable.toleftpassiv);
        }
        else if (countImg == 3)
        {
            label.setText("\t\t\t2 из 6");
            img.setImageResource(R.drawable.chamomile03);
            toLeft.setImageResource(R.drawable.toleftactive);
        }
        else if (countImg == 4) {
            label.setText("\t\t\t3 из 6");
            img.setImageResource(R.drawable.chamomile04);
        }
        else if (countImg == 5) {
            label.setText("\t\t\t4 из 6");
            img.setImageResource(R.drawable.chamomile05);
        }
        else if (countImg == 6) {
            label.setText("\t\t\t5 из 6");
            img.setImageResource(R.drawable.chamomile06);
            toRight.setImageResource(R.drawable.torightactive);
        }
        else if (countImg == 7) {
            label.setText("\t\t\t6 из 6");
            img.setImageResource(R.drawable.chamomile07);
            toRight.setImageResource(R.drawable.torightpassiv);
        }
        else if (countImg == 1)
            countImg = 2;
        else if (countImg == 8)
            countImg = 7;

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