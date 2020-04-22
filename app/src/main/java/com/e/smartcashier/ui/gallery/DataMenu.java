package com.e.smartcashier.ui.gallery;

import android.graphics.Bitmap;

public class DataMenu {
    private int id;
    private String nama;
    private String keterangan;
    private Bitmap gambar;

    public DataMenu(int id, String nama,Bitmap gambar,String keterangan) {
        this.id = id;
        this.nama = nama;
        this.gambar = gambar;
        this.keterangan = keterangan;
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

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String nama) {
        this.keterangan = keterangan;
    }


}
