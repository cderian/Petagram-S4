package com.cderian.petagram.vista;

import com.cderian.petagram.adapter.PetAdapter;
import com.cderian.petagram.pojo.Mascota;

import java.util.ArrayList;

public interface IPetListView {

    public void generarLayout();
    public PetAdapter crearAdaptador (ArrayList<Mascota> contactos);
    public void inicializarAdaptador (PetAdapter adaptador);

}
