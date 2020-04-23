package com.e.smartcashier.ui.slideshow;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.smartcashier.R;
import com.e.smartcashier.ui.home.DataMenu;
import com.e.smartcashier.ui.home.MenuAdapter;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    final ArrayList<DataMenu> barangData = new ArrayList<>();
    MenuAdapter menuAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);


        final RecyclerView rcv_socmed = root.findViewById(R.id.rec_laporan);

        menuAdapter = new MenuAdapter(getActivity().getApplicationContext());

        rcv_socmed.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        barangData.add(new com.e.smartcashier.ui.home.DataMenu(0, "Laporan Umum", BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_camera),"laporan transaksi secara global"));
        barangData.add(new com.e.smartcashier.ui.home.DataMenu(1, "Laporan Semua Transaksi", BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_camera),"laporan transaksi dengan periode tertentu"));

        menuAdapter.setSocmedData(barangData);
        rcv_socmed.setAdapter(menuAdapter);

        return root;
    }
}