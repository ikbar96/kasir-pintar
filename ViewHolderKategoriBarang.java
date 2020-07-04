package com.example.kasirpintarku;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolderKategoriBarang extends RecyclerView.ViewHolder implements View.OnClickListener {


    TextView txt_nama;


    public ViewHolderKategoriBarang(View itemView) {
        super(itemView);
        txt_nama = itemView.findViewById(R.id.nama_kategori);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
