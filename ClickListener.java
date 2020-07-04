package com.example.kasirpintarku;

import android.view.View;

interface ClickListener {
    void OnClick(View v, int position);

    void onLongClick(View v, int position);
}
