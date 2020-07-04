package com.example.kasirpintarku;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class Laporan extends AppCompatActivity {

    final ArrayList<DataLaporan> barangData = new ArrayList<>();



    LaporanAdapter menuAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);
        final RecyclerView rcv_socmed = findViewById(R.id.rcv_laporan);

        menuAdapter = new LaporanAdapter(getApplicationContext());

        rcv_socmed.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rcv_socmed.addOnItemTouchListener(new Laporan.RecyclerTouchListener(getApplicationContext(), rcv_socmed, new ClickListener() {
            @Override
            public void OnClick(View v, int position) {
                if(position==0) {

                }
                if(position==1) {

                }
            }

            @Override
            public void onLongClick(View v, int position) {

            }
        }));

        barangData.add(new DataLaporan(0, "Laporan Umum", BitmapFactory.decodeResource(getResources(), R.drawable.laporan),"Laporan transaksi secara global"));
        barangData.add(new DataLaporan(1, "Laporan Semua Transaksi",BitmapFactory.decodeResource(getResources(), R.drawable.laporan),"Laporan transaksi dengan periode tertentu"));


        menuAdapter.setSocmedData(barangData);
        rcv_socmed.setAdapter(menuAdapter);
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
                DataLaporan list_item = barangData.get(rv.getChildAdapterPosition(child));
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
