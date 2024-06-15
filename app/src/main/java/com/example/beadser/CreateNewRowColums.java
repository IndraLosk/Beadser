package com.example.beadser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.documentfile.provider.DocumentFile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.DexterBuilder;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import yuku.ambilwarna.AmbilWarnaDialog;
import android.Manifest.permission;



public class CreateNewRowColums extends AppCompatActivity {

    private TableLayout tableLayout;
    private Button[][] buttons;
    private int n, m; // Задаем размеры таблицы
    int [][] colorButtons;

    int defaultColor;
    ImageButton imageColorPicker, imgGoToBack, imageGoToForward;

    boolean pipetteFlag = false;

    ArrayList<Integer> historyColor = new ArrayList<>();
    ArrayList<Integer> historyColorForward = new ArrayList<>();

    TextView tv, tv2;

    private static final int REQUEST_CODE_ACCESS_FILES = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_row_colums);

        tv = findViewById(R.id.back);
        tv2 = findViewById(R.id.notback);
        imageColorPicker = findViewById(R.id.imageColorPicker);
        imgGoToBack = findViewById(R.id.imageGoToBack);
        imageGoToForward = findViewById(R.id.imageGoToForward);

        Intent intent = getIntent();
        String textRows = intent.getStringExtra("rows");
        int numRows = Integer.parseInt(textRows);
        String textColums = intent.getStringExtra("colums");
        int numColums = Integer.parseInt(textColums);

        defaultColor = ContextCompat.getColor(CreateNewRowColums.this, R.color.white);

        n = numRows; // количество строк
        m = numColums; // количество столбцов

        tableLayout = findViewById(R.id.tableLayout);
        buttons = new Button[n][m];

        colorButtons = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                colorButtons[i][j] = defaultColor;
            }
        }

        for (int i = 0; i < n; i++) {
            TableRow row = new TableRow(this);
            for (int j = 0; j < m; j++) {
                buttons[i][j] = new Button(this);
                buttons[i][j].setWidth(150); // Задаем ширину кнопки
                buttons[i][j].setHeight(100); // Задаем высоту кнопки

                // Изменение цвета границ кнопки
                GradientDrawable border = new GradientDrawable();
                border.setColor(Color.WHITE); // белый цвет фона
                border.setStroke(3, Color.BLACK); // толщина 3px и черный цвет границы
                buttons[i][j].setBackground(border);

                row.addView(buttons[i][j]);
                int finalI = i;
                int finalJ = j;

                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(pipetteFlag){
                            defaultColor = colorButtons[finalI][finalJ];
                            pipetteFlag = false;
                        }
                        else {
                            historyColor.add(finalI);
                            historyColor.add(finalJ);
                            historyColor.add(defaultColor);
                            changeColor(finalI, finalJ, defaultColor);
                            imgGoToBack.setImageResource(R.drawable.newrowcolumn03);
                            imageGoToForward.setImageResource(R.drawable.newrowcolumn07);
                            historyColorForward.clear();
                        }
                    }
                });
            }
            tableLayout.addView(row);
        }

    }

    public void changeColor(int i, int j, int color){
        GradientDrawable border = new GradientDrawable();
        border.setColor(color); // установить цвет фона
        border.setStroke(3, Color.BLACK); // толщина 3px и черный цвет границы
        buttons[i][j].setBackground(border);
        colorButtons[i][j] = color;
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


    public void openColorPicker(View view) {
        AmbilWarnaDialog ambilWarnaDialog = new AmbilWarnaDialog(this, defaultColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {}
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                defaultColor = color;
            }
        });
        ambilWarnaDialog.show();
    }

    public void clickPipette(View view) {
        pipetteFlag = true;
    }

    public void clickGoToBack(View view) {

        if (historyColor.isEmpty()) {
            return;
        }
        int x = historyColor.get(historyColor.size() - 3);
        int y = historyColor.get(historyColor.size() - 2);
        int prevColor = historyColor.get(historyColor.size() - 1);
        // удаление последних трех элементов из массива historyColor (текущий цвет, координаты x и y)
        historyColor.remove(historyColor.size() - 1);
        historyColor.remove(historyColor.size() - 1);
        historyColor.remove(historyColor.size() - 1);

        // добавление элементов из historyColor в historyColorForward
        historyColorForward.add(x);
        historyColorForward.add(y);
        historyColorForward.add(prevColor);
        if (historyColor.isEmpty()) {
            imgGoToBack.setImageResource(R.drawable.newrowcolumn06);
        }
        // проверка, есть ли предыдущий цвет для ячейки (x, y) в массиве historyColor
        boolean isHistory = false;
        for (int i = historyColor.size() - 1; i >= 0; i--) {
            if (historyColor.get(i) == y && historyColor.get(i - 1) == x) {
                prevColor = historyColor.get(i - 2);
                isHistory = true;
                break;
            }
        }
        // изменение цвета ячейки (x, y) на предыдущий или белый, если предыдущего цвета нет
        if (isHistory) {
            changeColor(x, y, prevColor);
        } else {
            changeColor(x, y, Color.WHITE);
        }
        imageGoToForward.setImageResource(R.drawable.newrowcolumn04);
    }



    public void clickGoToForward(View view) {
        if (historyColorForward.isEmpty()) {
            return;
        }

        imgGoToBack.setImageResource(R.drawable.newrowcolumn03);

        int x = historyColorForward.get(historyColorForward.size() - 3);
        int y = historyColorForward.get(historyColorForward.size() - 2);
        int prevColor = historyColorForward.get(historyColorForward.size() - 1);

        // добавляем элементы из historyColorForward в historyColor
        historyColor.add(x);
        historyColor.add(y);
        historyColor.add(prevColor);

        // меняем цвет ячейки (x, y) на предыдущий
        changeColor(x, y, prevColor);

        // удаляем последние три элемента из historyColorForward
        historyColorForward.remove(historyColorForward.size() - 1);
        historyColorForward.remove(historyColorForward.size() - 1);
        historyColorForward.remove(historyColorForward.size() - 1);

        if (historyColorForward.isEmpty()) {
            imageGoToForward.setImageResource(R.drawable.newrowcolumn07);
        }
    }

    public void clickSave(View view) throws IOException {

        // создаем папку для вашего приложения, если ее еще нет
        File appDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "beadser");
        if (!appDir.exists()) {
            appDir.mkdir();
        }

        // создаем файл для сохранения изображения
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        String date = format.format(new Date());
        File file = new File(appDir, date + ".png");

        int tableWidth = 0;
        int tableHeight = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // получаем размеры кнопки
                int width = buttons[i][j].getMeasuredWidth();
                int height = buttons[i][j].getMeasuredHeight();

                // вычисляем общие размеры таблицы
                tableWidth = Math.max(tableWidth, width + j * width);
                tableHeight = Math.max(tableHeight, height + i * height);
            }
        }


