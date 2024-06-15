package com.example.beadser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
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
    public void ToInfColorOfBeads(View view) {
        Intent intentToICOB = new Intent(Information.this, InfColorOfBeads.class);
        startActivity(intentToICOB);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    public void ToInfTranspatencyOfBeads(View view) {
        Intent intentToITOB = new Intent(Information.this, InfTranspatencyOfBeads.class);
        startActivity(intentToITOB);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    public void ToCategoriesOfBeads(View view) {
        Intent intentToCategories = new Intent(Information.this, CategoriesOfBeads.class);
        startActivity(intentToCategories);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    public void ToTeshKrestik(View view) {
        Intent intentToKrestik = new Intent(Information.this, TeshKrestik.class);
        startActivity(intentToKrestik);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    public void ToTeshFlower(View view) {
        Intent intentToFlower = new Intent(Information.this, TeshFlower.class);
        startActivity(intentToFlower);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    public void ToTeshCanvas(View view) {
        Intent intentToCanvas = new Intent(Information.this, TeshCanvas.class);
        startActivity(intentToCanvas);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    public void ToAmigurumi1(View view) {
        Intent intentToCanvas = new Intent(Information.this, InfAmigurumiPartOne.class);
        startActivity(intentToCanvas);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }

    public void ToAmigurumi2(View view) {
        Intent intentToCanvas = new Intent(Information.this, InfAmigurumiPartTwo.class);
        startActivity(intentToCanvas);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}