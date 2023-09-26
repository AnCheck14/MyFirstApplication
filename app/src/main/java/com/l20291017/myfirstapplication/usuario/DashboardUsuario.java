package com.l20291017.myfirstapplication.usuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.l20291017.myfirstapplication.R;
import com.l20291017.myfirstapplication.usuario.model.Usuario;
import com.l20291017.myfirstapplication.usuario.repository.UsuarioRepository;

public class DashboardUsuario extends AppCompatActivity {
    private UsuarioRepository ur;
    private Usuario userInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_usuario);
        ur = UsuarioRepository.getInstance();

        //Esta es la manera en que recibimos informacion de otro activity
        String usuario = getIntent().getStringExtra("Usuario");
        String pass = getIntent().getStringExtra("contraseña");

        //Obtenemos informacion del usuario loqueado
        userInfo = ur.getRegisteredUsers().get(usuario).get(pass);

        TextView tvIUsu = findViewById(R.id.tvIUsuario);

        TextView tvNom = findViewById(R.id.tvINombre);
        TextView tvEma = findViewById(R.id.tvIEmail);
        TextView tvEda = findViewById(R.id.tvIEdad);

        tvIUsu.setText(userInfo.getUsuario());

        tvNom.setText(userInfo.getNombre());
        tvEma.setText(userInfo.getEmail());
        tvEda.setText(userInfo.getEdad());


    }
}