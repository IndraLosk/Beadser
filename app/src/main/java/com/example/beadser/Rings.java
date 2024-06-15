package com.example.beadser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Rings extends AppCompatActivity {

    private boolean isClickYellowBlack = false;
    private boolean isClickCherry = false;
    private boolean isClickChamomile = false;
    private boolean isClickIntertwined = false;
    ImageView starImageView1, starImageView2, starImageView3, starImageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rings);

        starImageView1 = findViewById(R.id.star1);
        starImageView2 = findViewById(R.id.star2);
        starImageView3 = findViewById(R.id.star3);
        starImageView4 = findViewById(R.id.star4);

        restorationValueSharedPreferences("starForYellowBlack", -1, starImageView1);
        restorationValueSharedPreferences("starForCherry", -1, starImageView2);
        restorationValueSharedPreferences("starForChamomile", -1, starImageView3);
        restorationValueSharedPreferences("starForIntertwined", -1, starImageView4);
    }

    public void Back(View view) {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
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

    public void YelowBlack(View view) {
        Intent intentYBRing = new Intent(Rings.this, YelowBlackRing.class);
        startActivity(intentYBRing);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    }

    public void YellowBlackFavorite(View view) {
        if(isClickYellowBlack){
            saveValueSharedPreferencesIsFavorite("starForYellowBlack", R.drawable.notfavorite);
            restorationValueSharedPreferences("starForYellowBlack", -1, starImageView1);
            isClickYellowBlack = objToFavorite("isYellowBlackVisible", "isClickYellowBlack", false, isClickYellowBlack);
        }
        else {
            saveValueSharedPreferencesIsFavorite("starForYellowBlack", R.drawable.favorite);
            restorationValueSharedPreferences("starForYellowBlack", -1, starImageView1);
            isClickYellowBlack = objToFavorite("isYellowBlackVisible", "isClickYellowBlack", true, isClickYellowBlack);
        }
    }

    public void Cherry(View view) {
        Intent intentCherryRing = new Intent(Rings.this, Cherry.class);
        startActivity(intentCherryRing);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void CherryFavorite(View view) {
        if(isClickCherry){
            saveValueSharedPreferencesIsFavorite("starForCherry", R.drawable.notfavorite);
            restorationValueSharedPreferences("starForCherry", -1, starImageView2);
            isClickYellowBlack = objToFavorite("isCherryVisible", "isClickCherry", false, isClickCherry);
        }
        else {
            saveValueSharedPreferencesIsFavorite("starForCherry", R.drawable.favorite);
            restorationValueSharedPreferences("starForCherry", -1, starImageView2);
            isClickCherry = objToFavorite("isCherryVisible", "isClickCherry", true, isClickCherry);
        }
    }

    public void Chamomile(View view) {
        Intent intentChamomileRing = new Intent(Rings.this, Chamomile.class);
        startActivity(intentChamomileRing);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void ChamomileFavorite(View view) {
        if(isClickChamomile){
            saveValueSharedPreferencesIsFavorite("starForChamomile", R.drawable.notfavorite);
            restorationValueSharedPreferences("starForChamomile", -1, starImageView3);
            isClickChamomile = objToFavorite("isChamomileVisible", "isClickChamomile", false, isClickChamomile);
        }
        else {
            saveValueSharedPreferencesIsFavorite("starForChamomile", R.drawable.favorite);
            restorationValueSharedPreferences("starForChamomile", -1, starImageView3);
            isClickChamomile = objToFavorite("isChamomileVisible", "isClickChamomile", true, isClickChamomile);
        }
    }

    public void Intertwined(View view) {
        Intent intentIntertwinedRing = new Intent(Rings.this, Intertwined.class);
        startActivity(intentIntertwinedRing);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void IntertwinedFavorite(View view) {
        if(isClickIntertwined){
            saveValueSharedPreferencesIsFavorite("starForIntertwined", R.drawable.notfavorite);
            restorationValueSharedPreferences("starForIntertwined", -1, starImageView4);
            isClickIntertwined = objToFavorite("isIntertwinedVisible", "isClickIntertwined", false, isClickIntertwined);
        }
        else {
            saveValueSharedPreferencesIsFavorite("starForIntertwined", R.drawable.favorite);
            restorationValueSharedPreferences("starForIntertwined", -1, starImageView4);
            isClickIntertwined = objToFavorite("isIntertwinedVisible", "isClickIntertwined", true, isClickIntertwined);
        }
    }
}