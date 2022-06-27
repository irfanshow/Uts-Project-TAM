package com.example.foreignerchats.model;

public class ModelPesan {
    String pesan,pengirim,waktupesan;
    long timestamp;

    public ModelPesan() {
    }

    public ModelPesan(String pesan, String pengirim, long timestamp, String waktupesan) {
        this.pesan = pesan;
        this.pengirim = pengirim;
        this.timestamp = timestamp;
        this.waktupesan = waktupesan;
    }



    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getPengirim() {
        return pengirim;
    }

    public void setPengirim(String pengirim) {
        this.pengirim = pengirim;
    }

    public String getWaktupesan() {
        return waktupesan;
    }

    public void setWaktupesan(String waktupesan) {
        this.waktupesan = waktupesan;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
