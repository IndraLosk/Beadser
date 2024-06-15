package com.example.beadser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Figures extends AppCompatActivity {

    private boolean isClickLizard = false;
    private boolean isClickFox = false;
    private boolean isClickCapybara = false;
    private boolean isClickUmyum = false;
    ImageView starImageView1, starImageView2, starImageView3, starImageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_figures);
        starImageView1 = findViewById(R.id.star1);
        starImageView2 = findViewById(R.id.star2);
        starImageView3 = findViewById(R.id.star3);
        starImageView4 = findViewById(R.id.star4);

        restorationValueSharedPreferences("starForLizard", -1, starImageView1);
        restorationValueSharedPreferences("starForFox", -1, starImageView2);
        restorationValueSharedPreferences("starForCapybara", -1, starImageView3);
        restorationValueSharedPreferences("starForUmyum", -1, starImageView4);
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
    public void saveValueSharedPreferencesIsFavorite (String s, int star){
        // Сохранение значения в SharedPreferences
        SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
        editor.putInt(s, star);
        editor.apply();
    }

    public void restorationValueSharedPreferences(String s, int i, ImageView starImageView) {

        // Восстановление значения из SharedPreferences
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        int savedImageResourceId = prefs.getInt(s, i);
        if (savedImageResourceId != -1) {
            starImageView.setImageResource(savedImageResourceId);
        }
    }

    public Boolean objToFavorite(String isVisible, String isClick, Boolean b, Boolean isClickPref){
        //передача SharedPreferences в Favorite
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(isVisible, b);
        editor.apply();

        isClickPref = preferences.getBoolean(isClick, b);

        editor.putBoolean(isClick, b);
        editor.apply();
        return isClickPref;
    }
    public void Lizard(View view) {
        Intent intentLizard = new Intent(Figures.this, Lizard.class);
        startActivity(intentLizard);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void LizardFavorite(View view) {
        if (isClickLizard) {
            saveValueSharedPreferencesIsFavorite("starForLizard", R.drawable.notfavorite);
            restorationValueSharedPreferences("starForLizard", -1, starImageView1);
            isClickLizard = objToFavorite("isLizardVisible", "isClickLizard", false, isClickLizard);
        } else {
            saveValueSharedPreferencesIsFavorite("starForLizard", R.drawable.favorite);
            restorationValueSharedPreferences("starForLizard", -1, starImageView1);
            isClickLizard = objToFavorite("isLizardVisible", "isClickLizard", true, isClickLizard);
        }
    }

    public void Fox(View view) {
        Intent intentFox = new Intent(Figures.this, Fox.class);
        startActivity(intentFox);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void FoxFavorite(View view) {
        if (isClickFox) {
            saveValueSharedPreferencesIsFavorite("starForFox", R.drawable.notfavorite);
            restorationValueSharedPreferences("starForFox", -1, starImageView2);
            isClickFox = objToFavorite("isFoxVisible", "isClickFox", false, isClickFox);
        } else {
            saveValueSharedPreferencesIsFavorite("starForFox", R.drawable.favorite);
            restorationValueSharedPreferences("starForFox", -1, starImageView2);
            isClickFox = objToFavorite("isFoxVisible", "isClickFox", true, isClickFox);
        }
    }

    public void Capybara(View view) {
        Intent intentCapybara = new Intent(Figures.this, Capybara.class);
        startActivity(intentCapybara);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void CapybaraFavorite(View view) {
        if (isClickCapybara) {
            saveValueSharedPreferencesIsFavorite("starForCapybara", R.drawable.notfavorite);
            restorationValueSharedPreferences("starForCapybara", -1, starImageView3);
            isClickCapybara = objToFavorite("isCapybaraVisible", "isClickCapybara", false, isClickCapybara);
        } else {
            saveValueSharedPreferencesIsFavorite("starForCapybara", R.drawable.favorite);
            restorationValueSharedPreferences("starForCapybara", -1, starImageView3);
            isClickCapybara = objToFavorite("isCapybaraVisible", "isClickCapybara", true, isClickCapybara);
        }
    }


    public void Umyum(View view) {
        Intent intentUmyum = new Intent(Figures.this, Umyum.class);
        startActivity(intentUmyum);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void UmyumFavorite(View view) {
        if (isClickUmyum) {
            saveValueSharedPreferencesIsFavorite("starForUmyum", R.drawable.notfavorite);
            restorationValueSharedPreferences("starForUmyum", -1, starImageView4);
            isClickUmyum = objToFavorite("isUmyumVisible", "isClickUmyum", false, isClickUmyum);
        } else {
            saveValueSharedPreferencesIsFavorite("starForUmyum", R.drawable.favorite);
            restorationValueSharedPreferences("starForUmyum", -1, starImageView4);
            isClickUmyum = objToFavorite("isUmyumVisible", "isClickUmyum", true, isClickUmyum);
        }
    }
}