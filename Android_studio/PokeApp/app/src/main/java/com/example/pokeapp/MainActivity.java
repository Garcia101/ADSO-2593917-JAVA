package com.example.pokeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdaptadorPoke adaptadorPoke;
    private List<Pokemon> listaPokemon;

    Button btnSiguiente;

    Button btnAtras;
    String url = "https://pokeapi.co/api/v2/pokemon";

    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_contactos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listaPokemon = new ArrayList<>();
        adaptadorPoke = new AdaptadorPoke(listaPokemon);
        recyclerView.setAdapter(adaptadorPoke);

        btnSiguiente = findViewById(R.id.btnSiguiente);

        btnAtras = findViewById(R.id.btnAtras);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarSiguientePokemon(v);
                listaPokemon.clear();
            }
        });

        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarAnteriorPokemon(v);
                listaPokemon.clear();
            }
        });

        cargarPokemones();
    }

    public void cargarPokemones(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray results = response.getJSONArray("results");

                            for (int i = 0; i < results.length(); i++) {
                                JSONObject pokemonObject = results.getJSONObject(i);
                                String nombre = pokemonObject.getString("name");
                                String url = pokemonObject.getString("url");
                                System.out.println(nombre);
                                System.out.println(url);
                                Pokemon pokemon = new Pokemon(nombre,url);
                                listaPokemon.add(pokemon);

                                AdaptadorPoke adaptador = new AdaptadorPoke(listaPokemon);
                                recyclerView.setAdapter(adaptador);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                            }

                            /*adaptadorPoke.notifyDataSetChanged();*/

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(solicitud);
    }

    public void cargarSiguientePokemon(View vista){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url_poke = url + "?offset=" + cont + "&limit=20";

        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.GET, url_poke, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray results = response.getJSONArray("results");

                            for (int i = 0; i < results.length(); i++) {
                                JSONObject pokemonObject = results.getJSONObject(i);
                                String nombre = pokemonObject.getString("name");
                                String url = pokemonObject.getString("url");
                                System.out.println(nombre);
                                Pokemon pokemon = new Pokemon(nombre,url);
                                listaPokemon.add(pokemon);

                                AdaptadorPoke adaptador = new AdaptadorPoke(listaPokemon);
                                recyclerView.setAdapter(adaptador);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            }

                            cont +=20;

                            /*adaptadorPoke.notifyDataSetChanged();*/

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(solicitud);

    }

    public void cargarAnteriorPokemon(View vista){
        cont -=20;
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url_poke = url + "?offset=" + cont + "&limit=20";

        JsonObjectRequest solicitud = new JsonObjectRequest(Request.Method.GET, url_poke, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray results = response.getJSONArray("results");

                            for (int i = 0; i < results.length(); i++) {
                                JSONObject pokemonObject = results.getJSONObject(i);
                                String nombre = pokemonObject.getString("name");
                                String url = pokemonObject.getString("url");
                                System.out.println(nombre);
                                Pokemon pokemon = new Pokemon(nombre,url);
                                listaPokemon.add(pokemon);

                                AdaptadorPoke adaptador = new AdaptadorPoke(listaPokemon);
                                recyclerView.setAdapter(adaptador);
                                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                            }

                            /*adaptadorPoke.notifyDataSetChanged();*/

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(solicitud);

    }

}