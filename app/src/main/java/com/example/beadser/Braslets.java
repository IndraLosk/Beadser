package com.example.beadser;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Braslets extends AppCompatActivity {

    private boolean isClickIDgoldWithPedding = false;
    private boolean isClickHearts = false;
    private boolean isClickRowOfHearts = false;
    private boolean isClickBraided = false;
    ImageView starImageView, starImageView2, starImageView3, starImageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_braslets);
        starImageView = findViewById(R.id.star);
        starImageView2 = findViewById(R.id.star2);
        starImageView3 = findViewById(R.id.star3);
        starImageView4 = findViewById(R.id.star4);

        restorationValueSharedPreferences("starForGoldWithPedding", -1, starImageView);
        restorationValueSharedPreferences("starForHearts", -1, starImageView2);
        restorationValueSharedPreferences("starForRowOfHearts", -1, starImageView3);
        restorationValueSharedPreferences("starForBraided", -1, starImageView4);
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
        // s - название звездочки, star - id изображения
        // Сохранение значения в SharedPreferences
        SharedPreferences.Editor editor = getSharedPreferences("MyPrefs", MODE_PRIVATE).edit();
        editor.putInt(s, star);
        editor.apply();
    }

    public void restorationValueSharedPreferences(String s, int i, ImageView starImageView) {
        //s - название звездочки, i - значение, starImageView - изображение
        // Восстановление значения из SharedPreferences
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        int savedImageResourceId = prefs.getInt(s, i);
        if (savedImageResourceId != -1) {
            starImageView.setImageResource(savedImageResourceId);
        }
    }

    public Boolean objToFavorite(String isVisible, String isClick, Boolean b, Boolean isClickPref){
        //isVisible - проверка отображения, isClick - проверка нажатия
        //b - новое значение, isClickPref - проверка избранного
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

    public void GoldWithPebbles(View view) {
        Intent intentGWP = new Intent(Braslets.this, GoldWithPeddles.class);
        startActivity(intentGWP);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

    }

    public void GoldWithPebblesFavorite(View view) {

        if(isClickIDgoldWithPedding){
            saveValueSharedPreferencesIsFavorite("starForGoldWithPedding", R.drawable.notfavorite);
            restorationValueSharedPreferences("starForGoldWithPedding", -1, starImageView);
            isClickIDgoldWithPedding = objToFavorite("isIDgoldWithPeddingVisible", "isClickIDgoldWithPedding", false, isClickIDgoldWithPedding);
        }
        else {
            saveValueSharedPreferencesIsFavorite("starForGoldWithPedding", R.drawable.favorite);
            restorationValueSharedPreferences("starForGoldWithPedding", -1, starImageView);
            isClickIDgoldWithPedding = objToFavorite("isIDgoldWithPeddingVisible", "isClickIDgoldWithPedding", true, isClickIDgoldWithPedding);
        }
       }

    public void ToHearts(View view) {
        Intent intentToHearts = new Intent(Braslets.this, Hearts.class);
        startActivity(intentToHearts);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void Hearts(View view) {
        if(isClickHearts){
            saveValueSharedPreferencesIsFavorite("starForHearts", R.drawable.notfavorite);
            restorationValueSharedPreferences("starForHearts", -1, starImageView2);
            isClickHearts = objToFavorite("isHeartsVisible", "isClickHearts", false, isClickHearts);
        }
        else {
            saveValueSharedPreferencesIsFavorite("starForHearts", R.drawable.favorite);
            restorationValueSharedPreferences("starForHearts", -1, starImageView2);
            isClickHearts = objToFavorite("isHeartsVisible", "isClickHearts", true, isClickHearts);
        }
    }

    public void ToRowsOfHearts(View view) {
        Intent intentToRowsOfHearts = new Intent(Braslets.this, RowsOfHearts.class);
        startActivity(intentToRowsOfHearts);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void RowOfHeartsFavorite(View view) {
        if(isClickRowOfHearts){
            saveValueSharedPreferencesIsFavorite("starForRowOfHearts", R.drawable.notfavorite);
            restorationValueSharedPreferences("starForRowOfHearts", -1, starImageView3);
            isClickRowOfHearts = objToFavorite("isRowOfHeartsVisible", "isClickRowOfHearts", false, isClickRowOfHearts);
        }
        else {
            saveValueSharedPreferencesIsFavorite("starForRowOfHearts", R.drawable.favorite);
            restorationValueSharedPreferences("starForRowOfHearts", -1, starImageView3);
            isClickRowOfHearts = objToFavorite("isRowOfHeartsVisible", "isClickRowOfHearts", true, isClickRowOfHearts);
        }
    }

    public void ToBraided(View view) {
        Intent intentToBraided = new Intent(Braslets.this, Braided.class);
        startActivity(intentToBraided);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void BraidedFavorite(View view) {
        if(isClickBraided){
            saveValueSharedPreferencesIsFavorite("starForBraided", R.drawable.notfavorite);
            restorationValueSharedPreferences("starForBraided", -1, starImageView4);
            isClickBraided = objToFavorite("isBraidedVisible", "isClickBraided", false, isClickBraided);
        }
        else {
            saveValueSharedPreferencesIsFavorite("starForBraided", R.drawable.favorite);
            restorationValueSharedPreferences("starForBraided", -1, starImageView4);
            isClickBraided = objToFavorite("isBraidedVisible", "isClickBraided", true, isClickBraided);
        }
    }


}