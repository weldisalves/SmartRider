package com.wtech.smartrider;

import android.widget.RatingBar;

import java.io.Serializable;

/**
 * Created by weldis on 24/10/16.
 */

public class Condutor implements Serializable {

    private String imgVeiculo;
    private String imgPerfil;
    private int id;
    private String nome;
    private float ratingBar;
    private String horaDaPartida;
    private String pontoDePartida;
    private String pontoDeChegada;

    private String pontosVirtuais;
    private int numeroDeVagas;

    public Condutor() {
    }


    public String getPontosVirtuais() {
        return pontosVirtuais;
    }

    public void setPontosVirtuais(String pontosVirtuais) {
        this.pontosVirtuais = pontosVirtuais;
    }

    public int getNumeroDeVagas() {
        return numeroDeVagas;
    }

    public void setNumeroDeVagas(int numeroDeVagas) {
        this.numeroDeVagas = numeroDeVagas;
    }



    public String getImgVeiculo() {
        return imgVeiculo;
    }

    public void setImgVeiculo(String imgVeiculo) {
        this.imgVeiculo = imgVeiculo;
    }

    public String getImgPerfil() {
        return imgPerfil;
    }

    public void setImgPerfil(String imgPerfil) {
        this.imgPerfil = imgPerfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(float ratingBar) {
        this.ratingBar = ratingBar;
    }

    public String getHoraDaPartida() {
        return horaDaPartida;
    }

    public void setHoraDaPartida(String horaDaPartida) {
        this.horaDaPartida = horaDaPartida;
    }

    public String getPontoDePartida() {
        return pontoDePartida;
    }

    public void setPontoDePartida(String pontoDePartida) {
        this.pontoDePartida = pontoDePartida;
    }

    public String getPontoDeChegada() {
        return pontoDeChegada;
    }

    public void setPontoDeChegada(String pontoDeChegada) {
        this.pontoDeChegada = pontoDeChegada;
    }
}
