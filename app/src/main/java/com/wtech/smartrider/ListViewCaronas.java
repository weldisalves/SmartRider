package com.wtech.smartrider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewCaronas extends AppCompatActivity {

    SwipeRefreshLayout swipe;
    ArrayList<Carona> caronas;
    AdapterCarona adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_caronas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        caronas = new ArrayList<Carona>();
        swipe = (SwipeRefreshLayout)findViewById(R.id.content_list_view_caronas_swipe);
        listView = (ListView) findViewById(R.id.listViewCondutores);

        adapter = new AdapterCarona(this,R.layout.item_list_view_caronas,caronas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Carona carona = adapter.getItem(i);
                Intent intent = new Intent(ListViewCaronas.this,DescricaoCarona.class);
                intent.putExtra("carona",carona);
                startActivity(intent);

            }
        });

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        adapter.clear();
                        carregaCondutores();
                        swipe.setRefreshing(false);
                    }
                }, 1000);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    void carregaCondutores(){
        caronas.clear();

        for(int i = 0; i< 10;i++){
            Carona carona = new Carona();

            //preenchendo os valores especificos da classe carona
            carona.setIdCarona(i);
            carona.setNumeroDeVagas(4);
            carona.setHoraDaPartida("12-12-12");

            //preenchendo os valores especificos da classe
            Condutor condutor = new Condutor();
            //preenchendo os valores da classe pessoa
            condutor.setIdPessoa(i);
            condutor.setNome("Condutor");
            condutor.setSobrenome(" - "+i);
            condutor.setLogin(condutor.getNome()+condutor.getSobrenome());
            condutor.setSenha(condutor.getNome()+i);
            condutor.setIdade(i*10);
            condutor.setProfissao("Aluno");

            //preenchendo os valor da classe condutor
            condutor.setIdCondutor(i);
            condutor.setImgVeiculo("subaru"+i);
            condutor.setSomaDasNotas(i*10);
            condutor.setNumeroDeAvaliacoes(i*2+1);
            condutor.setRatingBar(condutor.getSomaDasNotas()/condutor.getNumeroDeAvaliacoes());


            carona.setCondutor(condutor);

            //preenchendo os valores especificos de localização do ponto de partida
            Localizacao pontoDePartida = new Localizacao();
            pontoDePartida.setIdLocalizacao(i);
            pontoDePartida.setLatitude(i*10);
            pontoDePartida.setLongitude(i*20);
            pontoDePartida.setNomeDoLocal("Caribe - "+i);
            carona.setPontoDePartida(pontoDePartida);

            //preenchendo os valores especificos de localização do ponto de chegada
            Localizacao pontoDeChegada = new Localizacao();
            pontoDeChegada.setIdLocalizacao(i+1);
            pontoDeChegada.setLatitude(i*11);
            pontoDeChegada.setLongitude(i*21);
            pontoDeChegada.setNomeDoLocal("Tailândia - "+i);
            carona.setPontoDeChegada(pontoDeChegada);

            //preenchedo os valores especificos da lista de passageiros
            ArrayList<Passageiro> passageiros = new ArrayList<Passageiro>();
            for(int j = 0;j<carona.getNumeroDeVagas();j++){
                Passageiro passageiro = new Passageiro();
                //preenchimento dos atributos especificos da classe passageiro
                passageiro.setIdPassageiro(j);
                passageiro.setCodigoDeVerificacao("08df7adsh");

                //preenchimento do ponto virtual do passageiro
                Localizacao pontoVirtual = new Localizacao();
                pontoVirtual.setIdLocalizacao(j*16);
                pontoVirtual.setLatitude(i*15);
                pontoVirtual.setLongitude(i*33);
                pontoVirtual.setNomeDoLocal("Valhala"+j);

                passageiro.setPontoVirtual(pontoVirtual);

                //preenchimento dos atributos de pessoa
                passageiro.setIdPessoa(i);
                passageiro.setNome("Passageiro");
                passageiro.setSobrenome(" - "+j);
                passageiro.setLogin(condutor.getNome()+condutor.getSobrenome());
                passageiro.setSenha(condutor.getNome()+i);
                passageiro.setIdade(i*10);
                passageiro.setProfissao("Lascado");

                passageiros.add(passageiro);

            }


            caronas.add(carona);
        }

        adapter = new AdapterCarona(this,R.layout.item_list_view_caronas,caronas);
        listView.setAdapter(adapter);

    }

    void carregaCondutores2(){

        caronas.clear();

        adapter = new AdapterCarona(this,R.layout.item_list_view_caronas,caronas);

        ListView listView = (ListView) findViewById(R.id.listViewCondutores);
        listView.setAdapter(adapter);

    }

}
