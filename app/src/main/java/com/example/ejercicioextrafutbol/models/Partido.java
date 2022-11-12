package com.example.ejercicioextrafutbol.models;

import java.io.Serializable;

public class Partido implements Serializable {
    private String equipoLocal;
    private String equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    private String resumen;
    private final String resultado;

    public Partido(String equipoLocal, String equipoVisitante, int golesLocal, int golesVisitante, String resumen) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.golesLocal = golesLocal;
        this.golesVisitante = golesVisitante;
        this.resumen = resumen;

        if (golesLocal>golesVisitante){
            resultado = "Ganador: "+equipoLocal;
        }else if (golesLocal<golesVisitante){
            resultado = "Ganador: "+equipoVisitante;
        }else resultado = "Empate";
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public void setGolesLocal(int golesLocal) {
        this.golesLocal = golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public void setGolesVisitante(int golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getResultado() {
        return resultado;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "equipoLocal='" + equipoLocal + '\'' +
                ", equipoVisitante='" + equipoVisitante + '\'' +
                ", golesLocal=" + golesLocal +
                ", golesVisitante=" + golesVisitante +
                ", resumen='" + resumen + '\'' +
                '}';
    }
}
