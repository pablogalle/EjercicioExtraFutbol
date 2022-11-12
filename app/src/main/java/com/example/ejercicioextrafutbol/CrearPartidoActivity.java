package com.example.ejercicioextrafutbol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.ejercicioextrafutbol.databinding.ActivityCrearPartidoBinding;
import com.example.ejercicioextrafutbol.models.Partido;

import java.util.ArrayList;

public class CrearPartidoActivity extends AppCompatActivity {

    private ActivityCrearPartidoBinding binding;
    private ArrayList<String> listaEquipos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCrearPartidoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        inicializarArrayList();
        inicializarSpinners();

        binding.btnCrearPartido.setOnClickListener(view -> {
            if (!binding.spnEquipoLocalCrearPartido.getSelectedItem().toString().isEmpty() &&
                    !binding.spnEquipoVisitanteCrearPartido.getSelectedItem().toString().isEmpty() &&
                    !binding.txtGolesLocalCrearPartido.getText().toString().isEmpty() &&
                    !binding.txtGolesVisitanteCrearPartido.getText().toString().isEmpty() &&
                    !binding.txtResumenCrearPartido.getText().toString().isEmpty()
            ){
                Partido partido = new Partido(
                        binding.spnEquipoLocalCrearPartido.getSelectedItem().toString(),
                        binding.spnEquipoVisitanteCrearPartido.getSelectedItem().toString(),
                        Integer.parseInt(binding.txtGolesLocalCrearPartido.getText().toString()),
                        Integer.parseInt(binding.txtGolesVisitanteCrearPartido.getText().toString()),
                        binding.txtResumenCrearPartido.getText().toString());
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("PARTIDO", partido);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();

            }else Toast.makeText(this, "Faltan datos", Toast.LENGTH_SHORT).show();
        });
    }

    private void inicializarArrayList() {
        listaEquipos = new ArrayList<>();

        listaEquipos.add("Valencia CF");
        listaEquipos.add("Villareal CF");
        listaEquipos.add("Osasuna CF");
        listaEquipos.add("Barcelona CF");

    }

    private void inicializarSpinners() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaEquipos);

        binding.spnEquipoLocalCrearPartido.setAdapter(adapter);
        binding.spnEquipoVisitanteCrearPartido.setAdapter(adapter);
    }
}