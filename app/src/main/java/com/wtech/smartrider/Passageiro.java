package com.wtech.smartrider;

import java.io.Serializable;

/**
 * Created by weldis on 03/11/16.
 */
public class Passageiro extends Pessoa implements Serializable{

    private int idPassageiro;
    private Localizacao pontoVirtual;
    private String codigoDeVerificacao;

    public Passageiro() {
        super();
    }

    public int getIdPassageiro() {
        return idPassageiro;
    }

    public void setIdPassageiro(int idPassageiro) {
        this.idPassageiro = idPassageiro;
    }

    public Localizacao getPontoVirtual() {
        return pontoVirtual;
    }

    public void setPontoVirtual(Localizacao pontoVirtual) {
        this.pontoVirtual = pontoVirtual;
    }

    public String getCodigoDeVerificacao() {
        return codigoDeVerificacao;
    }

    public void setCodigoDeVerificacao(String codigoDeVerificacao) {
        this.codigoDeVerificacao = codigoDeVerificacao;
    }
}
