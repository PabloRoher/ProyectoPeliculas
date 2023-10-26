package com.example.proyectopeliculas;

import android.os.Parcelable;

import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private String director;
    private ArrayList actores;
    private String portada;

    public Pelicula(String titulo, String director, ArrayList actores, String portada) {
        this.titulo = titulo;
        this.director = director;
        this.actores = actores;
        this.portada = portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList getActores() {
        return actores;
    }

    public void setActores(ArrayList actores) {
        this.actores = actores;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}
