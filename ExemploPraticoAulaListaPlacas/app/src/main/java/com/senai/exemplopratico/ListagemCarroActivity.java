package com.senai.exemplopratico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListagemCarroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_carro);

        ArrayList<Carro> listaCarro = (ArrayList<Carro>) getIntent().getExtras().get("lista");

        Carro c2 = new Carro();
        c2.setNome("LAla");
        c2.setPlaca("BBB5555");
        listaCarro.add(c2);

        AdapterCarro a = new AdapterCarro(listaCarro, this);
        ListView l = findViewById(R.id.listViewListagemCarro);
        l.setAdapter(a);


    }
}
