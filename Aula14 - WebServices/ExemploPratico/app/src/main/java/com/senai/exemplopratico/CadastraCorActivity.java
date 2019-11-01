package com.senai.exemplopratico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadastraCorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_cor);
    }

    public void salvarCor(View view){
        // AQUI salva a nova cor, e fecha a active filha.
        EditText cor = findViewById(R.id.editTextCorCarro);
        Intent activePai = new Intent();
        activePai.putExtra("cor",cor.getText().toString());
        setResult(1,activePai);
        finish();
    }

    public void salvarMarca(View view){

        EditText marca = findViewById(R.id.editTextMarcaDoCarro);
        Intent activePai = new Intent();
        activePai.putExtra("marca",marca.getText().toString());
        setResult(2,activePai);
        finish();
    }
}
