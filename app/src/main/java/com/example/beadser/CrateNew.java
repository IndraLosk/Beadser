package com.example.beadser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CrateNew extends AppCompatActivity {

    EditText rowsText, columsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crate_new);

        rowsText = findViewById(R.id.editRows); // Находим EditText по его идентификатору
        columsText = findViewById(R.id.editColums); // Находим EditText по его идентификатору

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

    public void ToFenInf(View view) {
        Intent intentFI = new Intent(CrateNew.this, FenechkaInfNew.class);
        startActivity(intentFI);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void ToCreateNewRowColums(View view) {

        try {
        String textRows = rowsText.getText().toString();
        String textColums = columsText.getText().toString();
        Intent intent = new Intent(CrateNew.this, CreateNewRowColums.class);
        intent.putExtra("rows", textRows);
        intent.putExtra("colums", textColums);


            if (!textRows.isEmpty() && !textColums.isEmpty() && !textRows.equals("0") && !textColums.equals("0")) {
                rowsText.setText("");
                columsText.setText("");
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            } else
                Toast.makeText(CrateNew.this, "Введено невеное значение!", Toast.LENGTH_SHORT).show();
        }
        catch (Throwable t) {
            Toast.makeText(CrateNew.this, "Введено невеное значение!", Toast.LENGTH_SHORT).show();
        }
    }

}