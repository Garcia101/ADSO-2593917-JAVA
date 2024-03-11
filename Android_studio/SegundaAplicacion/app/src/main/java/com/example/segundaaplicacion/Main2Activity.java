package com.example.segundaaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView etqRespuesta;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        this.etqRespuesta=findViewById(R.id.etqRespuesta);
        this.etqRespuesta.setText("");

        Intent intencion = getIntent();
        String nombres = intencion.getStringExtra("nombres");
        String apellido = intencion.getStringExtra("apellido");
        String direccion = intencion.getStringExtra("direccion");
        String telefono = intencion.getStringExtra("telefono");

        this.etqRespuesta.append("nombres" + nombres+"\n");
        this.etqRespuesta.append("nombres" + apellido+"\n");
        this.etqRespuesta.append("nombres" + direccion+"\n");
        this.etqRespuesta.append("nombres" + telefono+"\n");
    }
}