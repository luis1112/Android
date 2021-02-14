package com.example.villalta_luis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        EditText cajaNombres = findViewById(R.id.txtNombres);
        EditText cajaApellidos = findViewById(R.id.txtApellidos);

        Button boton = findViewById(R.id.btnIngresar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityNombres.class);
                Bundle bundle = new Bundle();
                bundle.putString("nombre", cajaNombres.getText().toString());
                bundle.putString("apellido", cajaApellidos.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}