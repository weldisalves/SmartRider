package com.wtech.smartrider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import java.util.ArrayList;

public class AdapterCarona extends ArrayAdapter<Carona> {
    ArrayList<Carona> carona = new ArrayList<>();

    public AdapterCarona(Context context, int textViewResourceId, ArrayList<Carona> objects) {
        super(context, textViewResourceId, objects);
        carona = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = inflater.inflate(R.layout.item_list_view_caronas, null);
        Carona c = carona.get(position);

        ImageView imageViewPerfil = (ImageView)v.findViewById(R.id.imgPerfil);
        RatingBar ratingBar = (RatingBar)v.findViewById(R.id.ratingBarCondutor);

        TextView textViewNome = (TextView)v.findViewById(R.id.txtViewNome);
        TextView textViewHoraDaPartida = (TextView)v.findViewById(R.id.txtViewHoraDaPartida);
        TextView textViewPontoDePartida = (TextView)v.findViewById(R.id.txtViewPontoDePartida);
        TextView textViewPontoDeChegada = (TextView)v.findViewById(R.id.txtViewPontoDeChegada);

        //atualizando os valores

        Condutor condutor = c.getCondutor();
        textViewNome.setText(condutor.getNome()+condutor.getSobrenome());

        textViewHoraDaPartida.setText(c.getHoraDaPartida());

        Localizacao pontoDeChegada = c.getPontoDeChegada();
        textViewPontoDeChegada.setText(""+pontoDeChegada.getIdLocalizacao());

        Localizacao pontoDePartida = c.getPontoDePartida();
        textViewPontoDePartida.setText(""+pontoDePartida.getIdLocalizacao());

        ratingBar.setRating(condutor.getRatingBar());


        return v;

    }
}
