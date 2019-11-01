package com.senai.exemplopratico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.LENGTH_SHORT;
import static com.senai.exemplopratico.R.string.erro_ws;

public class MeuNomeWSActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meu_nome_ws);

        ClientHttp clientHttp = new ClientHttp();

        try {
            String ret = clientHttp.executeOnExecutor(Executors.newSingleThreadExecutor(),
                new String[]{"http://10.200.117.116:8081/meu_nome"}).get();

            TextView meuNomeLabel = findViewById(R.id.meu_nome_aqui);

            meuNomeLabel.setText(ret);

        } catch (ExecutionException e)  { //Exceção caso não conecte no servidor
            e.printStackTrace();
            Toast.makeText(this, erro_ws, LENGTH_LONG).show();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Toast.makeText(this, erro_ws, LENGTH_LONG).show();
        }


    }

}
