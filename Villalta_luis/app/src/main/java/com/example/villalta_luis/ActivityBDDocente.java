package com.example.villalta_luis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.villalta_luis.R;
import com.example.villalta_luis.adapter.DocenteAdapter;
import com.example.villalta_luis.helper.HelperBDDocente;
import com.example.villalta_luis.modelos.Docente;

import java.util.List;

public class ActivityBDDocente extends AppCompatActivity implements View.OnClickListener {
    EditText cajaCedula, cajaApellidos, cajaNombres;
    Button btnGuardar, btnModificar, btnEliminar, btnEliminarTodos, btnBuscar, btnBuscarTodos;
    TextView datos;
    HelperBDDocente helper;
    List<Docente> lista;
    RecyclerView recyclerView;
    DocenteAdapter docenteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_d_docente);
        cargarComponentes();

        helper = new HelperBDDocente(this, "bda1", null, 1);
        cargarLista();

    }
    private void cargarLista(){
        //cargar el recyclerView
        lista = helper.getAllDocentes();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        docenteAdapter = new DocenteAdapter(lista);
        recyclerView.setAdapter(docenteAdapter);
    }

    private void cargarComponentes(){
        cajaCedula = findViewById(R.id.txtCedulaDBHelper);
        cajaApellidos = findViewById(R.id.txtApellidosDBHelper);
        cajaNombres = findViewById(R.id.txtNombresDBHelper);
        btnGuardar = findViewById(R.id.btnGuardarDBHelper);
        btnModificar = findViewById(R.id.btnModificarDBHelper);
        btnEliminar = findViewById(R.id.btnEliminarCedulaDBHelper);
        btnEliminarTodos = findViewById(R.id.btnEliminarTodosDBHelper);
        btnBuscar = findViewById(R.id.btnBuscarCedulaDBHelper);
        btnBuscarTodos = findViewById(R.id.btnBuscarTodosDBHelper);
        datos = findViewById(R.id.lblDatosHelper);

        recyclerView = findViewById(R.id.recyclerDocente);

        btnGuardar.setOnClickListener(this);
        btnModificar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnEliminarTodos.setOnClickListener(this);
        btnBuscar.setOnClickListener(this);
        btnBuscarTodos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Docente docente;
        switch (v.getId()) {
            case R.id.btnGuardarDBHelper:
                docente = new Docente(cajaCedula.getText().toString(),
                        cajaApellidos.getText().toString(),
                        cajaNombres.getText().toString());
                helper.insertar(docente);
                cajaCedula.setText("");
                cajaApellidos.setText("");
                cajaNombres.setText("");
                cargarLista();
                break;
            case R.id.btnModificarDBHelper:
                docente = new Docente(cajaCedula.getText().toString(),
                        cajaApellidos.getText().toString(),
                        cajaNombres.getText().toString());
                helper.update(docente);
                break;
            case R.id.btnEliminarCedulaDBHelper:
                helper.eliminarCedula(cajaCedula.getText().toString());
                break;
            case R.id.btnEliminarTodosDBHelper:
                datos.setText("");
                helper.eliminarTodos();
                break;
            case R.id.btnBuscarCedulaDBHelper:
                datos.setText("");
                datos.setText(helper.leerCedula(cajaCedula.getText().toString()));
                break;
            case R.id.btnBuscarTodosDBHelper:
                datos.setText(helper.leerTodos());
                break;
        }
    }
}