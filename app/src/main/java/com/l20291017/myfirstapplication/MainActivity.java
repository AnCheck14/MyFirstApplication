package com.l20291017.myfirstapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.l20291017.myfirstapplication.usuario.DashboardUsuario;
import com.l20291017.myfirstapplication.usuario.repository.UsuarioRepository;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private UsuarioRepository ur;
    private HashMap<String,String> registeredUsers = new HashMap<String,String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ur = UsuarioRepository.getInstance();

        //registeredUsers.put("Perro","Mamaguebo");
        //registeredUsers.put("Alumno","3312cui");
        //registeredUsers.put("Taniz","Ensambla");
    }

    private AlertDialog createAlertDialog(String tittle, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder
        builder.setTitle(tittle)
                .setMessage(message);
        return builder.create();
    }

    public void onBtnIngresarTap(View view){

        //AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //AlertDialog dialog = builder.create();


        EditText etUsuario = findViewById(R.id.etUsuario);
        EditText etPass = findViewById(R.id.etPass);
        String user, pass;

        user = etUsuario.getText().toString();
        pass = etPass.getText().toString();

        if(!ur.getRegisteredUsers().containsKey(user)){
            /*dialog.setTitle("Atencion");
            dialog.setMessage("Usuario no registrado");

            dialog.show();*/
            this.createAlertDialog("Atención","Usuario no registrado").show();
            return;
        }
        if(!ur.getRegisteredUsers().get(user).containsKey(pass)){
            /*dialog.setTitle("Atencion");
            dialog.setMessage("Contraseña no coincide");

            dialog.show();*/
            this.createAlertDialog("Atención","Contraseña no coincide").show();
            return;
        }
        //user.toUpperCase();
        //dialog.setTitle("Felicidades presionaste el boton");
        //dialog.setMessage(String.format("Datos Ingresados\nUsuario: %s\nPassWord: %s",user,pass));

        //dialog.show();
        //return;
        String message = "Felicidades ha iniciado sesión con éxito";
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();


        Intent i = new Intent(this, DashboardUsuario.class);
        i.putExtra("Usuario", user);
        i.putExtra("contraseña", pass);
        //Inicia la siguiente pantalla
        startActivity(i);

    }

}