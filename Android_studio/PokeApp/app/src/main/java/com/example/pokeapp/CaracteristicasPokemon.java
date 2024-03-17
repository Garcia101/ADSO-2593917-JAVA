package com.example.pokeapp;

import java.util.List;

public class CaracteristicasPokemon {

    String [] listaImg;

    List<String> listaHabilidades;

    public CaracteristicasPokemon(String[] img, List<String> habilidades) {
        this.listaImg = img;
        this.listaHabilidades = habilidades;
    }

    public CaracteristicasPokemon(List<String> habilidades) {
        this.listaHabilidades = habilidades;
    }

    public List<String> getListaHabilidades() {
        return listaHabilidades;
    }


    public void setListaHabilidades(List<String> listaHabilidades) {
        this.listaHabilidades = listaHabilidades;
    }

    public CaracteristicasPokemon(String [] img) {
        this.listaImg = img;
    }

    public String[] getListaImg() {
        return listaImg;
    }

    public void setListaImg(String[] listaImg) {
        this.listaImg = listaImg;
    }


}
