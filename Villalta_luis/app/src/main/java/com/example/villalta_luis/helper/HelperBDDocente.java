package com.example.villalta_luis.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.villalta_luis.modelos.Docente;

import java.util.ArrayList;
import java.util.List;

public class HelperBDDocente extends SQLiteOpenHelper {

    public HelperBDDocente(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE docente (id INTEGER PRIMARY KEY AUTOINCREMENT, cedula TEXT, apellidos TEXT, nombres TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertar(Docente docente) {
        ContentValues valores = new ContentValues();
        valores.put("cedula", docente.getCedula());
        valores.put("apellidos", docente.getApellidos());
        valores.put("nombres", docente.getNombres());
        this.getWritableDatabase().insert("docente", null, valores);
    }

    public void update(Docente docente) {
        ContentValues valores = new ContentValues();
        valores.put("apellidos", docente.getApellidos());
        valores.put("nombres", docente.getNombres());
        this.getWritableDatabase().update("docente", valores, "cedula='" + docente.getCedula() + "'", null);
    }

    public void eliminarTodos() {
        this.getWritableDatabase().delete("docente", null, null);
    }

    public void eliminarCedula(String cedula) {
        this.getWritableDatabase().delete("docente", "cedula='" + cedula + "'", null);
    }

    public List<Docente> getAllDocentes() {
        List<Docente> lista = new ArrayList<>();
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM docente", null);
        if (cursor.moveToFirst()) {
            do {
                String cedula = cursor.getString(cursor.getColumnIndex("cedula"));
                String apellidos = cursor.getString(cursor.getColumnIndex("apellidos"));
                String nombres = cursor.getString(cursor.getColumnIndex("nombres"));
                Docente docente = new Docente(cedula, apellidos, nombres);
                lista.add(docente);
            } while (cursor.moveToNext());
        }
        return lista;
    }

    public String leerTodos() {
        String consulta = "";
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM docente", null);
        if (cursor.moveToFirst()) {
            do {
                String cedula = cursor.getString(cursor.getColumnIndex("cedula"));
                String apellidos = cursor.getString(cursor.getColumnIndex("apellidos"));
                String nombres = cursor.getString(cursor.getColumnIndex("nombres"));
                consulta += cedula + " " + apellidos + " " + nombres + "\n";
            } while (cursor.moveToNext());
        }
        return consulta;
    }

    public String leerCedula(String ced) {
        String consulta = "";
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM docente WHERE cedula=''" + ced + "'", null);

        String cedula = cursor.getString(cursor.getColumnIndex("cedula"));
        String apellidos = cursor.getString(cursor.getColumnIndex("apellidos"));
        String nombres = cursor.getString(cursor.getColumnIndex("nombres"));
        consulta += cedula + " " + apellidos + " " + nombres;

        return consulta;
    }
}
