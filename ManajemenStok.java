package com.example.kasirpintarku;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ManajemenStok extends AppCompatActivity {

    ArrayList<DataManajemenStok> barangData = new ArrayList<DataManajemenStok>();
    private TextView nama_barang;
    ManajemenStokAdapter menuAdapter;
    FloatingActionButton tambah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manajemen_stok);
        nama_barang = (TextView) findViewById(R.id.nama_barang_manajemen);
        tambah = (FloatingActionButton)findViewById(R.id.add_barang);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent move = new Intent(getApplicationContext(), addBarang.class);
                startActivity(move);
            }
        });
        final RecyclerView rcv_socmed = findViewById(R.id.rcv_manajemen_stok);

        menuAdapter = new ManajemenStokAdapter(getApplicationContext());
        rcv_socmed.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rcv_socmed.addOnItemTouchListener(new ManajemenStok.RecyclerTouchListener(getApplicationContext(), rcv_socmed, new ClickListener() {
            @Override
            public void OnClick(View v, int position) {
                Toast.makeText(getApplicationContext(), "haha", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View v, int position) {

            }
        }));
        getJSON();
        rcv_socmed.setAdapter(menuAdapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ManajemenStok.this,"Mengambil Data","Mohon Tunggu...",false,false);
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
                String s = rh.sendGetRequest(konfigurasi.URL_GET_BARANG);
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
                barangData.add(new DataManajemenStok(Integer.parseInt(jo.getString(konfigurasi.TAG_NO_BARANG)),jo.getString(konfigurasi.TAG_NAMA_BARANG)));
            }
            menuAdapter.setSocmedData(barangData);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private ClickListener clickListener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());

                    if (child != null && clickListener != null){
                        clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null&&gestureDetector.onTouchEvent(e)){
                DataManajemenStok list_item = barangData.get(rv.getChildAdapterPosition(child));
                clickListener.OnClick(child, list_item.getId());
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }
}
