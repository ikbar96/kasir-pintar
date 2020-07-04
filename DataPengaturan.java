package com.example.kasirpintarku;

import android.graphics.Bitmap;

public class DataPengaturan {
    private int id;
    private String nama;
    private String keterangan;
    private Bitmap gambar;

    public DataPengaturan(int id, String nama, Bitmap gambar, String stok) {
        this.id = id;
        this.nama = nama;
        this.gambar = gambar;
        this.keterangan = stok;
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
        return keterangan;
    }

    public void setStok(String stok) {
        this.keterangan = stok;
    }

}

