package com.wtech.smartrider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewCondutoresActivity extends AppCompatActivity {

    private ArrayList listaDeCondutores;
    private MyAdapter adapter;
    private SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_condutores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaDeCondutores = new ArrayList();
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshCondutores);

        adapter = new MyAdapter(this, R.layout.content_list_view_condutores, listaDeCondutores);

        carregarCondutores();

        ListView listView = (ListView)findViewById(R.id.listViewCondutores);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Condutor condutor = adapter.getItem(i);
                Intent intent = new Intent(ListViewCondutoresActivity.this, DescricaoCondutorActivity.class);
                intent.putExtra("condutor", condutor);
                startActivity(intent);

            }
        });

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {

            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        carregarCondutores2();
                        swipe.setRefreshing(false);
                    }
                }, 1500);
            }
        });

    }

    private void carregarCondutores() {
        int i;

        for (i = 1; i < 11; i++) {
            Condutor condutor = new Condutor();
            condutor.setId(i);
            condutor.setNome("Aluno " + i);
            condutor.setHoraDaPartida(i + ":" + i + 1);
            condutor.setPontoDePartida("UFES " + i);
            condutor.setPontoDeChegada("GURIRI " + i);
            condutor.setRatingBar(i);
            condutor.setNumeroDeVagas(4);
            condutor.setPontosVirtuais("Extrabom \n MVC \n RONDELI \n CASCATA");

            listaDeCondutores.add(condutor);
        }

        adapter = new MyAdapter(this, R.layout.content_list_view_condutores, listaDeCondutores);

        ListView listView = (ListView)findViewById(R.id.listViewCondutores);
        listView.setAdapter(adapter);
    }

    public void carregarCondutores2() {

        WebService webService = new WebService(adapter);
        webService.execute();
    }
}