// создаем экземпляр Bitmap с размерами таблицы кнопок
        Bitmap bitmap = Bitmap.createBitmap(tableWidth, tableHeight, Bitmap.Config.ARGB_8888);

// создаем экземпляр Canvas и передаем в него экземпляр Bitmap
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
//// нарисовываем таблицу кнопок на экземпляре Canvas

        // создаем экземпляр Paint для рисования границ ячеек
        Paint paintBorder = new Paint();
        paintBorder.setColor(Color.BLACK); // цвет границ
        paintBorder.setStrokeWidth(2); // толщина границ
        paintBorder.setStyle(Paint.Style.STROKE); // стиль границ

// нарисовываем таблицу кнопок на экземпляре Canvas
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // получаем координаты и размеры кнопки
                int x = j * buttons[i][j].getMeasuredWidth();
                int y = i * buttons[i][j].getMeasuredHeight();
                int width = buttons[i][j].getMeasuredWidth();
                int height = buttons[i][j].getMeasuredHeight();

                // нарисовываем кнопку на экземпляре Canvas
                paint.setColor(colorButtons[i][j]);
                canvas.drawRect(x, y, x + width, y + height, paint);

                // нарисовываем границы ячеек на экземпляре Canvas
                canvas.drawRect(x, y, x + width, y + height, paintBorder);
            }
        }
        // сохраняем изображение в формате PNG
        try (FileOutputStream fos = new FileOutputStream(file)) {
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            Toast.makeText(this, "Изображение успешно сохранено", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "Ошибка при сохранении изображения", Toast.LENGTH_SHORT).show();
            throw new RuntimeException(e);
        }
    }

}