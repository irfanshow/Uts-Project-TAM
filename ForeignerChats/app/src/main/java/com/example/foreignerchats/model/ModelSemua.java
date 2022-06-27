package com.example.foreignerchats.model;

public class ModelSemua {
    String namauser;
    String negarauser;
    String detailuser;
    String photouser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id,pesanterakhir;

    public String getPesanterakhir() {
        return pesanterakhir;
    }

    public void setPesanterakhir(String pesanterakhir) {
        this.pesanterakhir = pesanterakhir;
    }

    String benderanegara;

    public ModelSemua() {
    }

    public ModelSemua(String namauser, String negarauser, String detailuser, String photouser,String benderanegara,String id,String pesanterakhir) {
        this.namauser = namauser;
        this.negarauser = negarauser;
        this.detailuser = detailuser;
        this.photouser = photouser;
        this.benderanegara = benderanegara;
        this.id = id;
        this.pesanterakhir = pesanterakhir;
    }

    public String getNamauser() {
        return namauser;
    }

    public void setNamauser(String namauser) {
        this.namauser = namauser;
    }

    public String getNegarauser() {
        return negarauser;
    }

    public void setNegarauser(String negarauser) {
        this.negarauser = negarauser;
    }

    public String getDetailuser() {
        return detailuser;
    }

    public void setDetailuser(String detailuser) {
        this.detailuser = detailuser;
    }

    public String getPhotouser() {
        return photouser;
    }

    public void setPhotouser(String photouser) {
        this.photouser = photouser;
    }

    public String getBenderanegara() {
        return benderanegara;
    }

    public void setBenderanegara(String benderanegara) {
        this.benderanegara = benderanegara;
    }
}
