package com.example.meteocompare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityUsuario extends AppCompatActivity {

    // Atts
    TextView bienvenida;
    Button buttonLogout;
    Button buttonComparar;
    Button buttonHistorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        buttonComparar = findViewById(R.id.button_comparacion);
        buttonComparar.setOnClickListener(new View.OnClickListener() {      // Asocio la función login al listener del botón
            @Override
            public void onClick(View v) {
                funcionComparar (v);
            }
        });

        // Objeto usuario desde la clase Login
        Usuario usuario = (Usuario) getIntent().getExtras().getSerializable("usuario");

        // Bienvenida + nombre de usuario
        bienvenida = findViewById(R.id.Bienvenida);
        bienvenida.setText(bienvenida.getText().toString() + "\n" + usuario.getNombre());

        // Guardar info de usuario con UsuarioHolder
        UsuarioHolder.getInstance().setUsuarioLogueado(usuario);

        // Boton historial layout
        buttonHistorial = findViewById(R.id.button_historial);
        buttonHistorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lanzamiento para comprobar el historial
                startActivity(new Intent(ActivityUsuario.this, com.example.meteocompare.ActivityHistorial.class));
                finish();

            }
        });

        // Boton logout layout
        buttonLogout = findViewById(R.id.button_logout);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lanzamiento de activity main + logut
                startActivity(new Intent(getBaseContext(), com.example.meteocompare.ActivityMain.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP));
                finish();

            }
        });

    }

    // Funcion comparar
    public void funcionComparar (View v){
        startActivity(new Intent(ActivityUsuario.this, ActivityComparacion.class));
    }
}