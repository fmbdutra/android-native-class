package com.example.trabalhoJogos;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class AdapterJogos extends BaseAdapter {

    ArrayList<Jogo> lista;
    Activity activity;

    public AdapterJogos(ArrayList<Jogo> listaJogos, Activity activity){
        lista = listaJogos;
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
        Jogo j = lista.get(i);
        view = activity.getLayoutInflater().inflate(R.layout.item_jogo , viewGroup, false);
        TextView nomeJogo = view.findViewById(R.id.textViewNomeJogo);
        TextView categoriaJogo = view.findViewById(R.id.textViewCategoriaJogo);

        nomeJogo.setText(j.getNome());
        categoriaJogo.setText(j.getCategoria());

        return view;
    }
}
