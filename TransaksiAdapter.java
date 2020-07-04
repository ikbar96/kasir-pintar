package com.example.kasirpintarku;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class TransaksiAdapter extends RecyclerView.Adapter<ViewHolderTransaksi> {

    private ArrayList<DataTransaksi> socmedData = new ArrayList<>();

    private Context context;

    private ViewHolderTransaksi ViewHolder;

    private LayoutInflater inflater;

    public TransaksiAdapter(Context context) {
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolderTransaksi onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.list_transaksi, parent, false);
        ViewHolder = new ViewHolderTransaksi(v);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTransaksi holder, int position) {
        DataTransaksi socmedData = this.socmedData.get(position);
        holder.txt_nama.setText(socmedData.getNama());
        holder.stok.setText(socmedData.getStok());
        holder.harga.setText(socmedData.getHarga());
        holder.img_gambar.setText(socmedData.getGambar());
    }

    @Override
    public int getItemCount() {
        return this.socmedData.size();
    }

    public void setSocmedData(ArrayList<DataTransaksi> socmedData){
        this.socmedData = socmedData;
        notifyItemRangeChanged(0, socmedData.size());
    }
}

