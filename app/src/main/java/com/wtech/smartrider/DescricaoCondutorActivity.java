package com.wtech.smartrider;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class DescricaoCondutorActivity extends AppCompatActivity {

    Condutor condutor;
    private TextView textViewNome;
    private TextView textViewHoraDaPartida;
    private RatingBar ratingBar;
    private TextView textViewPontoDePartida;
    private TextView textViewPontoDeChegada;
    private TextView textViewPontosVirtuais;
    private TextView textViewNumeroDeVagas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_condutor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        condutor = (Condutor)intent.getSerializableExtra("condutor");

        textViewNome = (TextView)findViewById(R.id.txtViewNome);
        textViewHoraDaPartida = (TextView)findViewById(R.id.txtViewHoraDaPartida);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        textViewPontoDePartida = (TextView)findViewById(R.id.txtViewPontoDePartida);
        textViewPontoDeChegada = (TextView)findViewById(R.id.txtViewPontoDeChegada);
//        textViewPontosVirtuais = (TextView)findViewById(R.id.txtViewPontosVirtuais);
//        textViewNumeroDeVagas = (TextView)findViewById(R.id.txtViewNumeroDeVagas);

        textViewNome.setText(condutor.getNome());
        textViewHoraDaPartida.setText(condutor.getHoraDaPartida());
        ratingBar.setNumStars(5);
        ratingBar.setRating(condutor.getRatingBar());
        textViewPontoDePartida.setText(condutor.getPontoDePartida());
        textViewPontoDeChegada.setText(condutor.getPontoDeChegada());
//        textViewPontosVirtuais.setText(condutor.getPontosVirtuais());
//        textViewNumeroDeVagas.setText("4");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
