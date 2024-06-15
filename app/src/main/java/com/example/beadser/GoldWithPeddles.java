package com.example.beadser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GoldWithPeddles extends AppCompatActivity {

    TextView label;
    ImageView img;
    ImageView toLeft;
    ImageView toRight;

    int countImg = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold_with_peddles);
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
            label.setText("\t\t\t1 из 15");
            img.setImageResource(R.drawable.goldwithpebbles02);
            toLeft.setImageResource(R.drawable.toleftpassiv);
        }
        else if (countImg == 3)
        {
            label.setText("\t\t\t2 из 15");
            img.setImageResource(R.drawable.goldwithpebbles03);
            toLeft.setImageResource(R.drawable.toleftactive);
        }
        else if (countImg == 4) {
            label.setText("\t\t\t3 из 15");
            img.setImageResource(R.drawable.goldwithpebbles04);
        }
        else if (countImg == 5) {
            label.setText("\t\t\t4 из 15");
            img.setImageResource(R.drawable.goldwithpebbles05);
        }
        else if (countImg == 6) {
            label.setText("\t\t\t5 из 15");
            img.setImageResource(R.drawable.goldwithpebbles06);
        }
        else if (countImg == 7) {
            label.setText("\t\t\t6 из 15");
            img.setImageResource(R.drawable.goldwithpebbles07);
        }
        else if (countImg == 8) {
            label.setText("\t\t\t7 из 15");
            img.setImageResource(R.drawable.goldwithpebbles08);
        }
        else if (countImg == 9) {
            label.setText("\t\t\t8 из 15");
            img.setImageResource(R.drawable.goldwithpebbles09);
        }
        else if (countImg == 10){
            label.setText("\t\t\t9 из 15");
            img.setImageResource(R.drawable.goldwithpebbles10);
        }
        else if (countImg == 11){
            label.setText("\t\t\t10 из 15");
            img.setImageResource(R.drawable.goldwithpebbles11);
        }
        else if (countImg == 12){
            label.setText("\t\t\t11 из 15");
            img.setImageResource(R.drawable.goldwithpebbles12);
        }
        else if (countImg == 13){
            label.setText("\t\t\t12 из 15");
            img.setImageResource(R.drawable.goldwithpebbles13);
        }
        else if (countImg == 14){
            label.setText("\t\t\t13 из 15");
            img.setImageResource(R.drawable.goldwithpebbles14);
        }
        else if (countImg == 15){
            label.setText("\t\t\t14 из 15");
            img.setImageResource(R.drawable.goldwithpebbles15);
            toRight.setImageResource(R.drawable.torightactive);
        }
        else if (countImg == 16){
            label.setText("\t\t\t15 из 15");
            img.setImageResource(R.drawable.goldwithpebbles01);
            toRight.setImageResource(R.drawable.torightpassiv);
        }
        else if (countImg == 17)
            countImg = 16;

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