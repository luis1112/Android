package com.example.villalta_luis;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.villalta_luis.R;
import com.example.villalta_luis.ui.login.ActivityLogin;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.opcionLogin:
                intent = new Intent(MainActivity.this, ActivityLogin.class);
                startActivity(intent);
                break;
            case R.id.opcionFragmentos:
                intent = new Intent(MainActivity.this, ActividadFragmentos.class);
                startActivity(intent);
                break;
            case R.id.opcionDialogo:
                Dialog dialogoLogin = new Dialog(MainActivity.this);
                dialogoLogin.setContentView(R.layout.dlg_login);
                EditText cajaUsuario = dialogoLogin.findViewById(R.id.txtUsuarioDlg);
                EditText cajaClave = dialogoLogin.findViewById(R.id.txtClaveDlg);
                Button btnDlg = dialogoLogin.findViewById(R.id.btnIngresarDlg);
                btnDlg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this,
                                cajaUsuario.getText().toString() + " "
                                        + cajaClave.getText().toString(), Toast.LENGTH_LONG).show();
                    }
                });
                dialogoLogin.show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}