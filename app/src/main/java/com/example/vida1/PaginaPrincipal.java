package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PaginaPrincipal extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        findViewById(R.id.btnCrearParque).setOnClickListener(this::paginaCrearParque);
        findViewById(R.id.btnVerParques).setOnClickListener(this::VerParquesPagina);
        findViewById(R.id.btnVerPerfil).setOnClickListener(this::VerPerfilPagina);

        sharedPreferences = getSharedPreferences("sesiones",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();


    }

    private void VerPerfilPagina(View view) {
        startActivity(new Intent(getApplicationContext(),PerfilUser.class));
    }

    private void VerParquesPagina(View view) {
        startActivity(new Intent(getApplicationContext(),PantallaParques.class));
    }

    private void paginaCrearParque(View view) {
        startActivity(new Intent(getApplicationContext(),CrearParque.class));
    }

    private void cerrarSesion(View view) {
        editor.putBoolean("sesion",false);
        editor.apply();
        Toast.makeText( this,"La sesion fue cerrada.", Toast.LENGTH_SHORT).show();
    }
}