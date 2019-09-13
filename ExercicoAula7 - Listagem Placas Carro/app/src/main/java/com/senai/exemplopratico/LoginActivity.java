package com.senai.exemplopratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(R.string.login);
    }


    public void login(View view) {

        TextView usuario = findViewById(R.id.editTextNome);
        TextView senha = findViewById(R.id.editTextSenha);

        if (usuario.getText().toString().equals("admin") &&
                senha.getText().toString().equals("123")
        ) {
            // abrir nova active de cadastro do carro
            Bundle sacola = new Bundle();
            sacola.putString("usuario_logado","admin");
            Intent activityCadastroCarro =
            new Intent(this,CadastroCarroActivity.class);
            activityCadastroCarro.putExtras(sacola);
            startActivity(activityCadastroCarro);

        }else{
            Toast.makeText(this,R.string.usario_senha_invalido,Toast.LENGTH_LONG).show();
        }

    }
}
