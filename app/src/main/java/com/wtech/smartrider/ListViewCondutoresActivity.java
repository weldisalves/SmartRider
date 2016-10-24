package com.wtech.smartrider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewCondutoresActivity extends AppCompatActivity {

    private SwipeRefreshLayout swipe;
    private ListView listView;
    private ArrayAdapter<Condutor> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_condutores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        swipe = (SwipeRefreshLayout)findViewById(R.id.swipeRefreshCondutores);

        carregarCondutores();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Condutor condutor = adapter.getItem(i);
                Intent intent = new Intent(ListViewCondutoresActivity.this, DescricaoCondutorActivity.class);
                intent.putExtra("condutor",condutor);
                startActivity(intent);
            }
        });

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){

            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipe.setRefreshing(false);
                    }
                }, 1000);
            }
        });

    }

    private void carregarCondutores(){

        List<Condutor> listaDeCondutores = new ArrayList<Condutor>();
        int i;
        for( i=0;i<30;i++){
            Condutor condutor = new Condutor(i,"Aluno "+ i ,"12:00");
            listaDeCondutores.add(condutor);
        }

        adapter = new MyAdapter(this,R.layout.item_list_view_condutor,listaDeCondutores);

        listView = (ListView) findViewById(R.id.listViewCondutores);
        listView.setAdapter(adapter);


    }

}
