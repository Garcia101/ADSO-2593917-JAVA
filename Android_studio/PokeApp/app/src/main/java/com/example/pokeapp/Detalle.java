package com.example.pokeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Detalle extends AppCompatActivity {

    TextView etq_nombre;
    TextView etq_altura;
    TextView etq_peso;

    List<CaracteristicasPokemon> listado = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        etq_nombre = findViewById(R.id.etq_nombre);
        etq_altura = findViewById(R.id.etq_altura);
        etq_peso = findViewById(R.id.etq_peso);

        Intent intencion = getIntent();
        String nombre = intencion.getStringExtra("nombrePokemon");
        String url = intencion.getStringExtra("urlPokemon");

        etq_nombre.setText(nombre);

        cargarDetalles(url);
    }

    public void cargarDetalles(String url){

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        StringRequest solicitud =  new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("El servidor POST responde OK");
                    JSONObject jsonObject = new JSONObject(response);
                    System.out.print("ESTA ES LA RESPUESTA" +response);
                    String altura = jsonObject.getString("height");
                    etq_altura.setText(altura);
                    String peso = jsonObject.getString("weight");
                    JSONObject sprites = jsonObject.getJSONObject("sprites");
                    String back_default = sprites.getString("back_default");
                    String back_shiny = sprites.getString("back_shiny");
                    String front_default = sprites.getString("front_default");
                    String front_shiny = sprites.getString("front_shiny");
                    etq_peso.setText(peso);
                    String [] img = {back_default, back_shiny, front_default, front_shiny};

                    listado.add(new CaracteristicasPokemon(img));

                    mostrarIMG();

                } catch (JSONException e) {
                    System.out.println("El servidor POST responde con un error:");
                    System.out.println(e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor POST responde con un error:");
                System.out.println(error.getMessage());
            }
        });

        queue.add(solicitud);
    }

    public void mostrarIMG(){
        for (CaracteristicasPokemon pokemon : listado) {
            String[] imagenes = pokemon.getListaImg();
            for (String imagen : imagenes) {
                System.out.println("Imagen: " + imagen);
            }
        }
    }

}