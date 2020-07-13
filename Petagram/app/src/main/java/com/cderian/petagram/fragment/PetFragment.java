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
import com.cderian.petagram.adapter.PetFragmentAdapter;
import com.cderian.petagram.pojo.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class PetFragment extends Fragment {

    private CircularImageView imagePet;
    private RecyclerView photosPet;
    private ArrayList<Mascota> mascotas;
    private TextView namePet;

    public PetFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pet, container, false);
        imagePet = v.findViewById(R.id.imagePet);
        namePet = v.findViewById(R.id.namePet);
        photosPet = v.findViewById(R.id.photosPet);

        GridLayoutManager mglm=new GridLayoutManager(getContext(),3);
        photosPet.setLayoutManager(mglm);

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
        mascotas.add(new Mascota(1, "Rex", R.drawable.perro2));
        mascotas.add(new Mascota(1, "Rex", R.drawable.perro2));

        imagePet.setImageResource(mascotas.get(1).getFoto());
        namePet.setText(mascotas.get(1).getNombre());

    }
    public void initAdapter(){
        PetFragmentAdapter adaptador = new PetFragmentAdapter(mascotas, getActivity());
        photosPet.setAdapter(adaptador);
    }
}