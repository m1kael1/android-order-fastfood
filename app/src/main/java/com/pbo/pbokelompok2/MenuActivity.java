package com.pbo.pbokelompok2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MenuActivity extends AppCompatActivity {
    private EditText editTextMakanan;
    private EditText editTextMinuman;
    private EditText editTextJumlahMakanan;
    private EditText editTextJumlahMinuman;

    // List makanan dan harga
    private HashMap<String, Integer> listMakanan;
    // List minuman dan harga
    private HashMap<String, Integer> listMinuman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        editTextMakanan = findViewById(R.id.editTextMakanan);
        editTextMinuman = findViewById(R.id.editTextMinuman);
        editTextJumlahMakanan = findViewById(R.id.editTextJumlahMakanan);
        editTextJumlahMinuman = findViewById(R.id.editTextJumlahMinuman);

        listMakanan = new HashMap<>();
        listMakanan.put("CHEESE BURGER", 20000);
        listMakanan.put("CHICKEN BURGER", 25000);
        listMakanan.put("BEEF BURGER", 25000);
        listMakanan.put("DOUBLE CHEESE BURGER", 35000);
        listMakanan.put("FRENCH FRIES", 15000);


        listMinuman = new HashMap<>();
        listMinuman.put("ICE CREAM", 7000);
        listMinuman.put("COCA COLA", 12000);
        listMinuman.put("MINERAL", 8000);
        listMinuman.put("ICE COFFEE", 17000);

        Button btnKembali = findViewById(R.id.btn02);
        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        Button btnLanjut = findViewById(R.id.btn03);
        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String makanan = editTextMakanan.getText().toString();
                String minuman = editTextMinuman.getText().toString();

                // Validasi input menu makanan
                if (!isValidMenu(makanan, listMakanan)) {
                    Toast.makeText(MenuActivity.this, "Menu makanan tidak valid", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Validasi input menu minuman
                if (!isValidMenu(minuman, listMinuman)) {
                    Toast.makeText(MenuActivity.this, "Menu minuman tidak valid", Toast.LENGTH_SHORT).show();
                    return;
                }

                int jumlahMakanan = 0;
                try {
                    jumlahMakanan = Integer.parseInt(editTextJumlahMakanan.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(MenuActivity.this, "Jumlah pesanan makanan tidak valid", Toast.LENGTH_SHORT).show();
                    return;
                }

                int jumlahMinuman = 0;
                try {
                    jumlahMinuman = Integer.parseInt(editTextJumlahMinuman.getText().toString());
                } catch (NumberFormatException e) {
                    Toast.makeText(MenuActivity.this, "Jumlah pesanan minuman tidak valid", Toast.LENGTH_SHORT).show();
                    return;
                }

                openKonfirmasiActivity(makanan, minuman, jumlahMakanan, jumlahMinuman);
            }
        });
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openKonfirmasiActivity(String makanan, String minuman, int jumlahMakanan, int jumlahMinuman) {
        Intent intent = new Intent(this, KonfirmasiActivity.class);
        intent.putExtra("makanan", makanan);
        intent.putExtra("minuman", minuman);
        intent.putExtra("jumlahMakanan", jumlahMakanan);
        intent.putExtra("jumlahMinuman", jumlahMinuman);
        startActivity(intent);
    }

    // Validasi input menu
    private boolean isValidMenu(String menu, HashMap<String, Integer> listMenu) {
        return listMenu.containsKey(menu);
    }
}
