package com.senai.exemplopratico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ListagemCarroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem_carro);

        ArrayList<Carro> listaCarro = (ArrayList<Carro>) getIntent().getExtras().get("lista");

        AdapterCarro adapterCarro = new AdapterCarro(listaCarro,this);
        ListView listView = findViewById(R.id.listViewListagemCarro);
        listView.setAdapter(adapterCarro);
        listView.setOnItemClickListener(new
                DetalhesCarroClickListener(listaCarro,this));



    }
}
