package com.example.apppreguntas;

import static com.example.apppreguntas.R.id.crear;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apppreguntas.utils.config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Inicio extends AppCompatActivity {
    TextView etq_datos;

    TextView crear;
    LinearLayout layout;
    config config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imprimir_usuario);

        etq_datos = findViewById(R.id.etq_datos);
        crear = findViewById(R.id.crear);
        layout = findViewById(R.id.layout);

        config = new config(getApplicationContext());

        SharedPreferences archivo = getSharedPreferences("preguntas-v2-db", MODE_PRIVATE);
        etq_datos.setText(archivo.getString("nombres", null));

        String id_usuario = archivo.getString("id_usuario","");
        System.out.println("esta es el id del usuaio" +id_usuario);

        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("datos")) {
            String response = extras.getString("datos");

            try {
                JSONObject jsonObject = new JSONObject(response);
                JSONArray datos = jsonObject.getJSONArray("datos");

                for (int i = 0; i < datos.length(); i++) {
                    JSONObject dato = datos.getJSONObject(i);
                    String idCuestionario = dato.getString("id");
                    String fechaInicio = dato.getString("fecha_inicio");
                    String cant_preguntas = dato.getString("cant_preguntas");
                    String cant_ok = dato.getString("cant_ok");
                    String cant_error = dato.getString("cant_error");

                    TextView textView = new TextView(this);
                    // Configurar el TextView con los datos del cuestionario
                    String textoCuestionario = "ID: " + idCuestionario + "\n" +
                            "Fecha de inicio: " + fechaInicio + "\n" +
                            "Cantidad de preguntas: " + cant_preguntas + "\n" +
                            "Cantidad OK: " + cant_ok + "\n" +
                            "Cantidad de errores: " + cant_error + "\n\n";
                    textView.setText(textoCuestionario);

                    textView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Al hacer clic en el TextView, obtener las preguntas del cuestionario
                            obtenerPreguntas(idCuestionario);

                            // Crear un Intent para iniciar la actividad CreacionFormulario
                            Intent intent = new Intent(Inicio.this, CreacionFormulario.class);

                            // Pasar el ID del cuestionario como extra al intent
                            intent.putExtra("idCuestionario", idCuestionario);

                            // Iniciar la actividad del nuevo formulario
                            startActivity(intent);
                        }
                    });

                    layout.addView(textView);
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e("Inicio", "Error al procesar datos JSON: " + e.getMessage());
            }
        }
    }

    // Método obtenerPreguntas modificado
    private void obtenerPreguntas(String idCuestionario) {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = config.getEndpoint("apiPreguntas/preguntas.php?id_cuestionario=" + idCuestionario);

        StringRequest solicitud = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray respuestasArray = jsonObject.getJSONArray("respuestas");

                    ArrayList<String> listaPreguntas = new ArrayList<>();
                    ArrayList<ArrayList<String>> listaOpciones = new ArrayList<>();
                    int respuestasCorrectas = 0; // Inicializamos el contador de respuestas correctas

                    for (int i = 0; i < respuestasArray.length(); i++) {
                        JSONObject respuestaObj = respuestasArray.getJSONObject(i);
                        JSONObject preguntaObj = respuestaObj.getJSONObject("pregunta");

                        String textoPregunta = preguntaObj.getString("descripcion");
                        String respuestaCorrecta = preguntaObj.getString("respuesta");

                        if (!listaPreguntas.contains(textoPregunta)) {
                            listaPreguntas.add(textoPregunta);

                            ArrayList<String> opcionesPregunta = new ArrayList<>();
                            opcionesPregunta.add(respuestaCorrecta);

                            // Verificar si "opcion" es un objeto JSON o un array JSON
                            if (respuestaObj.has("opcion")) {
                                Object opcion = respuestaObj.get("opcion");
                                if (opcion instanceof JSONObject) {
                                    // Si "opcion" es un objeto JSON, agregar su descripción directamente
                                    JSONObject opcionObj = (JSONObject) opcion;
                                    String descripcionOpcion = opcionObj.getString("descripcion");
                                    if (!descripcionOpcion.equals(respuestaCorrecta)) {
                                        opcionesPregunta.add(descripcionOpcion);
                                        Log.d("Opción agregada", descripcionOpcion); // Registro de depuración
                                    }
                                } else if (opcion instanceof JSONArray) {
                                    // Si "opcion" es un array JSON, iterar sobre sus elementos
                                    JSONArray opcionesArray = (JSONArray) opcion;
                                    for (int j = 0; j < opcionesArray.length(); j++) {
                                        JSONObject opcionObj = opcionesArray.getJSONObject(j);
                                        String descripcionOpcion = opcionObj.getString("descripcion");
                                        if (!descripcionOpcion.equals(respuestaCorrecta)) {
                                            opcionesPregunta.add(descripcionOpcion);
                                            Log.d("Opción agregada", descripcionOpcion); // Registro de depuración
                                        }
                                    }
                                }
                            }

                            listaOpciones.add(opcionesPregunta);

                            // Incrementamos el contador de respuestas correctas si la respuesta es correcta
                            if (respuestaCorrecta.equals("Respuesta correcta")) {
                                respuestasCorrectas++;
                            }
                        }
                    }

                    // Registro de depuración para verificar las listas de preguntas y opciones
                    Log.d("Lista de preguntas", listaPreguntas.toString());
                    Log.d("Lista de opciones", listaOpciones.toString());

                    // Llamar al método para registrar las preguntas en el servidor
                    Intent intent = new Intent(Inicio.this, Preguntas.class);
                    intent.putStringArrayListExtra("preguntas", listaPreguntas);
                    intent.putExtra("opciones", listaOpciones);
                    startActivity(intent);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("Inicio", "Error al procesar respuesta JSON: " + e.getMessage());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Manejar errores de la solicitud HTTP
                error.printStackTrace();
                Log.e("Inicio", "Error en la solicitud HTTP: " + error.getMessage());
            }
        });
        queue.add(solicitud);
    }

    public void cerrarSesion(View vista){
        SharedPreferences archivo = getSharedPreferences("preguntas-v2-db", MODE_PRIVATE);

        SharedPreferences.Editor editor = archivo.edit();
        editor.clear();
        editor.commit();

        Intent intencion = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intencion);
        finish();
    }

    public void crearFormulario(View vista) {
        // Crear un Intent para iniciar la actividad del formulario
        Intent intent = new Intent(this, NuevoCuestionario.class);

        // Iniciar la actividad del formulario
        startActivity(intent);
    }

}
