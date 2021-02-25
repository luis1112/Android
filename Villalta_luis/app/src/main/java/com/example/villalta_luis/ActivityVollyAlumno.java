package com.example.villalta_luis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.villalta_luis.R;
import com.example.villalta_luis.controlador.swvolley.ServicioWebVolly;
import com.example.villalta_luis.modelos.Alumno;

public class ActivityVollyAlumno extends AppCompatActivity implements View.OnClickListener {
        EditText cajaId, cajaNombre, cajaDireccion;
        Button btnGuardar, btnBuscarTodos;
        TextView datos;
        RecyclerView recyclerViewAlumno;
        ServicioWebVolly servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volly_alumno);
        cargarComponentes();
    }

    public void cargarComponentes(){
        cajaId=findViewById(R.id.txtIdAlumnoVolly);
        cajaNombre=findViewById(R.id.txtNombreAlumnoVolly);
        cajaDireccion=findViewById(R.id.txtDireccionAlumnoVolly);
        datos = findViewById(R.id.lblDatosAlumnoVolly);
        btnGuardar=findViewById(R.id.btnInsetarAlumnoVolly);
        btnBuscarTodos=findViewById(R.id.btnBuscarTodosAlumnoVolly);
        recyclerViewAlumno = findViewById(R.id.recyclerAlumnoVolly);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInsetarAlumnoVolly:
                Alumno alumno = new Alumno();
                alumno.setIdAlumno(Integer.parseInt(cajaId.getText().toString()));
                alumno.setNombre(cajaNombre.getText().toString());
                alumno.setDireccion(cajaDireccion.getText().toString());
                boolean estado = servicio.insertar(alumno);
                if (estado){
                    Toast.makeText(this, "Alumno Registrado", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Alumno No Registrado", Toast.LENGTH_SHORT).show();
                }
                break;
            case  R.id.btnBuscarTodosAlumnoVolly:

                break;
        }
    }
}