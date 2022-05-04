package com.example.meteocompare;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {

    // Atts
    EditText nombre;
    EditText correo;
    EditText password;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Asociacion con los elementos del layout
        nombre = findViewById(R.id.texto_nombre_registro);
        correo = findViewById(R.id.texto_correo_registro);
        password = findViewById(R.id.texto_password_registro);
        registrar = findViewById(R.id.button_login_2);
        registrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    // Metodo registro de usuario
    private void registerUser(){
        BaseDeDatos bd = new BaseDeDatos(this, "android", null, 1);
        if(validarCorreo(correo.getText().toString())) {
            if(validarPassword(password.getText().toString())){

                // Inserta usuario en la BD
                if(bd.insertDataUsuario(nombre.getText().toString(), correo.getText().toString(), password.getText().toString())){
                    Toast.makeText(this, (R.string.toast_registro_correcto), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Registro.this, Login.class));
                }else{
                    Toast.makeText(this,(R.string.toast_correo_existente), Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(this,(R.string.toast_password_incorrecto),Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this,(R.string.toast_correo_incorrecto),Toast.LENGTH_LONG).show();
        }
    }

    // Metodo validar correo
    private boolean validarCorreo(String correo) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;

        return pattern.matcher(correo).matches();
    }

    // Metodo validar password
    public boolean validarPassword(String password){

        // REGEX validando la password (sacado de StackOverFlow)
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,20}$";

        // Compile el REGEX
        Pattern p = Pattern.compile(regex);

        // Falso si el campo de la password está vacio
        if (password == null) {
            return false;
        }

        return p.matcher(password).matches();
    }
}