package com.example.vida1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

import java.util.List;

public class Adaptador_Sensores extends RecyclerView.Adapter<Adaptador_Sensores.Adaptador_SensoresHolder>r{
    List<Sensores> sensores;
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adaptador_sensores);
    }

    @NonNull
    @Override
    public Adaptador_Sensores.Adaptador_SensoresHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador_Sensores.Adaptador_SensoresHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}