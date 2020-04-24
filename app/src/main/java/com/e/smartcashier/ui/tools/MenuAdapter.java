package com.e.smartcashier.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.smartcashier.R;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<DataMenu> socmedData = new ArrayList<>();

    private Context context;

    private ViewHolder viewHolder;

    private LayoutInflater inflater;

    public MenuAdapter(Context context) {
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.list_menu, parent, false);
        viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataMenu socmedData = this.socmedData.get(position);
        holder.img_gambar.setImageBitmap(socmedData.getGambar());
        holder.txt_nama.setText(socmedData.getNama());
        holder.ket.setText(socmedData.getKeterangan());
    }

    @Override
    public int getItemCount() {
        return this.socmedData.size();
    }

    public void setSocmedData(ArrayList<DataMenu> socmedData){
        this.socmedData = socmedData;

        notifyItemRangeChanged(0, socmedData.size());
    }
}

