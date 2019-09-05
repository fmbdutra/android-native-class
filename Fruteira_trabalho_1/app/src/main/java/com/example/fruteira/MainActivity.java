package com.example.fruteira;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.io.SerializablePermission;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> listaMesesColheita = new ArrayList<String>();
    private ArrayList<Frutas> listaFrutas = new ArrayList<Frutas>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Adicionar Fruta");

        //Popular Lista
        listaMesesColheita.add("Janeiro");
        listaMesesColheita.add("Fevereiro");
        listaMesesColheita.add("Março");
        listaMesesColheita.add("Abril");
        listaMesesColheita.add("Maio");
        listaMesesColheita.add("Junho");
        listaMesesColheita.add("Julho");
        listaMesesColheita.add("Agosto");
        listaMesesColheita.add("Setembro");
        listaMesesColheita.add("Outubro");
        listaMesesColheita.add("Novembro");
        listaMesesColheita.add("Dezembro");

        atualizaSpinnerMarca();
    }

    private void atualizaSpinnerMarca(){
        Spinner s = (Spinner) findViewById(R.id.spinnerMes);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, listaMesesColheita);

        s.setAdapter(arrayAdapter);
    }

    public void Salvar(View view){

        EditText editTextNome = findViewById(R.id.nome);
        EditText editTextPreco = findViewById(R.id.preco);
        Spinner spinnesMesColheita = findViewById(R.id.spinnerMes);

        if(editTextNome.getText().toString().equals("") && editTextPreco.getText().toString().equals("") && !spinnesMesColheita.isSelected()){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
            return;
        }

        else{
            Frutas fruta = new Frutas();
            fruta.setNome(editTextNome.getText().toString());
            fruta.setPreco(Double.parseDouble(editTextPreco.getText().toString()));
            fruta.setMes(spinnesMesColheita.getSelectedItem().toString());
            listaFrutas.add(fruta);

           Bundle bundle = new Bundle();
           bundle.putSerializable("frutas", listaFrutas);
           Intent intent;
            intent = new Intent(this, TodasFrutas.class);
            intent.putExtras(bundle);
           startActivity(intent);
        }

    }

}
