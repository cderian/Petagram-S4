package com.cderian.petagram.database;

public final class ConstanteBDD {

    public static final String DATABASE_NAME = "Mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLA_MASCOTA            = "mascotas";
    public static final String COLUMNA_MASCOTA_ID       = "id";
    public static final String COLUMNA_MASCOTA_NOMBRE   = "nombre";
    public static final String COLUMNA_MASCOTA_FOTO     = "foto";

    public static final String TABLA_LIKES              = "mascotas_likes";
    public static final String COLUMNA_LIKES_ID         = "id";
    public static final String COLUMNA_LIKES_NUMERO     = "numero_likes";
    public static final String COLUMNA_LIKES_ID_MASCOTA = "id_mascota";
}
