package com.cderian.petagram.vista.menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cderian.petagram.R;
import com.cderian.petagram.adapter.PetAdapter;
import com.cderian.petagram.pojo.Mascota;
import com.cderian.petagram.presenter.LastRatedPetsPresenter;
import com.cderian.petagram.vista.IPetListView;

import java.util.ArrayList;

public class LastRatedPetsActivity extends AppCompatActivity implements IPetListView {

    private RecyclerView rvMascotas;
    private Toolbar toolbar;
    private LastRatedPetsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rated_pates);

        toolbar = findViewById(R.id.actionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvMascotas = findViewById(R.id.ratedPetsView);
        presenter =  new LastRatedPetsPresenter(this, this);
    }

    @Override
    public void generarLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public PetAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        PetAdapter petAdapter = new PetAdapter(mascotas, LastRatedPetsActivity.this);
        return petAdapter;
    }

    @Override
    public void inicializarAdaptador(PetAdapter adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}