package com.example.kasirpintarku;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    final ArrayList<DataMenu> barangData = new ArrayList<>();



    MenuAdapter menuAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final RecyclerView rcv_socmed = findViewById(R.id.rcv_menu_manajemen);

        menuAdapter = new MenuAdapter(getApplicationContext());

        rcv_socmed.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rcv_socmed.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), rcv_socmed, new ClickListener() {
            @Override
            public void OnClick(View v, int position) {
                if(position==0) {
                    Intent move = new Intent(getApplicationContext(), BarangAtauJasa.class);
                    startActivity(move);
                }
                if(position==1) {
                    Intent move = new Intent(getApplicationContext(), kategoriBarang.class);
                    startActivity(move);
                }
                if(position==2) {
                    Intent move = new Intent(getApplicationContext(), ManajemenStok.class);
                    startActivity(move);
                }
            }

            @Override
            public void onLongClick(View v, int position) {

            }
        }));

        barangData.add(new DataMenu(0, "Barang atau Jasa", BitmapFactory.decodeResource(getResources(), R.drawable.manajemen),"menambahkan barang atau jasa untuk transaksi"));
        barangData.add(new DataMenu(1, "Kategori Barang", BitmapFactory.decodeResource(getResources(), R.drawable.manajemen),"pengelompokan barang sesuai klasifikasi"));
        barangData.add(new DataMenu(2, "Manajemen Stock", BitmapFactory.decodeResource(getResources(), R.drawable.manajemen),"menambah atau mengurangi stok barang"));


        menuAdapter.setSocmedData(barangData);
        rcv_socmed.setAdapter(menuAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.manajemen) {
            Intent move = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(move);
        } else if (id == R.id.transaksi) {
            Intent move = new Intent(getApplicationContext(), Transaksi.class);
            startActivity(move);

        } else if (id == R.id.laporan) {
            Intent move = new Intent(getApplicationContext(), Laporan.class);
            startActivity(move);

        } else if (id == R.id.pengaturan) {
            Intent move = new Intent(getApplicationContext(), Pengaturan.class);
            startActivity(move);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
                DataMenu list_item = barangData.get(rv.getChildAdapterPosition(child));
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
