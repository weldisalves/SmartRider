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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewCondutoresActivity extends AppCompatActivity {

    /*
    olhar este link para fazer a comunicação com o banco de dados: http://androidexample.com/Restful_Webservice_Call_And_Get_And_Parse_JSON_Data-_Android_Example/index.php?view=article_discription&aid=101

    acertar o parser dos dados

     */


    private SwipeRefreshLayout swipe;
    private ListView listView;
    private MyAdapter adapter;
    private ArrayList<Condutor> listaDeCondutores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_condutores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaDeCondutores = new ArrayList<Condutor>();
        swipe = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshCondutores);
        listView = (ListView) findViewById(R.id.listViewCondutores);

        adapter = new MyAdapter(ListViewCondutoresActivity.this, R.layout.item_list_view_condutor, listaDeCondutores);
        listView.setAdapter(adapter);

        carregarCondutores();

        //adapter = new MyAdapter(ListViewCondutoresActivity.this, R.layout.item_list_view_condutor, listaDeCondutores);
//        listView.setAdapter(adapter);

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
                        listaDeCondutores.clear();
                        carregarCondutores2();
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
            condutor.setRatingBar(i * 5 / 10);
            condutor.setNumeroDeVagas(4);
            condutor.setPontosVirtuais("Extrabom \n MVC \n RONDELI \n CASCATA");

            listaDeCondutores.add(condutor);
        }
    }

    public void carregarCondutores2() {

        WebService webService = new WebService(adapter);
        webService.execute();

    }
}