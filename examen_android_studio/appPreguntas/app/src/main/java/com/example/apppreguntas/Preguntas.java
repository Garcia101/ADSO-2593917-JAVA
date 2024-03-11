package com.example.apppreguntas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Preguntas extends AppCompatActivity {

    TextView etq_datos, etq_fecha_inicio, etq_fecha_fin, etq_correctas, etq_incorrectas;
    LinearLayout layout;
    ArrayList<String> respuestasCorrectas;
    boolean cuestionarioTerminado = false;
    String idCuestionario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preguntas);

        etq_datos = findViewById(R.id.etq_datos);
        etq_fecha_inicio = findViewById(R.id.etq_fecha_inicio);
        etq_fecha_fin = findViewById(R.id.etq_fecha_fin);
        etq_correctas = findViewById(R.id.etq_correctas);
        etq_incorrectas = findViewById(R.id.etq_incorrectas);
        layout = findViewById(R.id.layout);

        SharedPreferences archivo = getSharedPreferences("preguntas-v2-db", MODE_PRIVATE);
        etq_datos.setText(archivo.getString("nombres", null));

        // Inicializar la lista de respuestas correctas
        respuestasCorrectas = new ArrayList<>();

        Intent intent = getIntent();
        if (intent != null) {
            ArrayList<String> listaPreguntas = intent.getStringArrayListExtra("preguntas");
            ArrayList<ArrayList<String>> listaOpciones = (ArrayList<ArrayList<String>>) intent.getSerializableExtra("opciones");
            idCuestionario = intent.getStringExtra("idCuestionario");

            if (listaPreguntas != null && listaOpciones != null && listaPreguntas.size() == listaOpciones.size()) {
                for (int i = 0; i < listaPreguntas.size(); i++) {
                    // Crear TextView para la pregunta
                    TextView textViewPregunta = new TextView(this);
                    textViewPregunta.setText("Pregunta: " + listaPreguntas.get(i));
                    textViewPregunta.setTextSize(18); // Tamaño del texto para la pregunta

                    // Crear RadioGroup para las opciones
                    RadioGroup radioGroup = new RadioGroup(this);
                    for (String opcion : listaOpciones.get(i)) {
                        RadioButton radioButton = new RadioButton(this);
                        radioButton.setText(opcion);
                        radioGroup.addView(radioButton);
                    }

                    // Agregar margen inferior al RadioGroup
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    params.setMargins(0, 0, 0, 40);
                    radioGroup.setLayoutParams(params);

                    // Agregar los elementos al layout
                    layout.addView(textViewPregunta);
                    layout.addView(radioGroup);
                }
            } else {
                TextView textViewError = new TextView(this);
                textViewError.setText("Error: No se encontraron preguntas u opciones de respuesta.");
                layout.addView(textViewError);
            }
        } else {
            TextView textViewError = new TextView(this);
            textViewError.setText("Error: No se recibieron datos de preguntas y opciones de respuesta.");
            layout.addView(textViewError);
        }
    }
}
