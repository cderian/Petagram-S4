package com.cderian.petagram.presenter;

import android.content.Context;

import com.cderian.petagram.database.ConstructorMascotas;
import com.cderian.petagram.vista.IPetListView;
import com.cderian.petagram.pojo.Mascota;

import java.util.ArrayList;

public class HomeFragmentPresenter implements IHomeFragmentPresenter {

    private IPetListView iPetListView;
    private Context context;
    private ConstructorMascotas constructor;
    private ArrayList<Mascota> mascotas;

    public HomeFragmentPresenter (IPetListView iHomeFragmentView, Context context) {
        this.iPetListView = iHomeFragmentView;
        this.context = context;
        obtenerMascotasBDD();
    }

    @Override
    public void obtenerMascotasBDD() {
        constructor = new ConstructorMascotas(this.context);
        mascotas = constructor.obtenerDatos();
        mostrarContactos();
    }

    @Override
    public void mostrarContactos() {
        iPetListView.inicializarAdaptador(iPetListView.crearAdaptador(mascotas));
        iPetListView.generarLinearLayoutVertical();

    }
}
