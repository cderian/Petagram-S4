package com.cderian.petagram.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cderian.petagram.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstanteBDD.DATABASE_NAME, null, ConstanteBDD.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryTablaMascotas = "CREATE TABLE " + ConstanteBDD.TABLA_MASCOTA + " ("
                + ConstanteBDD.COLUMNA_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstanteBDD.COLUMNA_MASCOTA_NOMBRE + " TEXT, "
                + ConstanteBDD.COLUMNA_MASCOTA_FOTO + " INTEGER)";

        String queryTablaLikes = "CREATE TABLE " + ConstanteBDD.TABLA_LIKES + " ("
                + ConstanteBDD.COLUMNA_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + ConstanteBDD.COLUMNA_LIKES_NUMERO + " INTEGER, "
                + ConstanteBDD.COLUMNA_LIKES_ID_MASCOTA + " INTEGER, "
                + "FOREIGN KEY (" + ConstanteBDD.COLUMNA_MASCOTA_ID + ")"
                + "REFERENCES " + ConstanteBDD.TABLA_MASCOTA
                + "(" + ConstanteBDD.COLUMNA_MASCOTA_ID + ")"
                + ")";

        db.execSQL(queryTablaMascotas);
        db.execSQL(queryTablaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstanteBDD.TABLA_MASCOTA);
        db.execSQL("DROP TABLE IF EXISTS " + ConstanteBDD.TABLA_LIKES);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstanteBDD.TABLA_MASCOTA;
        SQLiteDatabase bdd = this.getWritableDatabase();

        Cursor registros = bdd.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascota mascota = new Mascota();
            mascota.setId(registros.getInt(0));
            mascota.setNombre(registros.getString(1));
            mascota.setFoto(registros.getInt(2));
            mascota.setLikes(0);

            mascotas.add(mascota);
        }

        bdd.close();
        return mascotas;
    }

    public void insertarMascota (ContentValues contentValues) {
        SQLiteDatabase bdd = this.getWritableDatabase();
        bdd.insert(ConstanteBDD.TABLA_MASCOTA, null, contentValues);
        bdd.close();
    }
}
