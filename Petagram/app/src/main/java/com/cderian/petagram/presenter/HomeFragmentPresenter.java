package com.cderian.petagram.presenter;

import android.content.Context;

import com.cderian.petagram.database.ConstructorMascotas;
import com.cderian.petagram.fragment.IHomeFragmentView;
import com.cderian.petagram.pojo.Mascota;

import java.util.ArrayList;

public class HomeFragmentPresenter implements IHomeFragmentPresenter {

    private IHomeFragmentView iHomeFragmentView;
    private Context context;
    private ConstructorMascotas constructor;
    private ArrayList<Mascota> mascotas;

    public HomeFragmentPresenter (IHomeFragmentView iHomeFragmentView, Context context) {
        this.iHomeFragmentView = iHomeFragmentView;
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
        iHomeFragmentView.inicializarAdaptador(iHomeFragmentView.crearAdaptador(mascotas));
        iHomeFragmentView.generarLinearLayoutVertical();

    }
}
