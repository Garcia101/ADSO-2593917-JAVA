package com.example.apppreguntas;

import static com.example.apppreguntas.R.id.btn_empezar;
import static com.example.apppreguntas.R.id.etq_nombre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apppreguntas.CreacionFormulario;
import com.example.apppreguntas.utils.config;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class NuevoCuestionario extends AppCompatActivity {
    TextView etq_nombre;
    TextView etq_fecha;
    config config;

    Button btn_empezar;

    String id_quest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nuevo_formulario);
        etq_nombre = findViewById(R.id.etq_nombre);
        etq_fecha = findViewById(R.id.etq_fecha);
        btn_empezar = findViewById(R.id.btn_empezar);
        SharedPreferences archivo = getSharedPreferences("preguntas-v2-db",MODE_PRIVATE);
        etq_nombre.setText(archivo.getString("nombres",""));
        String id_usuario = archivo.getString("id_usuario","");
        System.out.println("esta es el id del usuaio" +id_usuario);
        config = new config(getApplicationContext());
        //Obtener la fecha actual del sistema
        Date fechaActual = new Date();

        // Formatear la fecha y hora actual
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaFormateada = formato.format(fechaActual);

        etq_fecha.setText(fechaFormateada);

        btn_empezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consumo(fechaFormateada, id_usuario);
            }
        });

    }
    public void consumo(String fecha, String id_usuario){
        String date = fecha;
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        SharedPreferences archivo = getSharedPreferences("preguntas-v2-db",MODE_PRIVATE);

        String url = config.getEndpoint("apiPreguntas/createCuestionario.php");
        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println(response);
                    System.out.println("El servidor POST responde OK respuesta");
                    System.out.print(response);
                    JSONObject jsonObject = new JSONObject(response);

                    Boolean status = jsonObject.getBoolean("status");
                    if(status){
                        String id_cuestionario = jsonObject.getString("id_cuestionario");
                        cambiarActivity(date, id_cuestionario);
                        System.out.println("esta es el id del cuestionario" +id_cuestionario);


                    }
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
        }){
            protected Map<String, String> getParams(){

                Map<String, String> params = new HashMap<String, String>();
                params.put("fecha_inicio", fecha );
                params.put("id_usuario", id_usuario );

                return params;
            }
        };

        queue.add(solicitud);

    }
    public void cambiarActivity(String fecha, String id_cuestionario){
        Intent intencion = new Intent(getApplicationContext(), CreacionFormulario.class);
        intencion.putExtra("fecha_inicio", fecha);

        intencion.putExtra("id_cuestionario", id_cuestionario);
        startActivity(intencion);
    }


}