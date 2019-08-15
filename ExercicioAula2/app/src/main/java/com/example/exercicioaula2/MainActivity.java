package com.example.exercicioaula2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pessoa> listaPessoa = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void salvar(View view){

        EditText editTextNome = findViewById(R.id.nome);
        EditText editTextIdade = findViewById(R.id.idade);
        RadioButton radioButtonSolteiro = findViewById(R.id.radioButtonSolteiro);
        RadioButton radioButtonCasado = findViewById(R.id.radioButtonCasado);
        RadioButton radioButtonViuvo = findViewById(R.id.radioButtonViuvo);

        if(editTextNome.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),R.string.preencha_nome,Toast.LENGTH_LONG).show();;
            return;
        }

        if(editTextIdade.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), R.string.preencha_idade, Toast.LENGTH_LONG).show();
            return;
        }

        if(radioButtonCasado.isChecked() == false && radioButtonSolteiro.isChecked() == false && radioButtonViuvo.isChecked() == false){
            Toast.makeText(getApplicationContext(),R.string.preencha_estadoCivil,Toast.LENGTH_LONG).show();
            return;
        }


        Pessoa pessoa = new Pessoa();
        pessoa.setIdade(Integer.parseInt(editTextIdade.getText().toString()));
        pessoa.setNome(editTextNome.getText().toString());
        if(radioButtonSolteiro.isSelected()){
            pessoa.setSolteiro(true);
            if(radioButtonCasado.isSelected()){
                pessoa.setCasado(true);
            }
            else if(radioButtonSolteiro.isSelected()){
                pessoa.setSolteiro(true);
            }else{
                pessoa.setViuvo(true);
            }

            listaPessoa.add(pessoa);
            Toast.makeText(getApplicationContext(),"Pessoa salva com sucesso",Toast.LENGTH_LONG).show();;

            limpaTela();

        }
    }

    public void listar(View view ) {
        // buscando componente
        StringBuilder message = new StringBuilder();

        for(Pessoa pessoa : listaPessoa){
            message.append("Nome: " ).append(pessoa.getNome()).append("\n");
        }
        Toast.makeText(getApplicationContext(),message.toString(),Toast.LENGTH_LONG).show();;


    }

    public void limpaTela(){

        EditText editTextNome = findViewById(R.id.nome);
        EditText editTextIdade = findViewById(R.id.idade);
        RadioButton radioButtonSolteiro = findViewById(R.id.radioButtonSolteiro);
        RadioButton radioButtonCasado = findViewById(R.id.radioButtonCasado);
        RadioButton radioButtonViuvo = findViewById(R.id.radioButtonViuvo);

        editTextIdade.setText("");
        editTextNome.setText("");
        radioButtonCasado.setChecked(false);
        radioButtonSolteiro.setChecked(false);
        radioButtonViuvo.setChecked(false);
    }

}
