package com.example.pokeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptadorImg extends RecyclerView.Adapter<AdaptadorImg.ViewHolder> {

    List<CaracteristicasPokemon> listaImagenes;

    public AdaptadorImg(List<CaracteristicasPokemon> listaPokemons) {
        this.listaImagenes = listaPokemons;
    }

    @NonNull
    @Override
    public AdaptadorImg.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.poke_imagen, parent, false);
        return new AdaptadorImg.ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorImg.ViewHolder holder, int position) {
        CaracteristicasPokemon temporal = listaImagenes.get(position);
        holder.cargarImg(temporal);
    }

    @Override
    public int getItemCount() {
        return listaImagenes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPokemon;

        Context contexto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contexto = itemView.getContext();
            imgPokemon = itemView.findViewById(R.id.imgPokemon);
        }

        public void cargarImg(CaracteristicasPokemon datos){
            String[] imagenes = datos.getListaImg();

            for (String imagen : imagenes) {
                System.out.println("URL de la imagen: " + imagen);
                Picasso.get().load(imagen).into(imgPokemon, new Callback() {
                    @Override
                    public void onSuccess() {
                        // La imagen se cargó correctamente
                        System.out.println("La imagen se cargó correctamente");
                    }

                    @Override
                    public void onError(Exception e) {
                        // Se produjo un error al cargar la imagen
                        System.out.println("Error al cargar la imagen: " + e.getMessage());
                    }
                });
            }


        }
    }
}

