package com.example.parcha2app;

public class Usuario {
    String firebaseid,cod_usuario,nombre, correo,edad,apellido,genero;
    boolean autorizacion;

    public Usuario(String firebaseid, String cod_usuario, String correo, String edad, String nombre,String apellido, String genero, boolean autorizacion) {
        this.firebaseid = firebaseid;
        this.cod_usuario = cod_usuario;
        this.nombre=nombre;
        this.correo = correo;
        this.edad = edad;
        this.apellido = apellido;
        this.genero = genero;
        this.autorizacion = autorizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFirebaseid() {
        return firebaseid;
    }

    public String getCod_usuario() {
        return cod_usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getEdad() {
        return edad;
    }

    public String getApellido() {
        return apellido;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isAutorizacion() {
        return autorizacion;
    }

}
