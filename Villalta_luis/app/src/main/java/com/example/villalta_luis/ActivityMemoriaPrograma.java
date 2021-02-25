package com.example.villalta_luis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.villalta_luis.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ActivityMemoriaPrograma extends AppCompatActivity {
    Button boton;
    TextView datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoria_programa);
        datos = findViewById(R.id.lblDatosAP);
        boton = findViewById(R.id.btnLeerAP);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream input = getResources().openRawResource(R.raw.archiv_raw);
                    BufferedReader lector = new BufferedReader(new InputStreamReader(input));
                    String informacion = lector.readLine();
                    datos.setText(informacion.toString());
                    lector.close();
                }catch (Exception e){
                    Log.e("ERROR LECTURA", e.getMessage());
                }
            }
        });
    }
}