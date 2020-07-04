package com.example.kasirpintarku;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PengaturanAdapter extends RecyclerView.Adapter<ViewHolderPengaturan> {

    private ArrayList<DataPengaturan> socmedData = new ArrayList<>();

    private Context context;

    private ViewHolderPengaturan ViewHolder;

    private LayoutInflater inflater;

    public PengaturanAdapter(Context context) {
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolderPengaturan onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.list_pengaturan, parent, false);
        ViewHolder = new ViewHolderPengaturan(v);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPengaturan holder, int position) {
        DataPengaturan socmedData = this.socmedData.get(position);
        holder.txt_nama.setText(socmedData.getNama());
        holder.keterangan.setText(socmedData.getStok());
        holder.img_gambar.setImageBitmap(socmedData.getGambar());
    }

    @Override
    public int getItemCount() {
        return this.socmedData.size();
    }

    public void setSocmedData(ArrayList<DataPengaturan> socmedData){
        this.socmedData = socmedData;
        notifyItemRangeChanged(0, socmedData.size());
    }
}

