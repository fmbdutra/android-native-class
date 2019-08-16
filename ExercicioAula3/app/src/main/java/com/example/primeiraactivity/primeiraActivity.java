package com.example.primeiraactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class primeiraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primeira);
    }

    public void abreSegunda(View view) {
        Intent i = new Intent(this,segundaActivity.class);
        startActivity(i);
    }
}
