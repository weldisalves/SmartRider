package com.wtech.smartrider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by weldis on 24/10/16.
 */

public class MyAdapter extends ArrayAdapter<Condutor>{

    private final ArrayList<Condutor> condutors;

    public MyAdapter(Context context, int resource, ArrayList<Condutor> objects){
        super(context,resource,objects);
        condutors = objects;
    }

    @Override
    public int getCount(){return super.getCount();}

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View v = convertView;

        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = inflater.inflate(R.layout.item_list_view_condutor,null);

        RatingBar ratingBar = (RatingBar)v.findViewById(R.id.ratingBar);
        TextView textViewNome = (TextView)v.findViewById(R.id.txtViewNome);
        TextView textViewHoraDapartida = (TextView)v.findViewById(R.id.txtViewHoraDaPartida);
        TextView textViewPontoDePartida = (TextView)v.findViewById(R.id.txtViewPontoDePartida);
        TextView textViewPontoDeChegada = (TextView)v.findViewById(R.id.txtViewPontoDeChegada);

        textViewNome.setText(condutors.get(position).getNome());
        textViewHoraDapartida.setText(condutors.get(position).getHoraDaPartida());
        textViewPontoDePartida.setText(condutors.get(position).getPontoDePartida());
        textViewPontoDeChegada.setText(condutors.get(position).getPontoDeChegada());

        ratingBar.setRating(condutors.get(position).getRatingBar());

        return v;
    }

}





//public class MyAdapter extends ArrayAdapter<Condutor> {
//
//    ArrayList<Condutor> condutores = new ArrayList<>();
//
//    public MyAdapter(Context context, int resource, ArrayList<Condutor> objects) {
//        super(context, resource, objects);
//        condutores =  objects;
//    }
//
//    @Override
//    public int getCount(){ return super.getCount(); }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent){
//
//        View v = convertView;
//        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        v = layoutInflater.inflate(R.layout.item_list_view_condutor,null);
//
//        ImageView imageView = (ImageView)v.findViewById(R.id.imgPerfil);
//        RatingBar ratingBar = (RatingBar)v.findViewById(R.id.ratingBar);
//        TextView textViewId = (TextView)v.findViewById(R.id.txtViewId);
//        TextView textViewNome = (TextView)v.findViewById(R.id.txtViewNome);
//        TextView textViewHoraDapartida = (TextView)v.findViewById(R.id.txtViewHoraDaPartida);
//        TextView textViewPontoDePartida = (TextView)v.findViewById(R.id.txtViewPontoDePartida);
//        TextView textViewPontoDeChegada = (TextView)v.findViewById(R.id.txtViewPontoDeChegada);
//
//        textViewId.setText(condutores.get(position).getId());
//        textViewNome.setText(condutores.get(position).getNome());
//
//        return v;
//    }
//
//}
