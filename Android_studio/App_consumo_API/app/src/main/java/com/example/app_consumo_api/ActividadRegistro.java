package com.example.app_consumo_api;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ActividadRegistro extends AppCompatActivity{

    EditText cedula, nombre, apellido, direccion, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_activity);

        this.cedula=findViewById(R.id.campoCedula);
        this.nombre=findViewById(R.id.campoNombre);
        this.apellido=findViewById(R.id.campoApellido);
        this.direccion=findViewById(R.id.campoDireccion);
        this.telefono=findViewById(R.id.campoTelefono);
    }


    public void consumoPOST(View vista){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://10.199.145.120/APIenPHP/Insert.php";

        String cedula = this.cedula.getText().toString();
        String nombre = this.nombre.getText().toString();
        String apellido = this.apellido.getText().toString();
        String direccion = this.direccion.getText().toString();
        String telefono = this.telefono.getText().toString();

        StringRequest solicitud = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // toast es un objeto que se invoca para dar un mensaje
                Toast.makeText(ActividadRegistro.this, "Usuario registrado exitosamente", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ActividadRegistro.this, "Error al registrar usuario: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("cedula", cedula);
                params.put("nombres", nombre);
                params.put("apellidos", apellido);
                params.put("telefono", telefono);
                params.put("direccion", direccion);

                return params;
            }
        };

        queue.add(solicitud);
    }

}
