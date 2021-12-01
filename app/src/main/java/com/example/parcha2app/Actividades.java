package com.example.parcha2app;

public class Actividades {
    int numparticipantes, anio,mes, dia,hora, min;
    float latitud, longitud;

    String firebaseid, idactividad, nombre_actividad, descripcion, idusuario;

    public Actividades(String firebaseid,int numparticipantes, float latitud, float longitud, String idactividad, String nombre_actividad, String descripcion, String idusuario,int anio, int mes, int dia, int hora, int min) {
        this.firebaseid=firebaseid;
        this.numparticipantes = numparticipantes;
        this.latitud = latitud;
        this.longitud = longitud;
        this.hora = hora;
        this.min = min;
        this.idactividad = idactividad;
        this.nombre_actividad = nombre_actividad;
        this.descripcion = descripcion;
        this.idusuario = idusuario;
        this.anio=anio;
        this.mes=mes;
        this.dia=dia;
    }

    public int getNumparticipantes() {
        return numparticipantes;
    }

    public float getLatitud() {
        return latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public Actividades(int anio, int mes, int dia, int hora, int min) {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.min = min;
    }

    public String getIdactividad() {
        return idactividad;
    }

    public String getNombre_actividad() {
        return nombre_actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getIdusuario() {
        return idusuario;
    }


}
