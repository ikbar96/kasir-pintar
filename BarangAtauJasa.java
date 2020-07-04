package com.example.kasirpintarku;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BarangAtauJasa extends AppCompatActivity {

    final ArrayList<DataBarangJasa> menuData = new ArrayList<>();

    BarangJasaAdapter menuAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barang_atau_jasa);
        final  RecyclerView rcv_data = findViewById(R.id.rcv_barang);
        menuAdapter = new BarangJasaAdapter(getApplicationContext());
        rcv_data.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rcv_data.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rcv_data, new ClickListener() {
            @Override
            public void OnClick(View v, int position) {
                Intent move = new Intent(getApplicationContext(), DetailBarangatauJasa.class);
                move.putExtra("nomor",position);
                startActivity(move);
            }

            @Override
            public void onLongClick(View v, int position) {

            }
        }));
        getJSON();
        rcv_data.setAdapter(menuAdapter);
    }

    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(BarangAtauJasa.this,"Mengambil Data","Mohon Tunggu...",false,false);
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
                String harga="Rp."+jo.getString(konfigurasi.TAG_HARGA_DASAR)+" * Rp."+jo.getString(konfigurasi.TAG_HARGA_JUAL);
                menuData.add(new DataBarangJasa(Integer.parseInt(jo.getString(konfigurasi.TAG_NO_BARANG)),jo.getString(konfigurasi.TAG_NAMA_BARANG),"JA",jo.getString(konfigurasi.TAG_KODE),jo.getString(konfigurasi.TAG_STOK),harga));

            }
            menuAdapter.setSocmedData(menuData);

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
                DataBarangJasa list_item = menuData.get(rv.getChildAdapterPosition(child));
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
