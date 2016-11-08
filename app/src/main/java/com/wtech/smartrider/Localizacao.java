package com.wtech.smartrider;

import java.io.Serializable;

/**
 * Created by weldis on 03/11/16.
 */
public class Localizacao implements Serializable {

    private int idLocalizacao;
    private float latitude;
    private float longitude;
    private String nomeDoLocal;

    public Localizacao() {
    }

    public int getIdLocalizacao() {
        return idLocalizacao;
    }

    public void setIdLocalizacao(int idLocalizacao) {
        this.idLocalizacao = idLocalizacao;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public String getNomeDoLocal() {
        return nomeDoLocal;
    }

    public void setNomeDoLocal(String nomeDoLocal) {
        this.nomeDoLocal = nomeDoLocal;
    }
}
