package com.cderian.petagram.pojo;

public class Mascota {

    private int id;
    private String nombre;
    private int likes;
    private int foto;

    public Mascota(int id, String nombre, int foto) {
        this.id = id;
        this.nombre = nombre;
        this.likes = 0;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
