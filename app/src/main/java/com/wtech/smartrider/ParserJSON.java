package com.wtech.smartrider;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weldis on 26/10/16.
 */
public class ParserJSON {

    public ArrayList<Condutor> getCondutores(String stringJSON){
        ArrayList<Condutor> list = new ArrayList<Condutor>();

        try{
            JSONArray jsonArray = new JSONArray(stringJSON);
            JSONObject jsonObject;

            for(int i = 0; i< jsonArray.length();i++){
                jsonObject = jsonArray.getJSONObject(i);

                Condutor condutor = new Condutor();

                condutor.setNome(jsonObject.getString("nome"));
                condutor.setHoraDaPartida(jsonObject.getString("horaDaPartida"));
                condutor.setPontoDePartida(jsonObject.getString("pontoDePartida"));
                condutor.setPontoDeChegada(jsonObject.getString("pontoDeChegada"));
                condutor.setRatingBar(Float.parseFloat(jsonObject.getString("ratingBar")));
                //condutor.setNumeroDeVagas(4); // alterar numero de vagas no banco de dados
                //condutor.setPontosVirtuais("Extrabom \n MVC \n RONDELI \n CASCATA"); // alterar no banco de dados

                list.add(condutor);

            }

            return list;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  null;
    }


}
