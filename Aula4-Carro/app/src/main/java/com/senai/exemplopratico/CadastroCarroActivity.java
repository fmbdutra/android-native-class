package com.senai.exemplopratico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class CadastroCarroActivity extends AppCompatActivity {


    ArrayList<String> listaMarca = new ArrayList<String>();
    ArrayList<String> coresCarro = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_carro);

        //Popular Lista
        listaMarca.add("VW");
        listaMarca.add("Ford");
        listaMarca.add("GM");
        listaMarca.add("Nissan");
        listaMarca.add("Cherry");
        listaMarca.add("Lifan");
        listaMarca.add("Outro");

        coresCarro.add("Azul");
        coresCarro.add("Prata");
        coresCarro.add("Preto");
        coresCarro.add("Champagne");
        coresCarro.add("Branco");
        coresCarro.add("Outra");

        atualizaSpinnerMarca();
        atualizaSpinnerCor();
    }

    private void atualizaSpinnerMarca(){
        Spinner s = (Spinner) findViewById(R.id.spinnerMarcaCarro);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, listaMarca);

        s.setAdapter(arrayAdapter);
    }

    private void atualizaSpinnerCor(){
        Spinner s = (Spinner) findViewById(R.id.spinnerCorCarro);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, coresCarro);

        s.setAdapter(arrayAdapter);
    }




}
