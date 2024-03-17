package com.example.pokeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Detalle extends AppCompatActivity {

    private static final String TAG = "DetalleActivity"; // Etiqueta para los mensajes de depuración

    private RecyclerView recyclerViewImagenes;
    private RecyclerView recyclerViewHabilidades;
    private AdaptadorImg adaptadorImg;
    private AdaptadorHabilidades adaptadorHabilidad;

    TextView etq_nombre;
    TextView etq_altura;
    TextView etq_peso;

    // Variables para las URLs de las imágenes
    String back_default;
    String front_default;
    String front_shiny;

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

        listado = new ArrayList<>();

        recyclerViewImagenes = findViewById(R.id.recycler_imagenes);
        recyclerViewImagenes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adaptadorImg = new AdaptadorImg(listado);
        recyclerViewImagenes.setAdapter(adaptadorImg);

        recyclerViewHabilidades = findViewById(R.id.recycler_habilidades);
        recyclerViewHabilidades.setLayoutManager(new LinearLayoutManager(this));
        adaptadorHabilidad = new AdaptadorHabilidades(listado);
        recyclerViewHabilidades.setAdapter(adaptadorHabilidad);

        cargarDetalles(url);
    }

    public void cargarDetalles(String url){

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        StringRequest solicitud =  new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.d(TAG, "El servidor POST responde OK");
                    JSONObject jsonObject = new JSONObject(response);
                    Log.d(TAG, "ESTA ES LA RESPUESTA: " + response);

                    String altura = jsonObject.getString("height");
                    etq_altura.setText(altura);

                    String peso = jsonObject.getString("weight");

                    JSONObject sprites = jsonObject.getJSONObject("sprites");

                    // Obtener las URLs de las imágenes específicas
                    back_default = sprites.optString("back_default", null);
                    front_default = sprites.optString("front_default", null);
                    front_shiny = sprites.optString("front_shiny", null);

                    List<CaracteristicasPokemon> pokemonImages = new ArrayList<>();

                    if (front_default != null) {
                        CaracteristicasPokemon frontDefaultPokemon = new CaracteristicasPokemon(new String[]{front_default});
                        pokemonImages.add(frontDefaultPokemon);
                    }
                    if (back_default != null) {
                        CaracteristicasPokemon backDefaultPokemon = new CaracteristicasPokemon(new String[]{back_default});
                        pokemonImages.add(backDefaultPokemon);
                    }
                    if (front_shiny != null) {
                        CaracteristicasPokemon frontShinyPokemon = new CaracteristicasPokemon(new String[]{front_shiny});
                        pokemonImages.add(frontShinyPokemon);
                    }

                    adaptadorImg = new AdaptadorImg(pokemonImages);
                    recyclerViewImagenes.setAdapter(adaptadorImg);
                    recyclerViewImagenes.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

                    JSONArray abilities = jsonObject.getJSONArray("abilities");
                    List<String> habilidades = new ArrayList<>();
                    for (int i = 0; i < abilities.length(); i++) {
                        JSONObject ability = abilities.getJSONObject(i);
                        JSONObject actual = ability.getJSONObject("ability");
                        String name = actual.getString("name");
                        Log.d(TAG, "Nombre de la habilidad " + i + ": " + name);
                        habilidades.add(name);
                    }
                    CaracteristicasPokemon pokemon = new CaracteristicasPokemon(habilidades);
                    listado.add(pokemon);



                    etq_peso.setText(peso);

                } catch (JSONException e) {
                    Log.e(TAG, "El servidor POST responde con un error:", e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "El servidor POST responde con un error:", error);
            }
        });

        queue.add(solicitud);
    }
}
