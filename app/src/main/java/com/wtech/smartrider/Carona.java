package com.wtech.smartrider;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by weldis on 03/11/16.
 */
public class Carona implements Serializable {

    private int idCarona;
    private Condutor condutor;
    private int numeroDeVagas;
    private Localizacao pontoDePartida;
    private Localizacao pontoDeChegada;
    private String horaDaPartida;
    private ArrayList<Passageiro> passageiros;

    public Carona() {
    }

    public int getIdCarona() {
        return idCarona;
    }

    public void setIdCarona(int idCarona) {
        this.idCarona = idCarona;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public int getNumeroDeVagas() {
        return numeroDeVagas;
    }

    public void setNumeroDeVagas(int numeroDeVagas) {
        this.numeroDeVagas = numeroDeVagas;
    }

    public Localizacao getPontoDePartida() {
        return pontoDePartida;
    }

    public void setPontoDePartida(Localizacao pontoDePartida) {
        this.pontoDePartida = pontoDePartida;
    }

    public Localizacao getPontoDeChegada() {
        return pontoDeChegada;
    }

    public void setPontoDeChegada(Localizacao pontoDeChegada) {
        this.pontoDeChegada = pontoDeChegada;
    }

    public String getHoraDaPartida() {
        return horaDaPartida;
    }

    public void setHoraDaPartida(String horaDaPartida) {
        this.horaDaPartida = horaDaPartida;
    }

    public ArrayList<Passageiro> getPassageiros() {
        return passageiros;
    }

    public void setPassageiros(ArrayList<Passageiro> passageiros) {
        this.passageiros = passageiros;
    }

}
