package com.pbo.pbokelompok2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class StrukActivity extends AppCompatActivity {

    private TextView textViewNomorPesanan;
    private TextView textViewMakanan;
    private TextView textViewMinuman;
    private TextView textViewTotalHarga;
    private TextView textViewJumlahMakanan;
    private TextView textViewJumlahMinuman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_struk);

        textViewNomorPesanan = findViewById(R.id.textViewNomorPesanan);
        textViewMakanan = findViewById(R.id.textViewMakanan);
        textViewMinuman = findViewById(R.id.textViewMinuman);
        textViewTotalHarga = findViewById(R.id.textViewTotalHarga);
        textViewJumlahMakanan = findViewById(R.id.textViewJumlahMakanan);
        textViewJumlahMinuman = findViewById(R.id.textViewJumlahMinuman);

        Button btnSelesai = findViewById(R.id.btn06);
        btnSelesai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            String makanan = intent.getStringExtra("makanan");
            String minuman = intent.getStringExtra("minuman");
            int totalHarga = intent.getIntExtra("totalHarga", 0);
            int jumlahMakanan = intent.getIntExtra("jumlahMakanan", 0);
            int jumlahMinuman = intent.getIntExtra("jumlahMinuman", 0);
            int nomorPesanan = generateRandomNumber();

            textViewNomorPesanan.setText("Nomor Pesanan : " + nomorPesanan);
            textViewMakanan.setText("Makanan : " + makanan);
            textViewTotalHarga.setText("Total Harga : Rp " + totalHarga);
            textViewJumlahMakanan.setText("Jumlah Makanan : " + jumlahMakanan);
            textViewMinuman.setText("Minuman : " + minuman);
            textViewJumlahMinuman.setText("Jumlah Minuman: " + jumlahMinuman);
        }
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10000);
    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
