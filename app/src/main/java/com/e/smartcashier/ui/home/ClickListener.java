package com.e.smartcashier.ui.home;

import android.view.View;

interface ClickListener {
    void OnClick(View v, int position, String nama);

    void onLongClick(View v, int position);
}
