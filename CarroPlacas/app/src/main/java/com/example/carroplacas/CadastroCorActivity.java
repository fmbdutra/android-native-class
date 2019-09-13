package com.example.carroplacas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadastroCorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_cor);

        setTitle("Adicionar Cor");
    }

    public void salvarCor(View view){

        EditText novaCor = findViewById(R.id.corEditText);

        String retornoCor = novaCor.getText().toString();

        Intent activityPai = new Intent();
        activityPai.putExtra("corAdd", retornoCor);
        setResult(1, activityPai);
        finish();
    }
}
