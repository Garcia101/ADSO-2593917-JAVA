package com.example.pokeapp;

public class CaracteristicasPokemon {

    String [] listaImg;

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
