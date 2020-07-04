package com.example.kasirpintarku;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolderManajemenStok extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView txt_nama_manajemen;


    public ViewHolderManajemenStok(View itemView) {
        super(itemView);


        txt_nama_manajemen = itemView.findViewById(R.id.nama_barang_manajemen);


        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
