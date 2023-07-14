package com.pbo.pbokelompok2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;

public class KonfirmasiActivity extends AppCompatActivity {

    private TextView textViewMakanan;
    private TextView textViewMinuman;
    private TextView textViewTotalHarga;


    private HashMap<String, Integer> listMakanan;
    private HashMap<String, Integer> listMinuman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi);

        textViewMakanan = findViewById(R.id.textViewMakanan);
        textViewMinuman = findViewById(R.id.textViewMinuman);
        textViewTotalHarga = findViewById(R.id.textViewTotalHarga);

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
        listMinuman.put("ICE COFFE", 17000);

        Button btnTidak = findViewById(R.id.btn05);
        btnTidak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMenuActivity();
            }
        });

        Button btnYa = findViewById(R.id.btn04);
        btnYa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String makanan = getIntent().getStringExtra("makanan");
                String minuman = getIntent().getStringExtra("minuman");
                int jumlahMakanan = getIntent().getIntExtra("jumlahMakanan", 0);
                int jumlahMinuman = getIntent().getIntExtra("jumlahMinuman", 0);

                int hargaMakanan = listMakanan.get(makanan);
                int hargaMinuman = listMinuman.get(minuman);
                int totalHarga = (hargaMakanan * jumlahMakanan) + (hargaMinuman * jumlahMinuman);

                // Membuat intent untuk StrukActivity
                Intent intent = new Intent(KonfirmasiActivity.this, StrukActivity.class);
                intent.putExtra("makanan", makanan);
                intent.putExtra("minuman", minuman);
                intent.putExtra("jumlahMakanan", jumlahMakanan);
                intent.putExtra("jumlahMinuman", jumlahMinuman);
                intent.putExtra("totalHarga", totalHarga);

                // Memulai StrukActivity
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            String makanan = intent.getStringExtra("makanan");
            String minuman = intent.getStringExtra("minuman");
            int jumlahMakanan = intent.getIntExtra("jumlahMakanan", 0);
            int jumlahMinuman = intent.getIntExtra("jumlahMinuman", 0);

            int hargaMakanan = listMakanan.get(makanan);
            int hargaMinuman = listMinuman.get(minuman);
            int totalHarga = (hargaMakanan * jumlahMakanan) + (hargaMinuman * jumlahMinuman);

            textViewMakanan.setText(makanan + " (Rp " + hargaMakanan + ")" + " x " + jumlahMakanan);
            textViewMinuman.setText(minuman + " (Rp " + hargaMinuman + ") " + "x " + jumlahMinuman);
            textViewTotalHarga.setText("Total Harga: Rp " + totalHarga);

        }
    }

    public void openMenuActivity(){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}
