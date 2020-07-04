package com.example.kasirpintarku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class BayarTransaksi extends AppCompatActivity {

    TextView item;
    TextView total;
    String lis_item="";
    ArrayList<String> item_beli = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar_transaksi);
        item = (TextView) findViewById(R.id.item_dibeli);
        total = (TextView) findViewById(R.id.total_dibeli);

        item_beli = getIntent().getExtras().getStringArrayList("lis");
        for(int x=0;x<item_beli.size();x++){
            lis_item+=(item_beli.get(x)+"\n");
        }

        item.setText(lis_item);
        total.setText(String.valueOf(getIntent().getExtras().getInt("total")));
    }
}
