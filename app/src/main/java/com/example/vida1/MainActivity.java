package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBoxGuardar;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String llave = "sesion";
    EditText Correo, Contraseña;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        checkBoxGuardar = findViewById(R.id.checkBoxGuardarsesion);

        findViewById(R.id.btnCrearCuenta).setOnClickListener(this::irPaginaCrearCuenta);
        findViewById(R.id.btnIniciarSesion).setOnClickListener(this::IniciarSesion);
        Correo= findViewById(R.id.txtCorreo);
        Contraseña = findViewById(R.id.txtContraseña);


        inicializarElementos();

        if (resvisarSesion()){
            startActivity(new Intent(this,PaginaPrincipal.class));
        }else{
            String mensaje= "Inicia sesion";
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
        }
    }

    private void revisarcampos() {
        if (Correo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Correo Nesesario", Toast.LENGTH_SHORT).show();
        }else{
            if (Contraseña.getText().toString().isEmpty()) {
                Toast.makeText(this, "Contraseña Necesaria", Toast.LENGTH_SHORT).show();
            }else{
                startActivity(new Intent(getApplicationContext(),PaginaPrincipal.class));
            }
        }
    }


    private boolean resvisarSesion() {
        boolean sesion =this.sharedPreferences.getBoolean(llave,false);
        return sesion;
    }

    private void inicializarElementos() {
        sharedPreferences = this.getSharedPreferences("sesiones",Context.MODE_PRIVATE);
        editor= sharedPreferences.edit();
    }

    private void IniciarSesion(View view) {
        guardarSesion(checkBoxGuardar.isChecked());
        revisarcampos();
    }

    private void guardarSesion(boolean checked) {
        editor.putBoolean(llave,checked);
        editor.putString("contraseña","615243");
        editor.apply();
    }

    private void irPaginaCrearCuenta(View view) {
        startActivity(new Intent(getApplicationContext(),CrearCuenta.class));
    }
}