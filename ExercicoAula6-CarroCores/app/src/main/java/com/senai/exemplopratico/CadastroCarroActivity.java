package com.senai.exemplopratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class CadastroCarroActivity extends AppCompatActivity {

    ArrayList<String> listaMarcaCarro = new ArrayList<String>();
    ArrayList<String> coresCarro = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_carro);

        // busca os parametros passados
        String usuario = (String)
                    getIntent().getExtras().get("usuario_logado");
        setTitle("Seja bem vindo: " + usuario);

        // popular lista
        listaMarcaCarro.add("VW");
        listaMarcaCarro.add("Ford");
        listaMarcaCarro.add("Fiat");
        listaMarcaCarro.add("GM");

        coresCarro.add("vermelha");
        coresCarro.add("azul");
        coresCarro.add("prata");
        coresCarro.add("preto");

        atualizaSpinnerMarcas();
        atualizaSpinnerCor();

    }

    private  void atualizaSpinnerCor(){
        // busca spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinnerCorCarro);
        // cria um adaptador, vinculando o que tem na memoria com o componente.
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item,
                        coresCarro);

        spinner.setAdapter(arrayAdapter);
    }

    private  void atualizaSpinnerMarcas(){
        // busca spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinnerMarcaCarro);
        // cria um adaptador, vinculando o que tem na memoria com o componente.
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listaMarcaCarro);

        spinner.setAdapter(arrayAdapter);
    }

    public void cadastraCor(View view){
        Intent activeFilha = new Intent(this, CadastroCorActivity.class);
        startActivityForResult(activeFilha, 1);
    }

    public void onActivityResult(int requestCod, int resultCode, Intent intent){
        if(requestCod==1 && resultCode == 1){
            String cor = intent.getExtras().getString("corAdd");
            coresCarro.add(cor);
            atualizaSpinnerCor();
        }
    }

}
