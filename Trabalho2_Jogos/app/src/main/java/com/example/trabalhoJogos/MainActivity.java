package com.example.trabalhoJogos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listaCategoriasJogos = new ArrayList<String>();
    ArrayList<Jogo> listaJogosCadastrados = new ArrayList<Jogo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Cadastro de Jogos");

        // popular lista
        listaCategoriasJogos.add("Aventura");
        listaCategoriasJogos.add("Ação");
        listaCategoriasJogos.add("RPG");
        listaCategoriasJogos.add("MMO");
        listaCategoriasJogos.add("Corrida");
        listaCategoriasJogos.add("Luta");
        listaCategoriasJogos.add("Tabuleiro");
        listaCategoriasJogos.add("Esporte");

        atualizarSpinnerCategorias();
    }

    private  void atualizarSpinnerCategorias(){
        // busca spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinnerCategorias);
        // cria um adaptador, vinculando o que tem na memoria com o componente.
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item,
                        listaCategoriasJogos);

        spinner.setAdapter(arrayAdapter);
    }

    public void salvar(View view) {
        EditText nomeJogo = findViewById(R.id.editTextNomeJogo);
        Spinner categoriaJogo = findViewById(R.id.spinnerCategorias);

        if (nomeJogo.getText().toString().equals("")
                && !categoriaJogo.isSelected()
        ) {
            Toast.makeText(getApplicationContext(), R.string.preenchaCampos, Toast.LENGTH_LONG).show();
            return;
        } else {

            Jogo j = new Jogo();
            j.setNome(nomeJogo.getText().toString());
            j.setCategoria((String) categoriaJogo.getSelectedItem());

            listaJogosCadastrados.add(j);

            //Limpeza da Tela
            nomeJogo.setText(null);
            categoriaJogo.setSelection(0);

            //Mensagem de Sucesso
            Toast.makeText(getApplicationContext(), R.string.salvouSucesso, Toast.LENGTH_SHORT).show();

        }
    }

    public void listagem(View view){
        Intent i = new Intent(this, ListagemJogosActivity.class);
        Bundle b = new Bundle();
        b.putSerializable("lista", listaJogosCadastrados);
        i.putExtras(b);
        startActivity(i);
    }

}
