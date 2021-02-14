package com.example.villalta_luis;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Actividad_Fragmentos extends AppCompatActivity implements View.OnClickListener {

    Button botonFrgUno, botonFrgDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad__fragmentos);
        botonFrgUno = findViewById(R.id.btnFrgUno);
        botonFrgDos = findViewById(R.id.btnFrgDos);
        botonFrgUno.setOnClickListener(this);
        botonFrgDos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnFrgUno:
                FrgUno fragmentoUno = new FrgUno();
                FragmentTransaction transactionUno = getSupportFragmentManager().beginTransaction();
                transactionUno.replace(R.id.contenedor, fragmentoUno);
                transactionUno.commit();
                break;
            case R.id.btnFrgDos:
                FrgDos fragmentoDos = new FrgDos();
                FragmentTransaction transactionDos = getSupportFragmentManager().beginTransaction();
                transactionDos.replace(R.id.contenedor, fragmentoDos);
                transactionDos.commit();
                break;
        }
    }
}