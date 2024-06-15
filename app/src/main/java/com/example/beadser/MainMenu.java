package com.example.beadser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Вы точно хотите выйти?");
        builder.setCancelable(false);
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // закрыть текущую активити
            }
        });
        builder.setNegativeButton("Отмена", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public void MMInformation(View view) {  // метод onClick
        //с гланого меню на экран информации
        Intent intentMMI = new Intent(MainMenu.this, Information.class);
        startActivity(intentMMI);
        //анимация
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void MMRings(View view) {
        Intent intentMMR = new Intent(MainMenu.this, Rings.class);
        startActivity(intentMMR);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void MMBraslet(View view) {
        Intent intentMMB = new Intent(MainMenu.this, Braslets.class);
        startActivity(intentMMB);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void MMFigures(View view) {
        Intent intentMMF = new Intent(MainMenu.this, Figures.class);
        startActivity(intentMMF);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void MMFavorite(View view) {
        Intent intentMMFav = new Intent(MainMenu.this, Favorites.class);
        startActivity(intentMMFav);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void MMNew(View view) {
        Intent intentMMN = new Intent(MainMenu.this, CrateNew.class);
        startActivity(intentMMN);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}