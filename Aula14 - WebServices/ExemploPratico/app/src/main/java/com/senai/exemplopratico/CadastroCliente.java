
package com.senai.exemplopratico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CadastroCliente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cliente);

    }


    public void salvarCliente(View view) {

        EditText nome = findViewById(R.id.nomeEditCliente);
        EditText endereco = findViewById(R.id.enderecoEditCliente);
        EditText dataNasc = findViewById(R.id.nascEditCliente);

        StringBuilder endPoint = new StringBuilder();
        endPoint.append("http://10.200.119.113:8081/salvarCliente?");
        endPoint.append("nome=");
        endPoint.append((nome.getText().toString()));
        endPoint.append("&");
        endPoint.append("endereco=");
        endPoint.append((endereco.getText().toString()));
        endPoint.append("&");
        endPoint.append("dataNascimento=");
        endPoint.append((dataNasc.getText().toString()));

        ClientHttp clientHttp = new ClientHttp();

        try {
            String ret = clientHttp.executeOnExecutor(Executors.newSingleThreadExecutor(),
                    new String[]{endPoint.toString()}).get();

            nome.setText("");
            endereco.setText("");
            dataNasc.setText("");
            Toast.makeText(this, R.string.sucesso, Toast.LENGTH_LONG).show();


        } catch (ExecutionException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.erro_ws, Toast.LENGTH_LONG).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Toast.makeText(this, R.string.erro_ws, Toast.LENGTH_LONG).show();
        }

    }

}

