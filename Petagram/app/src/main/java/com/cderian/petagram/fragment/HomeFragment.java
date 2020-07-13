package com.cderian.petagram.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cderian.petagram.R;
import com.cderian.petagram.adapter.PetAdapter;
import com.cderian.petagram.pojo.Mascota;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    public HomeFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        listaMascotas = v.findViewById(R.id.allPetsView);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        listaMascotas.setLayoutManager(llm);
        inicializarMascotas();
        inicializarAdaptador();

        return  v;
    }

    public void inicializarMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(1, "Toby", R.drawable.perro1));
        mascotas.add(new Mascota(2, "Rex", R.drawable.perro2));
        mascotas.add(new Mascota(3, "Max", R.drawable.perro3));
        mascotas.add(new Mascota(4, "Bones", R.drawable.perro4));
        mascotas.add(new Mascota(5, "Zeus", R.drawable.perro5));
        mascotas.add(new Mascota(6, "Besheen", R.drawable.perro6));
        mascotas.add(new Mascota(7, "Negro", R.drawable.perro7));
        mascotas.add(new Mascota(8, "Golfo", R.drawable.perro8));
        mascotas.add(new Mascota(9, "Rawi", R.drawable.perro9));
    }

    public void inicializarAdaptador() {
        PetAdapter petAdapter = new PetAdapter(mascotas, getActivity());
        listaMascotas.setAdapter(petAdapter);
    }
}