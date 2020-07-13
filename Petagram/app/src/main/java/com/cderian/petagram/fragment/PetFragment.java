package com.cderian.petagram.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cderian.petagram.R;
import com.cderian.petagram.adapter.PetAdapter;
import com.cderian.petagram.pojo.Mascota;

import java.util.ArrayList;

public class PetFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Mascota> mascotas;
    private TextView textView;

    public PetFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pet, container, false);
        recyclerView = v.findViewById(R.id.photosPet);
        textView = v.findViewById(R.id.namePet);
        GridLayoutManager mglm=new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(mglm);

        initList();
        initAdapter();

        return v;
    }
    public void initList(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(1, "Rex", R.drawable.perro2));
        mascotas.add(new Mascota(1, "Rex", R.drawable.perro2));
        mascotas.add(new Mascota(1, "Rex", R.drawable.perro2));
        mascotas.add(new Mascota(1, "Rex", R.drawable.perro2));
        mascotas.add(new Mascota(1, "Rex", R.drawable.perro2));
        mascotas.add(new Mascota(1, "Rex", R.drawable.perro2));
        mascotas.add(new Mascota(1, "Rex", R.drawable.perro2));

        textView.setText(mascotas.get(1).getNombre());

    }
    public void initAdapter(){
        PetAdapter adaptador = new PetAdapter(mascotas, getActivity());
        recyclerView.setAdapter(adaptador);
    }
}