package com.example.kasirpintarku;

public class DataBarangJasa {
    private int id;
    private String nama;
    private String keterangan;
    private String stok;
    private String harga;
    private String gambar;

    public DataBarangJasa(int id, String nama,String gambar,String keterangan,String stok,String harga) {
        this.id = id;
        this.nama = nama;
        this.gambar = gambar;
        this.keterangan = keterangan;
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

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String nama) {
        this.keterangan = keterangan;
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

