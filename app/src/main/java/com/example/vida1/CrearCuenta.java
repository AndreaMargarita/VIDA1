package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CrearCuenta extends AppCompatActivity {
    EditText nombre,apellido,email,contraseña,edad,tel,username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        findViewById(R.id.btnregresar).setOnClickListener(this::irPaginalogin);
        findViewById(R.id.btnCrearNewCuenta).setOnClickListener(this::Iniciarlogin);
        nombre = findViewById(R.id.EditTextnewNombre);
        apellido = findViewById(R.id.EditTextnewApellido);
        email = findViewById(R.id.EditTextnewCorreo);
        contraseña = findViewById(R.id.EditTextnewContraseña);
        edad = findViewById(R.id.EditTextnewEdad);
        tel = findViewById(R.id.EditTextnewTel);
        username = findViewById(R.id.EditTextnewApodo);
    }

    private void Iniciarlogin(View view) {
        Verificarcampos();
    }

    private void Verificarcampos() {
        if (nombre.getText().toString().isEmpty()) {
            Toast.makeText(this, "Campo Nombre necesario.", Toast.LENGTH_SHORT).show();
        }else {
            if (apellido.getText().toString().isEmpty()) {
                Toast.makeText(this, "Campo Apellido necesario.", Toast.LENGTH_SHORT).show();
            } else {
                if (email.getText().toString().isEmpty()) {
                    Toast.makeText(this, "Campo Email necesario.", Toast.LENGTH_SHORT).show();
                } else {
                    if (contraseña.getText().toString().isEmpty()) {
                        Toast.makeText(this, "Campo Contraseña necesaria.", Toast.LENGTH_SHORT).show();
                    } else {
                        if (edad.getText().toString().isEmpty()) {
                            Toast.makeText(this, "Campo Edad necesario.", Toast.LENGTH_SHORT).show();
                        } else {
                            if (tel.getText().toString().isEmpty()) {
                                Toast.makeText(this, "Campo Tel necesario.", Toast.LENGTH_SHORT).show();
                            } else {
                                if (username.getText().toString().isEmpty()) {
                                    Toast.makeText(this, "Campo Username necesario.", Toast.LENGTH_SHORT).show();
                                } else {
                                    //aqui ya se reviso que esten todos los datos, registramos y mandamos al logeo
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                }
                            }
                        }
                    }
                }
            }

        }
    }

    private void irPaginalogin(View view) {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}