package com.example.kasirpintarku;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderPengaturan extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView img_gambar;
    TextView txt_nama;
    TextView keterangan;

    public ViewHolderPengaturan(View itemView) {
        super(itemView);

        img_gambar = itemView.findViewById(R.id.gambar_pengaturan);
        txt_nama = itemView.findViewById(R.id.txt_nama_pengaturan);
        keterangan = itemView.findViewById(R.id.txt_stock_pengaturan);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
