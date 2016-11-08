package com.wtech.smartrider;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DescricaoCarona extends AppCompatActivity {

    ListView listViewPassageiros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_carona);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageViewVeiculoCondutor = (ImageView)findViewById(R.id.imgVeiculoCondutor);
        ImageView imageViewPerfil = (ImageView)findViewById(R.id.imgPerfil);
        TextView textViewNome = (TextView)findViewById(R.id.txtViewNome);
        TextView textViewProfissao = (TextView)findViewById(R.id.txtViewProfissao);
        RatingBar ratingBarCondutor = (RatingBar)findViewById(R.id.ratingBarCondutor);
        listViewPassageiros = (ListView)findViewById(R.id.listViewPassageiros);
        TextView textViewNumeroDeVagas = (TextView)findViewById(R.id.txtViewNumeroDeVagas);
        Button btnSolicitarCarona = (Button)findViewById(R.id.btSolicitarCarona);


        Intent intent = getIntent();
        Carona carona = (Carona)intent.getSerializableExtra("carona");

        //preenchendo os campos especificos do condutor
        Condutor condutor = carona.getCondutor();
        textViewNome.setText(condutor.getNome() +condutor.getSobrenome());
        textViewProfissao.setText(condutor.getProfissao());
        //ratingBarCondutor.setNumStars(10);
        //ratingBarCondutor.setRating(condutor.getRatingBar());
        carregarPassageiros();
        textViewNumeroDeVagas.setText(""+carona.getNumeroDeVagas());

        btnSolicitarCarona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DescricaoCarona.this, "Você está solicitando carona", Toast.LENGTH_SHORT).show();
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

    void carregarPassageiros(){

    }

}
