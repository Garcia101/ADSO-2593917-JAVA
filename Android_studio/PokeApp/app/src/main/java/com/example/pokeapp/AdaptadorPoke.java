package com.example.pokeapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.List;

public class AdaptadorPoke extends RecyclerView.Adapter< AdaptadorPoke.ViewHolder > {

    List<Pokemon> listaPokemon;

    public AdaptadorPoke(List<Pokemon> lista){
        this.listaPokemon = lista;
    }

    @NonNull
    @Override
    public AdaptadorPoke.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contacto, parent, false);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPoke.ViewHolder holder, int position) {
        Pokemon temporal = listaPokemon.get(position);
        holder.cargarDatos( temporal );
    }

    @Override
    public int getItemCount() {
        return listaPokemon.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgContacto;

        TextView nombresContacto;

        ImageView btnDetalle;

        Context contexto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            contexto = itemView.getContext();
            imgContacto = itemView.findViewById(R.id.imgContacto);
            nombresContacto = itemView.findViewById(R.id.nombreContacto);
            btnDetalle = itemView.findViewById(R.id.btnDetalle);

        }

        public void cargarDatos(Pokemon datos){
            nombresContacto.setText( datos.getNombre());

            btnDetalle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(contexto, Detalle.class);
                    intent.putExtra("nombrePokemon", datos.getNombre());
                    intent.putExtra("otroDato", "Valor");
                    contexto.startActivity(intent);
                    Toast.makeText( contexto, datos.getNombre(), Toast.LENGTH_LONG ).show();
                }
            });
        }


    }


}