package com.senai.exemplopratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    // variavel de classe
    BancoDados bancoDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(R.string.login);
        bancoDados = new BancoDados(this);
    }


    public void login(View view) {

        TextView usuario = findViewById(R.id.editTextNOme);
        TextView senha = findViewById(R.id.editTextSenha);

        Usuario user = bancoDados.login(usuario.getText().toString(),
                senha.getText().toString());
        if ( user != null  ) {
            // abrir nova active de cadastro do carro
            Bundle sacola = new Bundle();
            sacola.putString("usuario_logado",usuario.getText().toString());
            Intent activityCadastroCarro =
            new Intent(this,CadastroCarroActivity.class);
            activityCadastroCarro.putExtras(sacola);
            startActivity(activityCadastroCarro);

        }else{
            Toast.makeText(this,R.string.usario_senha_invalido,Toast.LENGTH_LONG).show();
        }

    }
}
