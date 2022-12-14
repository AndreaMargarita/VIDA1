package com.example.vida1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.vida1.Modelos.Volley_Singleton;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

public class InformacionSensores extends AppCompatActivity {
    RecyclerView RclistaSensores;
    private List<Sensores>sensores;
    private Adaptador_Sensores adaptador_sensores;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_sensores);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        requestQueue = Volley_Singleton.getInstance(this). getRequestQueue();
        VerSensores();
    }

    private void VerSensores() {
        String url = "http://3.133.89.232/api/traerSensores";
        JsonObjectRequest requiere = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();

                Adaptador_Sensores = new Adaptador_Sensores(Sensores);
                RclistaSensores.setAdapter(Adaptador_Sensores);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(requiere);
    }
}