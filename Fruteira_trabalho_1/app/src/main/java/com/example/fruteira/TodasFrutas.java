package com.example.fruteira;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TodasFrutas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todas_frutas);
        setTitle("Lista de Frutas");

        ArrayList<Frutas> todasFrutas = (ArrayList<Frutas>) getIntent().getExtras().getSerializable("frutas");

        StringBuilder lf = new StringBuilder();

        for(int v = 0; v < todasFrutas.size(); v++){
            lf.append(todasFrutas.get(v).getNome()).append(" - R$").append(todasFrutas.get(v).getPreco()).append(" - ").append(todasFrutas.get(v).getMes()).append("\n");
        }

        TextView mostrarFrutas = findViewById(R.id.verFrutas);
        mostrarFrutas.setText(lf.toString());
    }
}
