package com.senai.exemplopratico;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCarro extends BaseAdapter {
    ArrayList<Carro> lista;
    Activity activity;

    public AdapterCarro(ArrayList<Carro> listaCarro, Activity activity){
        lista = listaCarro;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Carro c = lista.get(i);
        view = activity.getLayoutInflater().inflate(R.layout.item_carro , viewGroup, false);
        TextView nomeCarro = view.findViewById(R.id.textViewNomeCarro);
        TextView placaCarro = view.findViewById(R.id.textViewPlacaCarro);

        nomeCarro.setText(c.getNome());
        placaCarro.setText(c.getPlaca());

        return view;
    }


}
