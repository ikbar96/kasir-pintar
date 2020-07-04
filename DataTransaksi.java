package com.example.kasirpintarku;

public class DataTransaksi {
    private int id;
    private String nama;
    private String stok;
    private String harga;
    private String gambar;

    public DataTransaksi(int id, String nama, String gambar, String stok, String harga) {
        this.id = id;
        this.nama = nama;
        this.gambar = gambar;
        this.stok = stok;
        this.harga = harga;
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

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getStok() {
        return stok;
    }

    public void setStok(String stok) {
        this.stok = stok;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

}

