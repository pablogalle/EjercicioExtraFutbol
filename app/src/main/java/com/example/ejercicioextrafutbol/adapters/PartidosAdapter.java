package com.example.ejercicioextrafutbol.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicioextrafutbol.InfoPartidoActivity;
import com.example.ejercicioextrafutbol.MainActivity;
import com.example.ejercicioextrafutbol.R;
import com.example.ejercicioextrafutbol.models.Partido;

import java.util.ArrayList;

public class PartidosAdapter extends RecyclerView.Adapter<PartidosAdapter.PartidoVH> {

    private ArrayList<Partido> objects;
    private Context context;
    private int cardLayout;

    public PartidosAdapter(ArrayList<Partido> objects, Context context, int cardLayout) {
        this.objects = objects;
        this.context = context;
        this.cardLayout = cardLayout;
    }

    @NonNull
    @Override
    public PartidoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View partidoView = LayoutInflater.from(context).inflate(cardLayout, null);
        return new PartidoVH(partidoView);
    }

    @Override
    public void onBindViewHolder(@NonNull PartidoVH holder, int position) {
        Partido partido = objects.get(position);
        holder.lblEquipoLocal.setText(partido.getEquipoLocal());
        holder.lblEquipoVisitante.setText(partido.getEquipoVisitante());
        holder.lblGolesLocal.setText(String.valueOf(partido.getGolesLocal()));
        holder.lblGolesVisitante.setText(String.valueOf(partido.getGolesVisitante()));
        holder.btnResultado.setOnClickListener(view-> alertResultados(partido).show());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent((MainActivity)context, InfoPartidoActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("PARTIDO", partido);
            intent.putExtras(bundle);
            context.startActivity(intent);
        });

    }

    private AlertDialog alertResultados(Partido partido) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("RESULTADO");
        builder.setMessage(partido.getResultado());

        return builder.create();
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class PartidoVH extends RecyclerView.ViewHolder{
        TextView lblEquipoLocal, lblGolesLocal;
        TextView lblEquipoVisitante, lblGolesVisitante;
        Button btnResultado;

        public PartidoVH(@NonNull View itemView) {
            super(itemView);
            lblEquipoLocal = itemView.findViewById(R.id.lblEquipoLocalViewHolder);
            lblEquipoVisitante = itemView.findViewById(R.id.lblEquipoVisitanteViewHolder);
            lblGolesLocal = itemView.findViewById(R.id.lblGolesLocalViewHolder);
            lblGolesVisitante = itemView.findViewById(R.id.lblGolesVisitanteViewHolder);
            btnResultado = itemView.findViewById(R.id.btnResultadoViewHolder);
        }
    }
}
