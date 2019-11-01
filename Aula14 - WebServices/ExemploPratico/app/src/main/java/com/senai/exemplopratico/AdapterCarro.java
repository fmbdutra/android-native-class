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
        this.lista = listaCarro;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        // select count(1) from Pessoas;
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        // select * from Pessoas where id_pessoa = 1;
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
     // aqui e a ligacao entre carro e o item_carro
        Carro carro = lista.get(i);
        view = activity.getLayoutInflater().inflate(R.layout.item_carro, viewGroup, false);
        TextView nomeCarro = view.findViewById(R.id.textViewNomeCarro);
        TextView placacarro = view.findViewById(R.id.textViewPlacaCarro);

        nomeCarro.setText(carro.nome);
        placacarro.setText(carro.placa);

        return view;
    }
}
