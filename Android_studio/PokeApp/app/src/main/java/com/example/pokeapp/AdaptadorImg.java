package com.example.pokeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdaptadorImg extends RecyclerView.Adapter< AdaptadorImg.ViewHolder >{

    List<CaracteristicasPokemon> listaPokemons;

    public AdaptadorImg(List<CaracteristicasPokemon> listaPokemons) {
        this.listaPokemons = listaPokemons;
    }

    @NonNull
    @Override
    public AdaptadorImg.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.poke_imagen, parent, false);
        return new AdaptadorImg.ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorImg.ViewHolder holder, int position) {
        CaracteristicasPokemon temporal = listaPokemons.get(position);
        /*holder.cargarDatos( temporal );*/
    }

    @Override
    public int getItemCount() {
        return listaPokemons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPokemon;
        Context contexto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contexto = itemView.getContext();
            imgPokemon = itemView.findViewById(R.id.imgPokemon);
        }
    }


}
