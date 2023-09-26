package com.l20291017.myfirstapplication.usuario.repository;

import com.l20291017.myfirstapplication.usuario.model.Usuario;

import java.util.HashMap;

public class UsuarioRepository {
    private static UsuarioRepository repository = null;
    private HashMap<String, HashMap<String, Usuario> > registeredUsers; //Esto ultimo es el del main activity
    private UsuarioRepository(){
        Usuario u1 = new Usuario("perro","Mamaguebo","Sergio","21","sergio@gmail.com");
        Usuario u2 = new Usuario("Alumno","3312cui","Amanda","12","campanita@gmail.com");
        Usuario u3 = new Usuario("Taniz","Ensambla","William","16","willyensamblador@gmail.com");
        this.registeredUsers = new HashMap<String, HashMap<String, Usuario> >();
        registeredUsers.put(u1.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u1.getUsuario()).put(u1.getPass(), u1);
        registeredUsers.put(u2.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u2.getUsuario()).put(u2.getPass(), u2);
        registeredUsers.put(u3.getUsuario(), new HashMap<String, Usuario>());
        registeredUsers.get(u3.getUsuario()).put(u3.getPass(), u3);
    }
    public static UsuarioRepository getInstance() {
        if (repository == null){
            repository = new UsuarioRepository();
    }
        return repository;
    }

    public HashMap<String, HashMap<String, Usuario>>getRegisteredUsers(){
        return registeredUsers;
    }
}
