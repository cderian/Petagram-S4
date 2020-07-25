package com.cderian.petagram.presenter;

import android.content.Context;

import com.cderian.petagram.database.ConstructorMascotas;
import com.cderian.petagram.vista.IPetListView;
import com.cderian.petagram.pojo.Mascota;

import java.util.ArrayList;

public class HomeFragmentPresenter implements IPetsPresenter {

    private IPetListView iPetListView;
    private Context context;
    private ConstructorMascotas constructor;
    private ArrayList<Mascota> mascotas;

    public HomeFragmentPresenter (IPetListView iPetListView, Context context) {
        this.iPetListView = iPetListView;
        this.context = context;
        obtenerMascotasBDD();
    }

    @Override
    public void obtenerMascotasBDD() {
        constructor = new ConstructorMascotas(this.context);
        mascotas = constructor.obtenerDatos();
        mostrarMascotas();
    }

    @Override
    public void mostrarMascotas() {
        iPetListView.inicializarAdaptador(iPetListView.crearAdaptador(mascotas));
        iPetListView.generarLayout();
    }
}
