package com.example.parcha2app;

public class Actividades {
    int numparticipantes, anio,mes, dia,hora, min;
    double latitud, longitud;

    String firebaseid, nombre_actividad, descripcion, idusuario;

    public Actividades(String firebaseid,int numparticipantes, double latitud, double longitud, String nombre_actividad, String descripcion, String idusuario,int anio, int mes, int dia, int hora, int min) {
        this.firebaseid=firebaseid;
        this.nombre_actividad = nombre_actividad;
        this.descripcion = descripcion;
        this.numparticipantes = numparticipantes;
        this.idusuario = idusuario;
        this.latitud = latitud;
        this.longitud = longitud;
        this.hora = hora;
        this.min = min;
        this.anio=anio;
        this.mes=mes;
        this.dia=dia;
    }
    public String getFirebaseid() {
        return firebaseid;
    }
    public String getNombre_actividad() {
        return nombre_actividad;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public int getNumparticipantes() {
        return numparticipantes;
    }
    public String getIdusuario() {
        return idusuario;
    }
    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public int getAnio() {
        return anio;
    }

    public int getHora() {
        return hora;
    }

    public int getMin() {
        return min;
    }
    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

}
