package com.example.pokeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorHabilidades extends RecyclerView.Adapter<AdaptadorHabilidades.ViewHolder> {

    List<CaracteristicasPokemon> listaHabilidades;

    public AdaptadorHabilidades(List<CaracteristicasPokemon> listaPokemons) {
        this.listaHabilidades = listaPokemons;
    }

    @NonNull
    @Override
    public AdaptadorHabilidades.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.habilidad_item, parent, false);
        return new AdaptadorHabilidades.ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorHabilidades.ViewHolder holder, int position) {
        CaracteristicasPokemon temporal = listaHabilidades.get(position);
        holder.cargarHabilidad(temporal);
    }

    @Override
    public int getItemCount() {
        return listaHabilidades.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtHabilidad;

        Context contexto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contexto = itemView.getContext();
            txtHabilidad = itemView.findViewById(R.id.txtHabilidad);
        }

        public void cargarHabilidad(CaracteristicasPokemon datos){
            List<String> habilidades = datos.getListaHabilidades();
            if (habilidades != null && !habilidades.isEmpty()) {
                // Aquí puedes manejar la lista de habilidades, por ejemplo, mostrar la primera habilidad en el TextView
                txtHabilidad.setText(habilidades.get(0));
            } else {
                // Manejar el caso en que no haya habilidades disponibles
                txtHabilidad.setText("Sin habilidades");
            }

        }
    }
}
