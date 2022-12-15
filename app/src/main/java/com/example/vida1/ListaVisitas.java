package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.vida1.Claseid.id.elnumero;
import static com.example.vida1.Claseid.id.ip_final;
import static com.example.vida1.Claseid.id.tokens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vida1.Modelos.ListaVisitante;
import com.example.vida1.Modelos.Visitante;
import com.example.vida1.RecyclerVisitantes.VisitanteAdapter;
import com.example.vida1.Singleton.Singleton;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaVisitas extends AppCompatActivity {
    Button btnPaginaCrearvistas;
    ImageButton btnregresar;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_visitas);
        btnPaginaCrearvistas = findViewById(R.id.btnPaginaCrearvistas);
        btnPaginaCrearvistas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent parque = getIntent();
                String id_parque = parque.getStringExtra("id_parque");
                Intent intent = new Intent(getApplicationContext(),CrearVisitante.class);
                intent.putExtra("id_parque", id_parque);
                startActivity(intent);
            }
        });


        mQueue = Singleton.getInstance(ListaVisitas.this).getRequestQueue();
        btnregresar = (ImageButton) findViewById(R.id.btnregresarMV);
        btnregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Regresarpagina();
            }
        });


//        findViewById(R.id.btnregresar).setOnClickListener(this::Regresarpagina);
//        findViewById(R.id.btnPaginaCrearvistas).setOnClickListener(this::paginaCrearvisitante);

        getInfo();
    }

    private void getInfo(){
        String url = ip_final + "/api/visitantesL/" + elnumero;
        final androidx.recyclerview.widget.RecyclerView rvVisitante = findViewById(R.id.RclistaVisitas);

        findViewById(R.id.btnregresar).setOnClickListener(this::Regresarpagina);
        findViewById(R.id.btnpaginaCrearVisitante).setOnClickListener(this::paginaCrearvisitante);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Gson gson = new Gson();
                    ListaVisitante visilista = gson.fromJson(response.toString(), ListaVisitante.class);
                    List<Visitante> mvisi = visilista.getData();

                    VisitanteAdapter adapter = new VisitanteAdapter(mvisi, ListaVisitas.this);
                    rvVisitante.setAdapter(adapter);
                    rvVisitante.setHasFixedSize(true);
                    androidx.recyclerview.widget.RecyclerView.LayoutManager manager = new LinearLayoutManager(ListaVisitas.this);
                    rvVisitante.setLayoutManager(manager);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Authorization", "Bearer " + tokens);
                return headers;
            }
        };

        //Toast.makeText(this, "Si ando haciendo cosas", Toast.LENGTH_SHORT).show();
        //Singleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
        mQueue.add(jsonObjectRequest);
    }

    private void Regresarpagina() {
        Intent intent = new Intent(getApplicationContext(),PantallaParques.class);
        startActivity(intent);
    }

    private void paginaCrearvisitante(View view) {
        Intent intent = new Intent(getApplicationContext(),CrearVisitante.class);
        startActivity(intent);
    }

    private void Regresarpagina(View view) {
        Intent intent = new Intent(getApplicationContext(),InformacionParque.class);
        startActivity(intent);
    }
}