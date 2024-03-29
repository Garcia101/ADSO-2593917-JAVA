package com.example.apppreguntas.utils;

import android.content.Context;
import android.content.res.Resources;

import com.example.apppreguntas.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class config {

    String apiHost;

    public config(Context contexto) {
        // Carga el archivo properties
        Resources res = contexto.getResources();
        InputStream inputStream = res.openRawResource(R.raw.config);

        // Lee las propiedades del archivo
        try {
            Properties properties = new Properties();
            properties.load(inputStream);

            apiHost = properties.getProperty("api_host");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEndpoint(String endpoint){
        return apiHost+endpoint;
    }
}
