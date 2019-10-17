package com.senai.exemplopratico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetalheCarroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_carro);
        Carro carro = (Carro)getIntent().getExtras().get("carro");

        TextView nomeCarro = findViewById(R.id.textViewNomeCarro);
        TextView corCarro = findViewById(R.id.textViewCorCarro);
        TextView marcaCarro = findViewById(R.id.textViewMarcaCarro);
        TextView placaCarro = findViewById(R.id.textViewPlacaCarro);

        nomeCarro.setText(carro.nome);
        corCarro.setText(carro.cor);
        marcaCarro.setText(carro.marca);
        placaCarro.setText(carro.placa);

    }
}
