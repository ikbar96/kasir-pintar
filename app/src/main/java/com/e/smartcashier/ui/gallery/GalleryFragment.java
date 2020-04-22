package com.e.smartcashier.ui.gallery;

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

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    final ArrayList<DataMenu> barangData = new ArrayList<>();
    MenuAdapter menuAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        final RecyclerView rcv_socmed = root.findViewById(R.id.rec_transaksi);

        menuAdapter = new MenuAdapter(getActivity().getApplicationContext());

        rcv_socmed.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        barangData.add(new com.e.smartcashier.ui.home.DataMenu(0, "Servis AC", BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_camera),"tidak terbatas * RP 200.000"));
        barangData.add(new com.e.smartcashier.ui.home.DataMenu(1, "OPPO A9", BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_camera),"20 * RP 3.999.999"));
        barangData.add(new DataMenu(2, "Mio Sporty", BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_camera),"5 * RP 5.000.000"));


        menuAdapter.setSocmedData(barangData);
        rcv_socmed.setAdapter(menuAdapter);

        return root;
    }
}