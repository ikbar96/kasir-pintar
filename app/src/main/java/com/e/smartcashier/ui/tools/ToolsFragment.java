package com.e.smartcashier.ui.tools;

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

public class ToolsFragment extends Fragment {

    private ToolsViewModel toolsViewModel;
    final ArrayList<DataMenu> barangData = new ArrayList<>();
    MenuAdapter menuAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        toolsViewModel =
                ViewModelProviders.of(this).get(ToolsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_tools, container, false);
        final RecyclerView rcv_socmed = root.findViewById(R.id.rec_pengaturan);

        menuAdapter = new MenuAdapter(getActivity().getApplicationContext());

        rcv_socmed.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        barangData.add(new com.e.smartcashier.ui.home.DataMenu(0, "Profile", BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_camera),"profile akun anda di kasirpintar"));
        barangData.add(new com.e.smartcashier.ui.home.DataMenu(1, "Toko", BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_camera),"profile toko atau store anda"));

        menuAdapter.setSocmedData(barangData);
        rcv_socmed.setAdapter(menuAdapter);
        return root;
    }
}