package com.example.kasirpintarku;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class BarangJasaAdapter extends RecyclerView.Adapter<ViewHolderBarangJasa> {

    private ArrayList<DataBarangJasa> socmedData = new ArrayList<>();

    private Context context;

    private ViewHolderBarangJasa ViewHolder;

    private LayoutInflater inflater;

    public BarangJasaAdapter(Context context) {
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolderBarangJasa onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.list_barangjasa, parent, false);
        ViewHolder = new ViewHolderBarangJasa(v);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderBarangJasa holder, int position) {
        DataBarangJasa socmedData = this.socmedData.get(position);
        holder.txt_nama.setText(socmedData.getNama());
        holder.ket.setText(socmedData.getKeterangan());
        holder.stok.setText(socmedData.getStok());
        holder.harga.setText(socmedData.getHarga());
        holder.img_gambar.setText(socmedData.getGambar());
    }

    @Override
    public int getItemCount() {
        return this.socmedData.size();
    }

    public void setSocmedData(ArrayList<DataBarangJasa> socmedData){
        this.socmedData = socmedData;
        notifyItemRangeChanged(0, socmedData.size());
    }
}

