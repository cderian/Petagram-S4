package com.cderian.petagram.vista.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cderian.petagram.R;
import com.cderian.petagram.adapter.PetAdapter;
import com.cderian.petagram.database.ConstructorMascotas;
import com.cderian.petagram.pojo.Mascota;

import java.util.ArrayList;

public class RatedPatesActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    RecyclerView listaMejoresMascotas;
    private Toolbar toolbar;

    private ConstructorMascotas constructor;

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
        mascotas = new ArrayList<>();
        constructor = new ConstructorMascotas(this);

        mascotas = constructor.obtenerTopMascotas();
    }

    public void inicializarAdaptador() {
        PetAdapter petAdapter = new PetAdapter(mascotas, RatedPatesActivity.this);
        listaMejoresMascotas.setAdapter(petAdapter);
    }
}