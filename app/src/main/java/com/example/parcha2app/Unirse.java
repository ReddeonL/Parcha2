package com.example.parcha2app;

public class Unirse {

    String nombre_actividad;
    String id_usuario;
    String id_actividad;
    float latitud_usuario;
    float longitud_usuario;
    float latitud_actividad;
    float longitud_actividad;

    public Unirse()
    {}

    public Unirse(String nombre_actividad, String id_usuario, String id_actividad, float latitud_usuario, float longitud_usuario, float latitud_actividad, float longitud_actividad) {
        this.nombre_actividad = nombre_actividad;
        this.id_usuario = id_usuario;
        this.id_actividad = id_actividad;
        this.latitud_usuario = latitud_usuario;
        this.longitud_usuario = longitud_usuario;
        this.latitud_actividad = latitud_actividad;
        this.longitud_actividad = longitud_actividad;
    }

    public String getNombre_actividad() {
        return nombre_actividad;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public String getId_actividad() {
        return id_actividad;
    }

    public float getLatitud_usuario() {
        return latitud_usuario;
    }

    public float getLongitud_usuario() {
        return longitud_usuario;
    }

    public float getLatitud_actividad() {
        return latitud_actividad;
    }

    public float getLongitud_actividad() {
        return longitud_actividad;
    }
}

