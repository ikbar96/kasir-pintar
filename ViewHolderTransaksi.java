package com.example.kasirpintarku;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolderTransaksi extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView img_gambar;
    TextView txt_nama;
    TextView stok;
    TextView harga;

    public ViewHolderTransaksi(View itemView) {
        super(itemView);

        img_gambar = itemView.findViewById(R.id.title);
        txt_nama = itemView.findViewById(R.id.txt_nama);
        stok = itemView.findViewById(R.id.txt_stock);
        harga = itemView.findViewById(R.id.txt_harga);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
