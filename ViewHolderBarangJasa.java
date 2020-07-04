package com.example.kasirpintarku;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewHolderBarangJasa extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView img_gambar;
    TextView txt_nama;
    TextView ket;
    TextView stok;
    TextView harga;

    public ViewHolderBarangJasa(View itemView) {
        super(itemView);

        img_gambar = itemView.findViewById(R.id.textView13);
        txt_nama = itemView.findViewById(R.id.txt_nama);
        ket = itemView.findViewById(R.id.txt_keterangan);
        stok = itemView.findViewById(R.id.stock);
        harga = itemView.findViewById(R.id.harga);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
