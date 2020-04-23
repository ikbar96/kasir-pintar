package com.e.smartcashier.ui.slideshow;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.e.smartcashier.R;


public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView img_gambar;
    TextView txt_nama;
    TextView ket;

    public ViewHolder(View itemView) {
        super(itemView);

        img_gambar = itemView.findViewById(R.id.img_gambar);
        txt_nama = itemView.findViewById(R.id.txt_nama);
        ket = itemView.findViewById(R.id.txt_keterangan);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
