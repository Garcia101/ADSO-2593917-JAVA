package com.example.apppreguntas;

import static com.example.apppreguntas.R.id.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.audiofx.DynamicsProcessing;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText mail;
    EditText password;

    config config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mail = findViewById(R.id.campoCorreo);
        this.password = findViewById(R.id.campoContraseña);
        config = new config(getApplicationContext());
        validarSesion();

    }

    public void validarIngreso(View vista){
        String mail = this.mail.getText().toString();
        String password = this.password.getText().toString();

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = config.getEndpoint("apiPreguntas/validarIngreso.php");

        StringRequest solicitud = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("El servidor POST responde OK");
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject user_data = jsonObject.getJSONObject("user_data");

                    String nombres = user_data.getString("nombres");
                    String id_usuario = user_data.getString("id_usuario");

                    cambiarActivity(id_usuario, nombres);
                    cambiarActivity2(id_usuario, nombres);

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
                params.put("correo", mail);
                params.put("password", password);

                return params;
            }
        };

        queue.add(solicitud);
    }

    public void cambiarActivity(String id_usuario, String nombres){
        SharedPreferences archivo = getSharedPreferences("preguntas-v2-db", MODE_PRIVATE);

        SharedPreferences.Editor editor = archivo.edit();

        editor.putString("id_usuario", id_usuario);
        editor.putString("nombres", nombres);
        editor.commit();

        cuestionarios();


        Intent intencion = new Intent(getApplicationContext(), Inicio.class);
        startActivity(intencion);
        finish();
    }

    public void cambiarActivity2(String id_usuario, String nombres){
        SharedPreferences archivo = getSharedPreferences("preguntas-v2-db", MODE_PRIVATE);

        SharedPreferences.Editor editor = archivo.edit();

        editor.putString("id_usuario", id_usuario);
        editor.putString("nombres", nombres);
        editor.commit();

        cuestionarios();


        Intent intencion = new Intent(getApplicationContext(), NuevoCuestionario.class);
        startActivity(intencion);
        finish();
    }

    public void cambiarActivity3(String id_usuario, String nombres){
        SharedPreferences archivo = getSharedPreferences("preguntas-v2-db", MODE_PRIVATE);

        SharedPreferences.Editor editor = archivo.edit();

        editor.putString("id_usuario", id_usuario);
        editor.putString("nombres", nombres);
        editor.commit();

        cuestionarios();


        Intent intencion = new Intent(getApplicationContext(), Preguntas.class);
        startActivity(intencion);
        finish();
    }

    public void cambiarActivity4(String id_usuario, String nombres){
        SharedPreferences archivo = getSharedPreferences("preguntas-v2-db", MODE_PRIVATE);

        SharedPreferences.Editor editor = archivo.edit();

        editor.putString("id_usuario", id_usuario);
        editor.putString("nombres", nombres);
        editor.commit();

        cuestionarios();


        Intent intencion = new Intent(getApplicationContext(), Preguntas.class);
        startActivity(intencion);
        finish();
    }

    public void cuestionarios (){
        SharedPreferences sharedPreferences = getSharedPreferences("preguntas-v2-db", MODE_PRIVATE);
        String idUsuario = sharedPreferences.getString("id_usuario", "Usuario no Logueado");

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = config.getEndpoint("apiPreguntas/cuestionarios.php");

        StringRequest solicitud = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Enviar los datos recuperados a la actividad Inicio
                Intent intent = new Intent(MainActivity.this, Inicio.class);
                intent.putExtra("datos", response);
                startActivity(intent);
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
                params.put("idUsuario", idUsuario);
                return params;
            }
        };

        queue.add(solicitud);
    }

    public void validarSesion(){

        SharedPreferences archivo = getSharedPreferences("preguntas-v2-db", MODE_PRIVATE);
        String id_usuario = archivo.getString("id_usuario", null) ;
        String nombres = archivo.getString("nombres",null);

        if (id_usuario!=null && nombres!=null){
            Intent intencion = new Intent(getApplicationContext(), Inicio.class);
            startActivity(intencion);
            finish();
        }
    }

}