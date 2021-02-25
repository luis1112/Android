package com.example.villalta_luis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.villalta_luis.R;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ActividadMemoriaSD extends AppCompatActivity implements View.OnClickListener {
    EditText cajaCedula, cajaApellidos, cajaaNombres;
    Button botonLeer, botonEscribir;
    TextView datos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_memoria_s_d);
        cajaCedula = findViewById(R.id.txtCedulaMI);
        cajaApellidos = findViewById(R.id.txtApellidos);
        cajaaNombres = findViewById(R.id.txtNombresMI);
        botonEscribir = findViewById(R.id.btnEscribirMI);
        botonLeer = findViewById(R.id.btnLeerMI);
        datos = findViewById(R.id.lblDatosMI);
        botonEscribir.setOnClickListener(this);
        botonLeer.setOnClickListener(this);
    }

    @Override
    public void onClick(@NotNull View view) {
        switch (view.getId()) {
            case R.id.btnEscribirMI:
                try {
                    OutputStreamWriter escritor = new OutputStreamWriter(new FileOutputStream("archivo.txt"));
                    /*escritor.write(cajaCedula.getText().toString() + " " +
                            cajaApellidos.getText().toString() + " " +
                            cajaaNombres.getText().toString() + "\n");*/
                    escritor.write("datoss");
                    escritor.close();
                } catch (Exception ex) {
                    Log.e("Error de escritura", ex.getMessage());
                }
                break;
            case R.id.btnLeerMI:
                try {
                    BufferedReader lector = new BufferedReader(new InputStreamReader(openFileInput("archivo.txt")));
                    String informacion = lector.readLine();
                    datos.setText(informacion);
                    lector.close();
                } catch (Exception e) {
                    Log.e("Error de Lectura", e.getMessage());
                }
                break;
        }
    }

}