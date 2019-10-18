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
    ArrayList<Carro> listaCarroCadastrados = new ArrayList<>();
    BancoDados bancoDados ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_carro);

        // criando o banco de dados
        bancoDados = new BancoDados(this);

        // busca os parametros passados
        String usuario = (String)
                    getIntent().getExtras().get("usuario_logado");
        setTitle("Seja bem vindo: " + usuario);

//        popular lista
//        listaMarcaCarro.add("VW");
//        listaMarcaCarro.add("Ford");
//        listaMarcaCarro.add("Fiat");
//        listaMarcaCarro.add("GM");

        listaMarcaCarro.addAll(bancoDados.marcas());

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
            //coresCarro.add(cor);
            long id = bancoDados.cadastrarCor(cor);
            if(id > 0){
                Toast.makeText(this,"Cadastro realizado com sucesso",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"Erro no cadastro da cor",Toast.LENGTH_LONG).show();
            }
            atualizaSpinnerCor();
        }
        if(requestCod==1 && resultCode == 2){
            String marca = intent.getExtras().getString("marca");
            Toast.makeText(this,R.string.sucesso,Toast.LENGTH_SHORT).show();
        }
    }

    public void salvar(View view) {
        EditText nomeCarro = findViewById(R.id.editTextNomeCarro);
        Spinner marca = findViewById(R.id.spinnerMarcaCarro);
        EditText placa = findViewById(R.id.editTextPlacaCarro);
        Spinner cor = findViewById(R.id.spinnerCorCarro);

        // criando o objeto carro
        Carro carro = new Carro();
        carro.nome = nomeCarro.getText().toString();
        carro.marca = marca.getSelectedItem().toString();
        carro.placa = placa.getText().toString();
        carro.cor = cor.getSelectedItem().toString();

        // inserindo na lista
        //listaCarroCadastrados.add(carro);
        // inserindo no banco
        long id = bancoDados.cadastrarCarro(carro);
        if(id > 0){
            Toast.makeText(this,"Cadastro realizado com sucesso",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"Erro no cadastro do carro",Toast.LENGTH_LONG).show();
        }

        // limpeza da tela.
        nomeCarro.setText(null);
        marca.setSelection(0);
        placa.setText(null);
        cor.setSelection(0);

        // mensagem de sucesso
        Toast.makeText(this,R.string.sucesso, Toast.LENGTH_SHORT).show();

    }

    public void listagem(View view) {
        Intent intent = new Intent(this,ListagemCarroActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("lista",listaCarroCadastrados);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
