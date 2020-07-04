package com.example.kasirpintarku;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.HashMap;

public class EditProfil extends AppCompatActivity {
    private EditText k_nama;
    private EditText k_email;
    private EditText k_telepon;
    private EditText k_alamat;

    Button t_edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);
        k_nama = (EditText) findViewById(R.id.edit_nama_p);
        k_email = (EditText) findViewById(R.id.edit_email_p);
        k_telepon = (EditText) findViewById(R.id.edit_telepon_p);
        k_alamat = (EditText) findViewById(R.id.edit_alamat_p);
        t_edit = (Button) findViewById(R.id.edit_p);
        getJSON();
        t_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateProfil();
                Intent move = new Intent(getApplicationContext(), EditProfil.class);
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
                loading = ProgressDialog.show(EditProfil.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showProfil(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_PROFIl);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }

    private void updateProfil(){
        final String nama_ep =  k_nama.getText().toString();
        final String email_ep = k_email.getText().toString();
        final String telepon_ep = k_telepon.getText().toString();
        final String alamat_ep = k_alamat.getText().toString();

        class UpdateEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(EditProfil.this,"Updating...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();

            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(konfigurasi.TAG_NAMA,nama_ep);
                hashMap.put(konfigurasi.TAG_EMAIL,email_ep);
                hashMap.put(konfigurasi.TAG_TELEPON,telepon_ep);
                hashMap.put(konfigurasi.TAG_ALAMAT,alamat_ep);

                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(konfigurasi.URL_UPDATE_BARANG,hashMap);

                return s;
            }
        }

        UpdateEmployee ue = new UpdateEmployee();
        ue.execute();
    }

    private void showProfil(String Json){
        try {
            JSONObject jsonObject = new JSONObject(Json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);

            JSONObject jo = result.getJSONObject(0);
            String nama = jo.getString(konfigurasi.TAG_NAMA);
            String email = jo.getString(konfigurasi.TAG_EMAIL);
            String telepon = jo.getString(konfigurasi.TAG_TELEPON);
            String alamat = jo.getString(konfigurasi.TAG_ALAMAT);

            k_nama.setText(nama);
            k_email.setText(email);
            k_telepon.setText(telepon);
            k_alamat.setText(alamat);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
