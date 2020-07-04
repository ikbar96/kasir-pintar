package com.example.kasirpintarku;

import android.graphics.Bitmap;

public class DataLaporan {
    private int id;
    private String nama;
    private String stok;
    private Bitmap gambar;

    public DataLaporan(int id, String nama, Bitmap gambar, String stok) {
        this.id = id;
        this.nama = nama;
        this.gambar = gambar;
        this.stok = stok;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Bitmap getGambar() {
        return gambar;
    }

    public void setGambar(Bitmap gambar) {
        this.gambar = gambar;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

}

