package com.senai.exemplopratico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetalheCarroActivity extends AppCompatActivity {
    // variaveis de classe
    BancoDados bancoDados ;
    Carro carro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_carro);
         carro = (Carro)getIntent().getExtras().get("carro");

        TextView nomeCarro = findViewById(R.id.textViewNomeCarro);
        TextView corCarro = findViewById(R.id.textViewCorCarro);
        TextView marcaCarro = findViewById(R.id.textViewMarcaCarro);
        TextView placaCarro = findViewById(R.id.textViewPlacaCarro);

        nomeCarro.setText(carro.nome);
        corCarro.setText(carro.cor);
        marcaCarro.setText(carro.marca);
        placaCarro.setText(carro.placa);

        bancoDados = new BancoDados(this);

    }

    public void deletarCarro(View view) {

        bancoDados.deletaCarro(carro.id);
        finish();
    }
}
