package com.cderian.petagram.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cderian.petagram.R;
import com.cderian.petagram.adapter.PetAdapter;
import com.cderian.petagram.pojo.Mascota;

import java.util.ArrayList;

public class RatedPatesActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    RecyclerView listaMejoresMascotas;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rated_pates);

        toolbar = findViewById(R.id.actionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMejoresMascotas = findViewById(R.id.ratedPetsView);

        GridLayoutManager glm = new GridLayoutManager(this, 1);
        listaMejoresMascotas.setLayoutManager(glm);

        inicializarMascotas();
        inicializarAdaptador();
    }

    public void inicializarMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(2, "Rex", R.drawable.perro2));
        mascotas.add(new Mascota(3, "Max", R.drawable.perro3));
        mascotas.add(new Mascota(6, "Besheen", R.drawable.perro6));
        mascotas.add(new Mascota(7, "Negro", R.drawable.perro7));
        mascotas.add(new Mascota(9, "Rawi", R.drawable.perro9));
    }

    public void inicializarAdaptador() {
        PetAdapter petAdapter = new PetAdapter(mascotas, RatedPatesActivity.this);
        listaMejoresMascotas.setAdapter(petAdapter);
    }
}