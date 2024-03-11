package com.example.app_consumo_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView etqRespuesta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Registrar(View vista){
        Intent intencion = new Intent(getApplicationContext(), ActividadRegistro.class);
        startActivity(intencion);
    }

    public void Visualizar(View vista){
        Intent intencion = new Intent(getApplicationContext(), ActividadVisualizar.class);
        startActivity(intencion);
    }

    public void Eliminar(View vista){
        Intent intencion = new Intent(getApplicationContext(), ActividadEliminar.class);
        startActivity(intencion);
    }

}