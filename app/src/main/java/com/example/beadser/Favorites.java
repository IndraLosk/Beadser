package com.example.beadser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Favorites extends AppCompatActivity {

    //rings
    private boolean isClickYellowBlack = false;
    private boolean isClickCherry = false;
    private boolean isClickChamomile = false;
    private boolean isClickIntertwined = false;

    //braslets
    private boolean isClickIDgoldWithPedding = false;
    private boolean isClickHearts = false;
    private boolean isClickRowOfHearts = false;
    private boolean isClickBraided = false;

    //figures
    private boolean isClickLizard = false;
    private boolean isClickFox = false;
    private boolean isClickCapybara = false;
    private boolean isClickUmyum = false;

    private int count = 0;
    int[] favorPicture = new int[15];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        //rings
        isClickYellowBlack = preferences.getBoolean("isYellowBlackVisible", false);
        isClickCherry = preferences.getBoolean("isCherryVisible", false);
        isClickChamomile = preferences.getBoolean("isChamomileVisible", false);
        isClickIntertwined = preferences.getBoolean("isIntertwinedVisible", false);

        //braslets
        isClickIDgoldWithPedding = preferences.getBoolean("isIDgoldWithPeddingVisible", false);
        isClickHearts = preferences.getBoolean("isHeartsVisible", false);
        isClickRowOfHearts = preferences.getBoolean("isRowOfHeartsVisible", false);
        isClickBraided = preferences.getBoolean("isBraidedVisible", false);

        //figures
        isClickLizard = preferences.getBoolean("isLizardVisible", false);
        isClickFox = preferences.getBoolean("isFoxVisible", false);
        isClickCapybara = preferences.getBoolean("isCapybaraVisible", false);
        isClickUmyum = preferences.getBoolean("isUmyumVisible", false);

        ImageView img1 = findViewById(R.id.imageView1);
        ImageView img2 = findViewById(R.id.imageView2);
        ImageView img3 = findViewById(R.id.imageView3);
        ImageView img4 = findViewById(R.id.imageView4);
        ImageView img5 = findViewById(R.id.imageView5);
        ImageView img6 = findViewById(R.id.imageView6);
        ImageView img7 = findViewById(R.id.imageView7);
        ImageView img8 = findViewById(R.id.imageView8);
        ImageView img9 = findViewById(R.id.imageView9);
        ImageView img10 = findViewById(R.id.imageView10);
        ImageView img11 = findViewById(R.id.imageView11);
        ImageView img12 = findViewById(R.id.imageView12);
        ImageView img13 = findViewById(R.id.imageView13);
        ImageView img14 = findViewById(R.id.imageView14);
        ImageView img15 = findViewById(R.id.imageView15);

        //rings
        isVisibleCheck(isClickYellowBlack, R.drawable.yelowblackring01);
        isVisibleCheck(isClickCherry, R.drawable.cherryring01);
        isVisibleCheck(isClickChamomile, R.drawable.chamomile01);
        isVisibleCheck(isClickIntertwined, R.drawable.intertwined01);

        //braslets
        isVisibleCheck(isClickIDgoldWithPedding, R.drawable.goldwithpebbles01);
        isVisibleCheck(isClickHearts, R.drawable.hearts01);
        isVisibleCheck(isClickRowOfHearts, R.drawable.rowsofhearts01);
        isVisibleCheck(isClickBraided, R.drawable.braided01);

        //figures
        isVisibleCheck(isClickLizard, R.drawable.lizard01);
        isVisibleCheck(isClickFox, R.drawable.fox01);
        isVisibleCheck(isClickCapybara, R.drawable.capybara01);
        isVisibleCheck(isClickUmyum, R.drawable.umyum01);

        for (int i = 0; i < count; i++) {
            if (i == 0) img1.setImageResource(favorPicture[i]);
            if (i == 1) img2.setImageResource(favorPicture[i]);
            if (i == 2) img3.setImageResource(favorPicture[i]);
            if (i == 3) img4.setImageResource(favorPicture[i]);
            if (i == 4) img5.setImageResource(favorPicture[i]);
            if (i == 5) img6.setImageResource(favorPicture[i]);
            if (i == 6) img7.setImageResource(favorPicture[i]);
            if (i == 7) img8.setImageResource(favorPicture[i]);
            if (i == 8) img9.setImageResource(favorPicture[i]);
            if (i == 9) img10.setImageResource(favorPicture[i]);
            if (i == 10) img11.setImageResource(favorPicture[i]);
            if (i == 11) img12.setImageResource(favorPicture[i]);
            if (i == 12) img13.setImageResource(favorPicture[i]);
            if (i == 13) img14.setImageResource(favorPicture[i]);
            if (i == 14) img15.setImageResource(favorPicture[i]);
        }

        if (favorPicture[0] == 0){
            Toast toast = Toast.makeText(getApplicationContext(), "Здесь пока ничего нет!", Toast.LENGTH_SHORT);
            toast.show();
        }

        if(favorPicture[0] == 0){
            img1.setVisibility(View.GONE);
            img2.setVisibility(View.GONE);
            img3.setVisibility(View.GONE);
        }
        if(favorPicture[3] == 0){
            img4.setVisibility(View.GONE);
            img5.setVisibility(View.GONE);
            img6.setVisibility(View.GONE);
        }
        if(favorPicture[6] == 0){
            img7.setVisibility(View.GONE);
            img8.setVisibility(View.GONE);
            img9.setVisibility(View.GONE);
        }
        if(favorPicture[9] == 0){
            img10.setVisibility(View.GONE);
            img11.setVisibility(View.GONE);
            img12.setVisibility(View.GONE);
        }
        if(favorPicture[12] == 0){
            img13.setVisibility(View.GONE);
            img14.setVisibility(View.GONE);
            img15.setVisibility(View.GONE);
        }
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

    //rings
    public void toYellowBlack() {
        Intent intent = new Intent(Favorites.this, YelowBlackRing.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void toCherry() {
        Intent intent = new Intent(Favorites.this, Cherry.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void toChamomile() {
        Intent intent = new Intent(Favorites.this, Chamomile.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void toIntertwined() {
        Intent intent = new Intent(Favorites.this, Intertwined.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }


    //figures
    public void toLizard() {
        Intent intent = new Intent(Favorites.this, Lizard.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void toFox() {
        Intent intent = new Intent(Favorites.this, Fox.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void toCapybara() {
        Intent intent = new Intent(Favorites.this, Capybara.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void toUmyum() {
        Intent intent = new Intent(Favorites.this, Umyum.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    //braslets
    public void toGoldWithPedding() {
        Intent intent = new Intent(Favorites.this, GoldWithPeddles.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void toHearts() {
        Intent intent = new Intent(Favorites.this, Hearts.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void toRowOfHearts() {
        Intent intent = new Intent(Favorites.this, RowsOfHearts.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void toBraided() {
        Intent intent = new Intent(Favorites.this, Braided.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void isVisibleCheck(Boolean isVisible, int r) {
        if (isVisible) {
            favorPicture[count] = r;
            count++;
        }
    }

    public void fromTo(int i) {
        //rings
        if (favorPicture[i] == R.drawable.yelowblackring01) toYellowBlack();
        else if (favorPicture[i] == R.drawable.cherryring01) toCherry();
        else if (favorPicture[i] == R.drawable.chamomile01) toChamomile();
        else if (favorPicture[i] == R.drawable.intertwined01) toIntertwined();

            //braslets
        else if (favorPicture[i] == R.drawable.goldwithpebbles01) toGoldWithPedding();
        else if (favorPicture[i] == R.drawable.hearts01) toHearts();
        else if (favorPicture[i] == R.drawable.rowsofhearts01) toRowOfHearts();
        else if (favorPicture[i] == R.drawable.braided01) toBraided();

            //figures
        else if (favorPicture[i] == R.drawable.lizard01) toLizard();
        else if (favorPicture[i] == R.drawable.fox01) toFox();
        else if (favorPicture[i] == R.drawable.capybara01) toCapybara();
        else if (favorPicture[i] == R.drawable.umyum01) toUmyum();
    }

    public void img1(View view) { fromTo(0); }

    public void img2(View view) {
        fromTo(1);
    }

    public void img3(View view) { fromTo(2); }

    public void img4(View view) {
        fromTo(3);
    }

    public void img5(View view) {
        fromTo(4);
    }

    public void img6(View view) {
        fromTo(5);
    }

    public void img7(View view) { fromTo(6); }

    public void img8(View view) { fromTo(7); }

    public void img9(View view) { fromTo(8); }

    public void img10(View view) {
        fromTo(9);
    }

    public void img11(View view) {
        fromTo(10);
    }

    public void img12(View view) {
        fromTo(11);
    }

    public void img13(View view) {
        fromTo(12);
    }

    public void img14(View view) {
        fromTo(13);
    }

    public void img15(View view) {
        fromTo(14);
    }
}