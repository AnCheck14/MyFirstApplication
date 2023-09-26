package com.l20291017.myfirstapplication.usuario.model;

public class Usuario {
    private String usuario;
    private String pass;
    private String nombre;
    private String edad;
    private String email;

    public Usuario(String usuario, String pass, String nombre, String edad, String email) {
        this.usuario = usuario;
        this.pass = pass;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
