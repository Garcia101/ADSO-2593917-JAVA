package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apppreguntas.utils.config;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CreacionFormulario extends AppCompatActivity {

    TextView etq_nombre;

    TextView etq_fecha;

    config config;

    TextView etq_pregunta;
    ImageView etq_img;
    TextView etq_id;

    RadioGroup container_buttons;
    int cant_preguntas;
    String opcion_seleccionada;
    String id_correcta;

    String id_respuesta;

    String id_cuestionario;

    String id_preguntaG;

    String fecha_inicio;
    Set<String> preguntasMostradas; // Conjunto para almacenar IDs de preguntas mostradas
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creacion_formulario);
        SharedPreferences archivo = getSharedPreferences("preguntas-v2-db",MODE_PRIVATE);
        etq_nombre = findViewById(R.id.etq_nombre);
        etq_fecha = findViewById(R.id.etq_fecha);
        etq_pregunta = findViewById(R.id.etq_pregunta);
        etq_id = findViewById(R.id.etq_id);
        etq_img = findViewById(R.id.etq_img);
        container_buttons = findViewById(R.id.container_buttons);
        etq_nombre.setText(archivo.getString("nombres",""));
        Intent intencion = getIntent();
        fecha_inicio = intencion.getStringExtra("fecha_inicio");
        id_cuestionario = intencion.getStringExtra("id_cuestionario");
        preguntasMostradas = new HashSet<>();
        etq_fecha.setText("Inicio: "+fecha_inicio);
        etq_id.setText("Pregunta: ");


        config = new config(getApplicationContext());
        cargarDatos();
    }

    public void cargarDatos(){
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        SharedPreferences archivo = getSharedPreferences("preguntas-v2-db",MODE_PRIVATE);

        String url = config.getEndpoint("apiPreguntas/obtenerPreguntas.php");
        StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    System.out.println("El servidor POST responde OK respuesta");
                    System.out.print(response);
                    JSONObject jsonObject = new JSONObject(response);

                    Boolean status = jsonObject.getBoolean("status");
                    if(status){
                        cant_preguntas = jsonObject.getInt("cant_preguntas");
                        JSONObject respuestaObject = jsonObject.getJSONObject("preguntas");

                        id_preguntaG = respuestaObject.getString("id");
                        String descripcion = respuestaObject.getString("descripcion");
                        id_correcta = respuestaObject.getString("id_correcta");
                        String url_imagen = respuestaObject.getString("url_imagen");
                        mostrarPreguntas(id_preguntaG, descripcion, id_correcta, url_imagen);

                        JSONArray respuestaArray = jsonObject.getJSONArray("opciones");

                        mostrarOpciones(respuestaArray);
                    }
                } catch (JSONException e) {
                    System.out.println("El servidor POST responde con un error catch:");
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
                Intent intencion = getIntent();
                String id_cuestionario = intencion.getStringExtra("id_cuestionario");
                Map<String, String> params = new HashMap<String, String>();
                params.put("id_cuestionario", id_cuestionario);

                return params;
            }
        };

        queue.add(solicitud);
    }

    public void mostrarPreguntas(String id,String descripcion,String id_correcta,String url_imagen){
        if (!preguntasMostradas.contains(id)) {
            // Si la pregunta no se ha mostrado, mostrarla y agregar su ID al conjunto
            etq_pregunta.setText(descripcion);
            Picasso.get().load(url_imagen).into(etq_img);
            preguntasMostradas.add(id);
        } else {
            // Si la pregunta ya se ha mostrado, cargar una nueva pregunta
            container_buttons.removeAllViews();
            cargarDatos();
        }

    }

    public void mostrarOpciones(JSONArray opcionesArray){
        container_buttons.removeAllViews(); // Limpiar las opciones anteriores

        try {
            for(int i = 0; i < opcionesArray.length(); i++){
                JSONObject opcionObj = opcionesArray.getJSONObject(i);
                String id_opcion = opcionObj.getString("id");
                int id_question = opcionObj.getInt("id_pregunta");
                String descripcion_op = opcionObj.getString("descripcion");

                if(id_opcion.equals(id_correcta)){
                    id_respuesta=descripcion_op;
                }

                RadioButton opcion = new RadioButton(this);
                opcion.setText(descripcion_op);

                container_buttons.addView(opcion);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        container_buttons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);

                if (radioButton != null && radioButton.isChecked()) {
                    opcion_seleccionada = radioButton.getText().toString();

                }
            }
        });
    }
    public void siguiente(View view){

        container_buttons.removeAllViews(); // Limpiar las opciones anteriores
        etq_pregunta.setText(""); // Limpiar la pregunta anterior
        etq_img.setImageDrawable(null); // Limpiar la imagen anterior (si hay)
        String seleccionado = opcion_seleccionada;
        String estado = seleccionado.equals(id_respuesta) ? "OK" : "ERROR";
        if(seleccionado!=null){

            System.out.println("Opcion seleccionada: "+seleccionado +"    " +id_respuesta + estado );

            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            SharedPreferences archivo = getSharedPreferences("preguntas-v2-db",MODE_PRIVATE);

            String url = config.getEndpoint("apiPreguntas/insertarRespuesta.php");
            StringRequest solicitud =  new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        System.out.println("El servidor POST responde OK respuesta");
                        System.out.println(response);
                        JSONObject jsonObject = new JSONObject(response);
                    } catch (JSONException e) {
                        System.out.println("El servidor POST responde con un error CATCH:");
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
                    params.put("id_cuestionario", id_cuestionario );
                    params.put("id_pregunta", id_preguntaG );
                    params.put("respuesta", seleccionado);
                    params.put("estado",estado);
                    params.put("fecha", fecha_inicio);

                    return params;
                }
            };

            queue.add(solicitud);
            if (preguntasMostradas.size() >= cant_preguntas) {

                // Si se han mostrado todas las preguntas, abrir la nueva actividad
                abrirNuevaActividad();
            } else {
                // Si aún quedan preguntas por mostrar, cargar la siguiente pregunta
                cargarDatos();
            }
        }else{
            Toast.makeText(this, "Por favor, seleccione una opcion antes de continuar", Toast.LENGTH_SHORT).show();
        }

    }

    public void abrirNuevaActividad(){
        Intent intencion = new Intent(getApplicationContext(), Inicio.class);
        startActivity(intencion);
    }
}