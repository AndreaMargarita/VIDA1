package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vida1.Modelos.Info;
import com.example.vida1.Modelos.Volley_Singleton;
import com.google.gson.Gson;

import org.json.JSONObject;

public class InformacionParque extends AppCompatActivity {
    RequestQueue requestQueue;
    TextView TextVerNombreParque, TextVerLargoTerreno, TextVerAnchoTerreno, TextVerCanIluminarias, TextVerCanSensores;
    EditText TextVerReglasParque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_parque);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        requestQueue = Volley_Singleton.getInstance(this).getRequestQueue();
        ObtenerDatos();

        Button btnpaginaEditarParque, btnEliminarParque, btnpaginaListaSensores;

        btnpaginaEditarParque = findViewById(R.id.btnpaginaEditarParque);
        btnEliminarParque = findViewById(R.id.btnEliminarParque);
        btnpaginaListaSensores = findViewById(R.id.btnpaginaListaSensores);

        TextVerNombreParque = findViewById(R.id.TextVerNombreParque);
        TextVerLargoTerreno = findViewById(R.id.TextVerLargoTerreno);
        TextVerAnchoTerreno = findViewById(R.id.TextVerAnchoTerreno);
        TextVerCanIluminarias = findViewById(R.id.TextVerCanIluminarias);
        TextVerCanSensores =findViewById(R.id.TextVerCanSensores);

        TextVerReglasParque = findViewById(R.id.TextVerReglasParque);

        btnpaginaEditarParque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformacionParque.this, EditarParque.class);
                startActivity(intent);
            }
        });
        btnpaginaListaSensores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformacionParque.this, InformacionSensores.class);
                startActivity(intent);

            }
        });
        btnEliminarParque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://3.133.89.232/api/traerparques";
                JsonObjectRequest requiere = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Gson gson = new Gson();
                        Info info = gson.fromJson(response.toString(), Info.class);


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                requestQueue.add(requiere);
            }
        });
    }
    private void ObtenerDatos() {

    }
}