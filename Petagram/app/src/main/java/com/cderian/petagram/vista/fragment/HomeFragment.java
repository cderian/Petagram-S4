package com.cderian.petagram.vista.fragment;

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
import com.cderian.petagram.presenter.HomeFragmentPresenter;
import com.cderian.petagram.presenter.IPetsPresenter;
import com.cderian.petagram.vista.IPetListView;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements IPetListView {

    private RecyclerView rvMascotas;
    private IPetsPresenter presenter;
    ArrayList<Mascota> mascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rvMascotas = v.findViewById(R.id.allPetsView);
        presenter = new HomeFragmentPresenter(this, getContext());

        return  v;
    }

    @Override
    public void generarLayout() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvMascotas.setLayoutManager(llm);
    }

    @Override
    public PetAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        PetAdapter petAdapter = new PetAdapter(mascotas, getActivity());
        return petAdapter;
    }

    @Override
    public void inicializarAdaptador(PetAdapter adaptador) {
        rvMascotas.setAdapter(adaptador);
    }
}