package com.example.kasirpintarku;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailBarangatauJasa extends AppCompatActivity {

    private TextView nama;
    private TextView kode;
    private TextView harga;
    private TextView stok_barang;
    private TextView kategori;
    private TextView letak;
    int no_barang=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barangatau_jasa);
        nama = (TextView) findViewById(R.id.det_nama);
        kode = (TextView) findViewById(R.id.kod_barang);
        harga = (TextView) findViewById(R.id.har_jual);
        stok_barang = (TextView) findViewById(R.id.stok_barang);
        kategori = (TextView) findViewById(R.id.kat_barang);
        letak = (TextView) findViewById(R.id.let_barang);
        no_barang = getIntent().getExtras().getInt("nomor");
        getJSON();
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DetailBarangatauJasa.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showBarang(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(konfigurasi.URL_GET_BARANGBY,String.valueOf(no_barang));
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    private void showBarang(String Json){
        try {

            JSONObject jsonObject = new JSONObject(Json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            for(int i = 0; i<result.length(); i++) {
                JSONObject jo = result.getJSONObject(i);
                kode.setText(jo.getString(konfigurasi.TAG_KODE));
                nama.setText(jo.getString(konfigurasi.TAG_NAMA_BARANG));
                harga.setText("Rp."+jo.getString(konfigurasi.TAG_HARGA_JUAL));
                stok_barang.setText(jo.getString(konfigurasi.TAG_STOK));
                kategori.setText(jo.getString(konfigurasi.TAG_KET_KATEGORI));
                letak.setText(jo.getString(konfigurasi.TAG_LETAK_RAK));
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
