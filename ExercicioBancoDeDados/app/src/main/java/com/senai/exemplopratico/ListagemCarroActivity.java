package com.senai.exemplopratico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ListagemCarroActivity extends AppCompatActivity {

    private BancoDados banco = new BancoDados(this);
    private ArrayList<Carro> listaCarro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_carro);

        listaCarro = (ArrayList<Carro>) getIntent().getExtras().get("lista");

        AdapterCarro adapterCarro = new AdapterCarro(listaCarro,this);
        ListView listView = findViewById(R.id.listViewListagemCarro);
        listView.setAdapter(adapterCarro);
        listView.setOnItemClickListener(new
                DetalhesCarroClickListener(listaCarro,this));
    }

    @Override
    protected void onResume() {
        super.onResume();

        listaCarro = banco.retornaCarros();

        AdapterCarro adapterCarro = new AdapterCarro(listaCarro,this);
        ListView listView = findViewById(R.id.listViewListagemCarro);
        listView.setAdapter(adapterCarro);
        listView.setOnItemClickListener(new
                DetalhesCarroClickListener(listaCarro,this));
    }
}
