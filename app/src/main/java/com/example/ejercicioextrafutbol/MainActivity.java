package com.example.ejercicioextrafutbol;

import android.content.Intent;
import android.os.Bundle;

import com.example.ejercicioextrafutbol.adapters.PartidosAdapter;
import com.example.ejercicioextrafutbol.models.Partido;
import com.google.android.material.snackbar.Snackbar;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import com.example.ejercicioextrafutbol.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    // Logica
    private ArrayList<Partido> listaPartidos;

    // Launchers
    private ActivityResultLauncher<Intent> launcherCrearPartido;

    // Adapter
    private PartidosAdapter adapter;

    // Layout Manager
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        listaPartidos = new ArrayList<>();

        inicializarLaunchers();

        adapter = new PartidosAdapter(listaPartidos, this, R.layout.partido_view_holder);
        layoutManager = new GridLayoutManager(MainActivity.this,1);

        binding.contentMain.contenedor.setAdapter(adapter);
        binding.contentMain.contenedor.setLayoutManager(layoutManager);


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherCrearPartido.launch(new Intent(MainActivity.this, CrearPartidoActivity.class));
            }
        });
    }

    private void inicializarLaunchers() {
        launcherCrearPartido = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode()== RESULT_OK){
                            if (result.getData() != null && result.getData().getExtras() != null){
                                Partido partido = (Partido) result.getData().getExtras().getSerializable("PARTIDO");
                                listaPartidos.add(0, partido);
                                adapter.notifyItemInserted(0);
                            }
                        }
                    }
                }
        );
    }
}