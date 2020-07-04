package com.example.kasirpintarku;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ManajemenStokAdapter extends RecyclerView.Adapter<ViewHolderManajemenStok> {

    private ArrayList<DataManajemenStok> socmedData = new ArrayList<>();

    private Context context;

    private ViewHolderManajemenStok ViewHolder;

    private LayoutInflater inflater;

    public ManajemenStokAdapter(Context context) {
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolderManajemenStok onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.list_barang_manajemen, parent, false);
        ViewHolder = new ViewHolderManajemenStok(v);
        return ViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderManajemenStok holder, int position) {
        DataManajemenStok socmedData = this.socmedData.get(position);
        holder.txt_nama_manajemen.setText(socmedData.getNama());
    }

    @Override
    public int getItemCount() {
        return this.socmedData.size();
    }

    public void setSocmedData(ArrayList<DataManajemenStok> socmedData){
        this.socmedData = socmedData;
        notifyItemRangeChanged(0, socmedData.size());
    }
}

