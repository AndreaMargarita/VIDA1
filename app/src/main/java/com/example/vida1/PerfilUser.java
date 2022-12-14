package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class PerfilUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_user);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        findViewById(R.id.btnPaginaEditarCuenta).setOnClickListener(this::iraPaginaEditarPErfil);
        findViewById(R.id.btnregresar).setOnClickListener(this::regresarPagina);
        findViewById(R.id.btnCerrarSeccion).setOnClickListener(this::CerrarSesion);
    }

    private void CerrarSesion(View view) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }

    private void regresarPagina(View view) {
        startActivity(new Intent(getApplicationContext(),PaginaPrincipal.class));
    }

    private void iraPaginaEditarPErfil(View view) {
        startActivity(new Intent(getApplicationContext(),EditarPerfil.class));
    }
}