package com.example.trabalhoJogos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListagemJogosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_jogos);

        setTitle("Lista de Jogos");

        ArrayList<Jogo> listaJogos = (ArrayList) getIntent().getExtras().get("lista");

        AdapterJogos a = new AdapterJogos(listaJogos, this);

        ListView l = findViewById(R.id.ListViewListagemJogos);
        l.setAdapter(a);

    }
}
