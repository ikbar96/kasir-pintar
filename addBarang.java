package com.example.kasirpintarku;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class addBarang extends AppCompatActivity {

    private EditText nama;
    private EditText kode;
    private EditText hargaa;
    private EditText hargab;
    private EditText stok;
    private EditText letak;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_barang);
        nama = (EditText) findViewById(R.id.add_nama_barang);
        kode = (EditText) findViewById(R.id.add_kode_barang);
        hargaa = (EditText) findViewById(R.id.add_harga_dasar_barang);
        hargab = (EditText) findViewById(R.id.add_harga_jual_barang);
        stok = (EditText) findViewById(R.id.add_stok_barang);
        letak = (EditText) findViewById(R.id.add_letak_barang);
        add = (Button) findViewById(R.id.tombol_add_barang);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEmployee();
                Intent move = new Intent(getApplicationContext(), BarangAtauJasa.class);
                startActivity(move);
            }
        });
    }

    private void addEmployee(){



        class AddEmployee extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(addBarang.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                //Toast.makeText(addBarang.this,"COK", Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                String nama_b = nama.getText().toString();
                String kode_b = kode.getText().toString();
                String hargaa_b = hargaa.getText().toString();
                String hargab_b = hargab.getText().toString();
                String stok_b = stok.getText().toString();
                String letak_b = letak.getText().toString();
                params.put(konfigurasi.TAG_NAMA_BARANG,nama_b);
                params.put(konfigurasi.TAG_KODE,kode_b);
                params.put(konfigurasi.TAG_HARGA_DASAR,hargaa_b);
                params.put(konfigurasi.TAG_HARGA_JUAL,hargab_b);
                params.put(konfigurasi.TAG_STOK,stok_b);
                params.put(konfigurasi.TAG_LETAK_RAK,letak_b);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(konfigurasi.URL_ADD_BARANG, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }
}
