package com.senai.exemplopratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class CadastroCarroActivity extends AppCompatActivity {

    ArrayList<String> listaMarcaCarro = new ArrayList<String>();
    ArrayList<String> coresCarro = new ArrayList<String>();
    ArrayList<Carro> listaCarrosCadastrados = new ArrayList<Carro>();


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
        // aqui fica o codigo quando clicar no botao de adicao de cor
        Intent activeFilha = new Intent(this,CadastraCorActivity.class);
        startActivityForResult(activeFilha,1);
    }

    protected  void onActivityResult(int requestCod,int resultCode,Intent intent){
        // aqui eu pego as informacoes das minhas active filhas.

        // active cadastraCorActivity
        if(requestCod==1 && resultCode == 1){
            String cor = intent.getExtras().getString("cor");
            coresCarro.add(cor);
            atualizaSpinnerCor();
        }
    }

    public void salvar(View view){
        EditText nomeCarro = findViewById(R.id.editTextNomeCarro);
        Spinner marcaCarro = findViewById(R.id.spinnerMarcaCarro);
        EditText placaCarro = findViewById(R.id.editTextPlacaCarro);
        Spinner corCarro = findViewById(R.id.spinnerCorCarro);

        if(nomeCarro.getText().toString().equals("")
                && !marcaCarro.isSelected()
                && placaCarro.getText().toString().equals("")
                && !corCarro.isSelected()
        ){
            Toast.makeText(getApplicationContext(),R.string.preenchaCampos,Toast.LENGTH_LONG).show();
            return;
        }else{

            Carro c = new Carro();
            c.setNome(nomeCarro.toString());
            c.setMarca((String) marcaCarro.getSelectedItem());
            c.setPlaca(placaCarro.getText().toString());
            c.setCor((String) corCarro.getSelectedItem());


            listaCarrosCadastrados.add(c);

            //Limpeza da Tela
            nomeCarro.setText(null);
            marcaCarro.setSelection(0);
            corCarro.setSelection(0);
            placaCarro.setText(null);

            //Mensagem de Sucesso
            Toast.makeText(getApplicationContext(),R.string.salvouSucesso,Toast.LENGTH_SHORT).show();

        }


    }
}
