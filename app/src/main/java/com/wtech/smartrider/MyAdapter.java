package com.wtech.smartrider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weldis on 24/10/16.
 */

public class MyAdapter extends ArrayAdapter<Condutor>{

    private final LayoutInflater inflater;
    private final int recursoId;

    public MyAdapter(Context context, int resource, List<Condutor> objects){
        super(context,resource,objects);
        this.inflater = LayoutInflater.from(context);
        this.recursoId = resource;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent){
        Condutor condutor = getItem(position);
        v = inflater.inflate(recursoId,parent,false);

        ImageView imageView = (ImageView)v.findViewById(R.id.imgPerfil);
        RatingBar ratingBar = (RatingBar)v.findViewById(R.id.ratingBar);
        TextView textViewId = (TextView)v.findViewById(R.id.txtViewId);
        TextView textViewNome = (TextView)v.findViewById(R.id.txtViewNome);
        TextView textViewHoraDapartida = (TextView)v.findViewById(R.id.txtViewHoraDaPartida);
        TextView textViewPontoDePartida = (TextView)v.findViewById(R.id.txtViewPontoDePartida);
        TextView textViewPontoDeChegada = (TextView)v.findViewById(R.id.txtViewPontoDeChegada);

        //textViewId.setText(condutor.getId());
        textViewNome.setText(condutor.getNome());
        textViewHoraDapartida.setText(condutor.getHoraDaPartida());

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
