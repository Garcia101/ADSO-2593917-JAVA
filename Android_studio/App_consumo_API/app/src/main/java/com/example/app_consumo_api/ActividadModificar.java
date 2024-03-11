package com.example.app_consumo_api;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ActividadModificar extends AppCompatActivity {

    EditText campoNombre;
    EditText campoApellido;
    EditText campoDireccion;
    EditText campoTelefono;

    String document; // Variable para almacenar la cédula del usuario

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar_activity);

        // Obtener referencias a los EditText
        campoNombre = findViewById(R.id.campoNombre);
        campoApellido = findViewById(R.id.campoApellido);
        campoDireccion = findViewById(R.id.campoDireccion);
        campoTelefono = findViewById(R.id.campoTelefono);

        // Obtener el valor de la cédula del usuario
        document = getIntent().getStringExtra("document");

        // Obtener los datos del usuario pasados desde la actividad anterior
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String nombre = extras.getString("first_name");
            String apellido = extras.getString("last_name");
            String direccion = extras.getString("address");
            String telefono = extras.getString("phone");

            // Establecer los datos del usuario en los EditText
            campoNombre.setText(nombre);
            campoApellido.setText(apellido);
            campoDireccion.setText(direccion);
            campoTelefono.setText(telefono);
        }
    }

    public void actualizarUsuario(View vista) {
        // Obtener los nuevos datos del usuario
        String nuevoNombre = campoNombre.getText().toString();
        String nuevoApellido = campoApellido.getText().toString();
        String nuevaDireccion = campoDireccion.getText().toString();
        String nuevoTelefono = campoTelefono.getText().toString();

        // Crear una solicitud para enviar los datos actualizados al servidor
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "http://10.199.145.120/APIenPHP/Update.php";

        StringRequest solicitud = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Manejar la respuesta del servidor después de la actualización
                Toast.makeText(ActividadModificar.this, "Usuario actualizado correctamente", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Manejar errores de la solicitud de actualización
                Toast.makeText(ActividadModificar.this, "Error al actualizar usuario: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                // Agregar los datos al HashMap para enviar al servidor
                params.put("cedula", document);
                params.put("nombres", nuevoNombre);
                params.put("apellidos", nuevoApellido);
                params.put("telefono", nuevoTelefono);
                params.put("direccion", nuevaDireccion);
                return params;
            }
        };

        // Agregar la solicitud a la cola de solicitudes
        queue.add(solicitud);
    }
}
