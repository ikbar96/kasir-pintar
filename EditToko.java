package com.example.kasirpintarku;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class EditToko extends AppCompatActivity {
    private EditText k_jenis;
    private EditText k_nama_t;
    private EditText k_pemilik_t;
    private EditText k_telepon_t;
    private EditText k_provinsi_t;
    private EditText k_kota_t;
    private EditText k_alamat_t;
    Button add_t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_toko);
        k_jenis = (EditText) findViewById(R.id.edit_jenis_t);
        k_nama_t = (EditText) findViewById(R.id.edit_nama_t);
        k_pemilik_t = (EditText) findViewById(R.id.edit_namap_t);
        k_telepon_t = (EditText) findViewById(R.id.edit_no_t);
        k_provinsi_t = (EditText) findViewById(R.id.edit_prov_t);
        k_kota_t = (EditText) findViewById(R.id.edit_kota_t);
        k_alamat_t = (EditText) findViewById(R.id.edit_alamat_t);
        add_t = (Button) findViewById(R.id.edit_t);
        getJSON();
        add_t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateToko();
                Intent move = new Intent(getApplicationContext(), EditToko.class);
                startActivity(move);

            }
        });
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(EditToko.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showToko(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_TOKO);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    private void updateToko(){
        final String jenis_t =  k_jenis.getText().toString();
        final String nama_t = k_nama_t.getText().toString();
        final String pemilik_t = k_pemilik_t.getText().toString();
        final String telepon_t = k_telepon_t.getText().toString();
        final String provinsi_t = k_provinsi_t.getText().toString();
        final String kota_t = k_kota_t.getText().toString();
        final String alamat_t = k_alamat_t.getText().toString();

        class UpdateEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(EditToko.this,"Updating...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();

            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(konfigurasi.TAG_JENIS_TOKO,jenis_t);
                hashMap.put(konfigurasi.TAG_NAMA_TOKO,nama_t);
                hashMap.put(konfigurasi.TAG_NAMA_PEMILIK,pemilik_t);
                hashMap.put(konfigurasi.TAG_TELEPON_TOKO,telepon_t);
                hashMap.put(konfigurasi.TAG_PROVINSI,provinsi_t);
                hashMap.put(konfigurasi.TAG_KOTA,kota_t);
                hashMap.put(konfigurasi.TAG_ALAMAT_TOKO,alamat_t);

                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(konfigurasi.URL_UPDATE_TOKO,hashMap);

                return s;
            }
        }

        UpdateEmployee ue = new UpdateEmployee();
        ue.execute();
    }

    private void showToko(String Json){
        try {
            JSONObject jsonObject = new JSONObject(Json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            JSONObject jo = result.getJSONObject(0);
            k_jenis.setText(jo.getString(konfigurasi.TAG_JENIS_TOKO));
            k_nama_t.setText(jo.getString(konfigurasi.TAG_NAMA_TOKO));
            k_pemilik_t.setText(jo.getString(konfigurasi.TAG_NAMA_PEMILIK));
            k_telepon_t.setText(jo.getString(konfigurasi.TAG_TELEPON_TOKO));
            k_provinsi_t.setText(jo.getString(konfigurasi.TAG_PROVINSI));
            k_kota_t.setText(jo.getString(konfigurasi.TAG_KOTA));
            k_alamat_t.setText(jo.getString(konfigurasi.TAG_ALAMAT_TOKO));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
