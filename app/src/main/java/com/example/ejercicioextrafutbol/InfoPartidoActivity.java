package com.example.ejercicioextrafutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ejercicioextrafutbol.databinding.ActivityInfoPartidoBinding;
import com.example.ejercicioextrafutbol.models.Partido;

public class InfoPartidoActivity extends AppCompatActivity {

    private ActivityInfoPartidoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInfoPartidoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Partido partido = (Partido) getIntent().getExtras().getSerializable("PARTIDO");
        binding.lblEquipoLocal.setText(partido.getEquipoLocal());
        binding.lblEquipoVisitante.setText(partido.getEquipoVisitante());
        binding.lblGolesLocal.setText(String.valueOf(partido.getGolesLocal()));
        binding.lblGolesVisitante.setText(String.valueOf(partido.getGolesVisitante()));
        binding.lblResumen.setText(partido.getResumen());

    }
}