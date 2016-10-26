package com.wtech.smartrider;

import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;
import android.widget.ArrayAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by weldis on 26/10/16.
 */

public class WebService extends AsyncTask<Void,Void,List<Condutor>> {

    HttpURLConnection httpURLConnection;
    BufferedReader bufferedReader;
    String resultado;
    MyAdapter adapter;

    public WebService(MyAdapter adapter) {
        this.adapter = adapter;
    }


    @Override
    protected List<Condutor> doInBackground(Void... strings) {

        try{
            //ponte de ligação com a URL
            String serverURL = "http://wtechsistemas.esy.es/smartrider/listaDeCondutores.php";
            URL url = new URL(serverURL);

            httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuffer stringBuffer = new StringBuffer();

            if(inputStream == null) return null;

            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;

            while ((line = bufferedReader.readLine()) != null){
                stringBuffer.append(line + "\n");
            }

            resultado = stringBuffer.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ParserJSON parserJSON = new ParserJSON();

        return parserJSON.getCondutores(resultado);

    }

    @Override
    public void onPostExecute(List<Condutor> list){
        super.onPostExecute(list);

        if(resultado != null){
            adapter.clear();
            for (Condutor condutor : list){
                adapter.add(condutor);
            }

        }


    }
}
