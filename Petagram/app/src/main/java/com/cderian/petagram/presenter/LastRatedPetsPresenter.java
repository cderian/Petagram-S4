package com.cderian.petagram.presenter;

import android.content.Context;

import com.cderian.petagram.database.ConstructorMascotas;
import com.cderian.petagram.pojo.Mascota;
import com.cderian.petagram.vista.IPetListView;

import java.util.ArrayList;

public class LastRatedPetsPresenter implements IPetsPresenter {

    private IPetListView iPetListView;
    private Context context;
    private ConstructorMascotas constructor;
    private ArrayList<Mascota> mascotas;

    public LastRatedPetsPresenter (IPetListView iPetListView, Context context) {
        this.iPetListView = iPetListView;
        this.context = context;
        obtenerMascotasBDD();
    }

    @Override
    public void obtenerMascotasBDD() {
        constructor = new ConstructorMascotas(this.context);
        mascotas = constructor.obtenerTopMascotas();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iPetListView.inicializarAdaptador(iPetListView.crearAdaptador(mascotas));
        iPetListView.generarLayout();
    }
}
