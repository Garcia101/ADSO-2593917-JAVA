package com.example.segundaaplicacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView etqRespuesta;

    EditText nombres, apellido,direccion,telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nombres=findViewById(R.id.campoNombre);
        this.apellido=findViewById(R.id.campoApellido);
        this.direccion=findViewById(R.id.campoDireccion);
        this.telefono=findViewById(R.id.campoTelefono);

    }

    public void imprimirSaludo(View vista){
        String nombres = this.nombres.getText().toString();
        String apellido = this.apellido.getText().toString();
        String direccion = this.direccion.getText().toString();
        String telefono = this.telefono.getText().toString();
        this.etqRespuesta.setText("");
        this.etqRespuesta.append("nombres"+nombres+"\n");
        this.etqRespuesta.append("apellido"+apellido+"\n");
        this.etqRespuesta.append("direccion"+direccion+"\n");
        this.etqRespuesta.append("telefono"+telefono+"\n");

        Intent intencion = new Intent(getApplicationContext(), Main2Activity.class);

        intencion.putExtra("nombres", nombres);
        intencion.putExtra("apellido", apellido);
        intencion.putExtra("direccion", direccion);
        intencion.putExtra("telefono", telefono);

        startActivity(intencion);
    }
}