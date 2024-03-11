package com.example.app_consumo_api;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintHelper;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ActividadVisualizar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualizar_activity);

    }

    public void consumoGET(View vista){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext()); /* hilo asincrono */
        String url = "http://10.199.145.120/APIenPHP/Obtener.php"; /* URL endpoint */

        JsonObjectRequest solicitud =  new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                System.out.println("El servidor responde OK");
                System.out.println(response.toString());
                /*etq_respuesta.setText(response.toString());*/

                visualizarUsuarios(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("El servidor responde con un error:");
                System.out.println(error.getMessage());
            }
        });

        queue.add(solicitud);
    }

    public void visualizarUsuarios (JSONObject clientes){
        LinearLayout padre = findViewById(R.id.etq_respuesta);
        try {
            JSONArray array = clientes.getJSONArray("registros");
            for (int i = 0; i<array.length(); i++){
                JSONObject client = array.getJSONObject(i);
                String document = client.getString("cedula");
                String first_name = client.getString("nombres");
                String last_name = client.getString("apellidos");
                String phone = client.getString("telefono");
                String address = client.getString("direccion");

                TextView textView = new TextView(this);
                textView.setText(document + " " + first_name + " " + last_name + " " + phone + " " + address);

                // Agregar un botón "Modificar" para cada usuario
                Button btnModificar = new Button(this);
                btnModificar.setText("Modificar");
                btnModificar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(getApplicationContext(), ActividadModificar.class);
                        intent.putExtra("document", document);
                        intent.putExtra("first_name", first_name);
                        intent.putExtra("last_name", last_name);
                        intent.putExtra("phone", phone);
                        intent.putExtra("address", address);
                        startActivity(intent);
                    }
                });

                padre.addView(textView);
                padre.addView(btnModificar);
            }
        }catch (JSONException e){
            throw new RuntimeException(e);
        }
    }
}
