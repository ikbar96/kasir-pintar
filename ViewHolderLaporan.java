package com.example.kasirpintarku;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderLaporan extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView img_gambar;
    TextView txt_nama;
    TextView stok;

    public ViewHolderLaporan(View itemView) {
        super(itemView);

        img_gambar = itemView.findViewById(R.id.gambar_laporan);
        txt_nama = itemView.findViewById(R.id.txt_nama_laporan);
        stok = itemView.findViewById(R.id.txt_stock_laporan);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
