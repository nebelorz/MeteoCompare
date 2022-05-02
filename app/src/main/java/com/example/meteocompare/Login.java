package com.example.meteocompare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    // Atts
    EditText correo;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        correo = findViewById(R.id.texto_correo_registro);
        password = findViewById(R.id.texto_password_registro);
        login = findViewById(R.id.button_login_2);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    // Metodo para el login
    private void loginUser() {
        BaseDeDatos bd = new BaseDeDatos(this, "android", null, 1);

        Usuario usuario = bd.checkLogin(correo.getText().toString(), password.getText().toString());

        // No existe usuario con ese correo
        if(usuario.getId() == 0) {
            Toast.makeText(this,(R.string.toast_login_incorrecto),Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,(R.string.toast_login_correcto),Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ActivityUsuario.class);
            intent.putExtra("usuario", usuario);
            startActivity(intent);
        }
    }
}