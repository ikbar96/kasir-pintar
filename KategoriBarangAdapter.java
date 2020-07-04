package com.example.kasirpintarku;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class KategoriBarangAdapter extends RecyclerView.Adapter<ViewHolderKategoriBarang> {

    private ArrayList<DataKategoriBarang> socmedData = new ArrayList<>();

    private Context context;

    private ViewHolderKategoriBarang ViewHolder;

    private LayoutInflater inflater;

    public KategoriBarangAdapter(Context context) {
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolderKategoriBarang onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.list_kategori, parent, false);
        ViewHolder = new ViewHolderKategoriBarang(v);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderKategoriBarang holder, int position) {
        DataKategoriBarang socmedData = this.socmedData.get(position);
        holder.txt_nama.setText(socmedData.getNama());
    }

    @Override
    public int getItemCount() {
        return this.socmedData.size();
    }

    public void setSocmedData(ArrayList<DataKategoriBarang> socmedData){
        this.socmedData = socmedData;
        notifyItemRangeChanged(0, socmedData.size());
    }
}

