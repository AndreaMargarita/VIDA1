package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class EditarPerfil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();
        findViewById(R.id.btnregresar).setOnClickListener(this::RegresarPagina);
    }

    private void RegresarPagina(View view) {
        startActivity(new Intent(getApplicationContext(), PerfilUser.class));
    }
}