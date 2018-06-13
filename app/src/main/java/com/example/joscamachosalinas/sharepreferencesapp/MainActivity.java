package com.example.joscamachosalinas.sharepreferencesapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etRut;
    private EditText etNombre;
    private EditText etCorreo;
    private Button btnLeer;
    private Button btnGuardar;
    private Button btnBorrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referenciar
        etRut = (EditText) findViewById(R.id.etRut);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        btnLeer = (Button) findViewById(R.id.btnLeer);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);

        btnLeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leerSharedPreferences();
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarSharedPreferences();
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                borrarSharedPreferences();
            }
        });


    }
    private void leerSharedPreferences() {
        SharedPreferences preferencias = getSharedPreferences("datosPersonales", Context.MODE_PRIVATE);
        etRut.setText(preferencias.getString("rut",""));
        etNombre.setText(preferencias.getString("nombre",""));
        etCorreo.setText(preferencias.getString("correo",""));
    }

    private void guardarSharedPreferences(){
        SharedPreferences preferencias = getSharedPreferences("datosPersonales", Context.MODE_PRIVATE   );
        SharedPreferences.Editor editarPreferencias = preferencias.edit();
        editarPreferencias.putString("rut",etRut.getText().toString());
        editarPreferencias.putString("nombre",etNombre.getText().toString());
        editarPreferencias.putString("correo",etCorreo.getText().toString());
        editarPreferencias.commit();
    }

    private void borrarSharedPreferences(){
        SharedPreferences preferencias = getSharedPreferences("datosPersonales", Context.MODE_PRIVATE   );
        SharedPreferences.Editor editarPreferencias = preferencias.edit();
        editarPreferencias.remove("rut");
        editarPreferencias.remove("nombre");
        editarPreferencias.remove("correo");
        editarPreferencias.commit();
    }

}
