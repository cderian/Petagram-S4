package com.cderian.petagram.fragment;

import com.cderian.petagram.adapter.PetAdapter;
import com.cderian.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IHomeFragmentView {

    public void generarLinearLayoutVertical ();
    public PetAdapter crearAdaptador (ArrayList<Mascota> contactos);
    public void inicializarAdaptador (PetAdapter adaptador);

}
