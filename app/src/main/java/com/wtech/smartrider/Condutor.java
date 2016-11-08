package com.wtech.smartrider;

import android.widget.RatingBar;

import java.io.Serializable;

/**
 * Created by weldis on 03/11/16.
 */
public class Condutor extends Pessoa implements Serializable{

    private int idCondutor;
    private String imgVeiculo;
    private float somaDasNotas;
    private float numeroDeAvaliacoes;
    private float ratingBar;

    public Condutor() {
        super();
    }

    public int getIdCondutor() {
        return idCondutor;
    }

    public void setIdCondutor(int idCondutor) {
        this.idCondutor = idCondutor;
    }

    public String getImgVeiculo() {
        return imgVeiculo;
    }

    public void setImgVeiculo(String imgVeiculo) {
        this.imgVeiculo = imgVeiculo;
    }

    public float getSomaDasNotas() {
        return somaDasNotas;
    }

    public void setSomaDasNotas(float somaDasNotas) {
        this.somaDasNotas = somaDasNotas;
    }

    public float getNumeroDeAvaliacoes() {
        return numeroDeAvaliacoes;
    }

    public void setNumeroDeAvaliacoes(float numeroDeAvaliacoes) {
        this.numeroDeAvaliacoes = numeroDeAvaliacoes;
    }

    public float getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(float ratingBar) {
        this.ratingBar = ratingBar;
    }
}
