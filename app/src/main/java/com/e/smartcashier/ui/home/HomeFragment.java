package com.e.smartcashier.ui.home;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.smartcashier.MainActivity;
import com.e.smartcashier.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    final ArrayList<DataMenu> barangData = new ArrayList<>();



    MenuAdapter menuAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final RecyclerView rcv_socmed = root.findViewById(R.id.rcv_barang);

        menuAdapter = new MenuAdapter(getActivity().getApplicationContext());

        rcv_socmed.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rcv_socmed.addOnItemTouchListener(new RecyclerTouchListener(getContext().getApplicationContext(), rcv_socmed, new ClickListener() {
            @Override
            public void OnClick(View v, int position,String nama) {
                position=position+1;
                Toast.makeText(getActivity().getApplicationContext(), "Anda telah menekan fitur ke : "+position+" "+nama, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(View v, int position) {

            }
        }));

        barangData.add(new DataMenu(0, "Barang atau Jasa", BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_camera),"menambahkan barang atau jasa untuk transaksi"));
        barangData.add(new DataMenu(1, "Kategori Barang", BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_camera),"pengelompokan barang sesuai klasifikasi"));
        barangData.add(new DataMenu(2, "Manajemen Stock", BitmapFactory.decodeResource(getResources(), R.drawable.ic_menu_camera),"menambah atau mengurangi stok barang"));


        menuAdapter.setSocmedData(barangData);
        rcv_socmed.setAdapter(menuAdapter);
        return root;
    }

    private class RecyclerTouchListener implements RecyclerView.OnItemTouchListener{

        private ClickListener clickListener;
        private GestureDetector gestureDetector;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());

                    if (child != null && clickListener != null){
                        clickListener.onLongClick(child, recyclerView.getChildAdapterPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null&&gestureDetector.onTouchEvent(e)){
                DataMenu list_item = barangData.get(rv.getChildAdapterPosition(child));
                clickListener.OnClick(child, list_item.getId(),list_item.getNama());
            }

            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    }



}