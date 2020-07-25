package com.cderian.petagram.database;

import android.content.ContentValues;
import android.content.Context;

import com.cderian.petagram.R;
import com.cderian.petagram.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private Context context;
    private static final int LIKE = 1;

    public ConstructorMascotas (Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos bdd = new BaseDatos(context);
        ArrayList<Mascota> mascotas = bdd.obtenerMascotas();

        if (mascotas.size() <= 0) {
            insertarDatos(bdd);
            return bdd.obtenerMascotas();
        } else {
            return mascotas;
        }
    }

    public void insertarDatos (BaseDatos bdd) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_NOMBRE, "Toby");
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_FOTO, R.drawable.perro1);
        bdd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_NOMBRE, "Rex");
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_FOTO, R.drawable.perro2);
        bdd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_NOMBRE, "Max");
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_FOTO, R.drawable.perro3);
        bdd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_NOMBRE, "Bones");
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_FOTO, R.drawable.perro4);
        bdd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_NOMBRE, "Zeus");
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_FOTO, R.drawable.perro5);
        bdd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_NOMBRE, "Besheen");
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_FOTO, R.drawable.perro6);
        bdd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_NOMBRE, "Negro");
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_FOTO, R.drawable.perro7);
        bdd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_NOMBRE, "Golfo");
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_FOTO, R.drawable.perro8);
        bdd.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_NOMBRE, "Rawi");
        contentValues.put(ConstanteBDD.COLUMNA_MASCOTA_FOTO, R.drawable.perro9);
        bdd.insertarMascota(contentValues);
    }

    public void darLike (Mascota mascota) {
        BaseDatos bdd = new BaseDatos(this.context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstanteBDD.COLUMNA_LIKES_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstanteBDD.COLUMNA_LIKES_NUMERO, LIKE);
        bdd.insertarLike(contentValues);
    }

    public int obtenerLikes (Mascota mascota) {
        BaseDatos bdd = new BaseDatos(this.context);
        return bdd.obtenerLikes(mascota);
    }

    public ArrayList<Mascota> obtenerTopMascotas () {
        BaseDatos bdd = new BaseDatos(this.context);
        return bdd.obtenerTopMascotas();
    }

    public ArrayList<Mascota> obtenerLastRatedMascotas() {
        BaseDatos bdd = new BaseDatos(this.context);
        return bdd.obtenerLastRatedMascotas();
    }
}
