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
    EditText email;
    EditText contraseña;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Asociacion con los elementos del layout
        nombre = findViewById(R.id.texto_nombre_registro);
        email = findViewById(R.id.texto_correo_registro);
        contraseña = findViewById(R.id.texto_password_registro);
        register = findViewById(R.id.button_login_2);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    // Metodo registro de usuario
    private void registerUser(){
        BaseDeDatos bd = new BaseDeDatos(this, "android", null, 1);
        if(validarCorreo(email.getText().toString())) {
            if(validarContrasena(contraseña.getText().toString())){

                // Inserta usuario en la BD
                if(bd.insertDataUsuario(nombre.getText().toString(), email.getText().toString(), contraseña.getText().toString()) == true){
                    Toast.makeText(this, (R.string.toast_registro_correcto), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Registro.this, Login.class));
                }else{
                    Toast.makeText(this,(R.string.toast_email_existente), Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(this,(R.string.toast_password_incorrecto),Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(this,(R.string.toast_email_incorrecto),Toast.LENGTH_LONG).show();
        }
    }

    // Metodo validar correo
    private boolean validarCorreo(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;

        return pattern.matcher(email).matches();
    }

    // Metodo validar contraseña
    public boolean validarContrasena(String password){

        // REGEX validando la contraseña (sacado de StackOverFlow)
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=\\S+$).{8,20}$";

        // Compile el REGEX
        Pattern p = Pattern.compile(regex);

        // Falso si el campo de la contraseña está vacio
        if (password == null) {
            return false;
        }

        return p.matcher(password).matches();
    }
}