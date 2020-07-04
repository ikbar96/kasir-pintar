package com.example.kasirpintarku;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class LaporanAdapter extends RecyclerView.Adapter<ViewHolderLaporan> {

    private ArrayList<DataLaporan> socmedData = new ArrayList<>();

    private Context context;

    private ViewHolderLaporan ViewHolder;

    private LayoutInflater inflater;

    public LaporanAdapter(Context context) {
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolderLaporan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.list_laporan, parent, false);
        ViewHolder = new ViewHolderLaporan(v);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderLaporan holder, int position) {
        DataLaporan socmedData = this.socmedData.get(position);
        holder.txt_nama.setText(socmedData.getNama());
        holder.stok.setText(socmedData.getStok());
        holder.img_gambar.setImageBitmap(socmedData.getGambar());
    }

    @Override
    public int getItemCount() {
        return this.socmedData.size();
    }

    public void setSocmedData(ArrayList<DataLaporan> socmedData){
        this.socmedData = socmedData;
        notifyItemRangeChanged(0, socmedData.size());
    }
}

