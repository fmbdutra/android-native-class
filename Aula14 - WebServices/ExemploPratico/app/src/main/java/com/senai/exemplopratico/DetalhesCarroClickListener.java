package com.senai.exemplopratico;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;

public class DetalhesCarroClickListener
        implements AdapterView.OnItemClickListener {

    ArrayList<Carro> minhaLista;
    Activity activity;

    public DetalhesCarroClickListener(ArrayList<Carro> lista,
                                      Activity activity){
        minhaLista = lista;
        this.activity = activity;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView,
                            View view, int i, long l) {
        // aqui eu vou abrir um activity, com informacoes
        // detalhadas do carro.
        Carro carro = minhaLista.get(i);
        Intent intent = new Intent(activity,
                DetalheCarroActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("carro",carro);
        intent.putExtras(bundle);
        activity.startActivity(intent);

    }
}
