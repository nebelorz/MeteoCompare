package com.example.meteocompare;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;

import Interface.JsonPlaceHolderApi;
import Modelo.Model200;
import Modelo.PrediccionMunicipio;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityComparacion extends AppCompatActivity {

    // Atts
    Spinner spinnerProvincia1;
    Spinner spinnerLocalidad1;

    Spinner spinnerProvincia2;
    Spinner spinnerLocalidad2;

    Button buttonCompara;

    String baseUrl = "https://opendata.aemet.es/";
    PrediccionMunicipio prediccion1;
    PrediccionMunicipio prediccion2;
    boolean pred1rx;
    boolean pred2rx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comparacion);

        spinnerProvincia1 = (Spinner) findViewById(R.id.spinnerProvincia1);
        spinnerLocalidad1 = (Spinner) findViewById(R.id.spinnerLocalidad1);

        spinnerProvincia2 = (Spinner) findViewById(R.id.spinnerProvincia2);
        spinnerLocalidad2 = (Spinner) findViewById(R.id.spinnerLocalidad2);

        String [] opciones = {"Municipio"};

        // Muestra los nombres del archivo para escoger la provincia en el spinner
        InputStream inputStream = getResources().openRawResource(R.raw.provincias);
        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> csvList = csvFile.read();

        // Selecciono la primera fila del archivo
        String[] provincias = csvList.get(0);

        // Crear lista
        List<String> provinciasList = new ArrayList<String>();

        // Añado "provincia" como titulo informativo
        provinciasList.add("- Selecciona una provincia -");

        // Convierto el array a lista
        for (int i = 0; i < provincias.length; i++)
        {
            provinciasList.add(provincias[i]);
        }

        // Se añade el contenido a los spinners
        ArrayAdapter<String> provincia1 = new ArrayAdapter<String>(this, R.layout.spinner, provinciasList);
        spinnerProvincia1.setAdapter(provincia1);

        ArrayAdapter<String> localidad1 = new ArrayAdapter<String>(this, R.layout.spinner, opciones);
        spinnerLocalidad1.setAdapter(localidad1);
        spinnerLocalidad1.setEnabled(false);
        spinnerLocalidad1.setClickable(false);

        ArrayAdapter<String> provincia2 = new ArrayAdapter<String>(this, R.layout.spinner, provinciasList);
        spinnerProvincia2.setAdapter(provincia2);

        ArrayAdapter<String> localidad2 = new ArrayAdapter<String>(this, R.layout.spinner, opciones);
        spinnerLocalidad2.setAdapter(localidad2);
        spinnerLocalidad2.setEnabled(false);
        spinnerLocalidad2.setClickable(false);

        // Comportamiento al seleccionar la opcion en el spinner provincia1
        spinnerProvincia1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                // An item was selected. You can retrieve the selected item using
                // System.out.println(parent.getItemAtPosition(pos));
                // <- Sacado de StackOverFlow -->
                if (pos != 0) {
                    // String con el nombre de los municipios de la provincia, sustituyendo
                    // las "ñ", acentos y espacios
                    String municipiosDeProvincia = "municipios_" + parent.getItemAtPosition(pos);

                    municipiosDeProvincia = municipiosDeProvincia.toLowerCase();
                    municipiosDeProvincia = municipiosDeProvincia.replace('á', 'a');
                    municipiosDeProvincia = municipiosDeProvincia.replace('é', 'e');
                    municipiosDeProvincia = municipiosDeProvincia.replace('í', 'i');
                    municipiosDeProvincia = municipiosDeProvincia.replace('ó', 'o');
                    municipiosDeProvincia = municipiosDeProvincia.replace('ú', 'u');
                    municipiosDeProvincia = municipiosDeProvincia.replace("ñ", "n");
                    municipiosDeProvincia = municipiosDeProvincia.replace(" ", "_");

                    // Muestra los nombres de los municipios
                    InputStream isMunicipios1 = getResources().openRawResource(
                            getResources().getIdentifier(municipiosDeProvincia, "raw", getPackageName()));

                    CSVFile csvFileMunicipios1 = new CSVFile(isMunicipios1);
                    List<String[]> csvListMunicipios1 = csvFileMunicipios1.read();

                    // Selecciono la primera fila del archivo
                    String[] municipios = csvListMunicipios1.get(0);

                    // Crear lista
                    List<String> municipiosList = new ArrayList<String>();

                    // Texto informativo
                    municipiosList.add("- Selecciona un municipio -");

                    // Convierto el array a lista
                    for (int i = 0; i < municipios.length; i++) {
                        municipiosList.add(municipios[i]);
                    }

                    ArrayAdapter<String> localidad1 = new ArrayAdapter<String>(ActivityComparacion.this, R.layout.spinner, municipiosList);
                    spinnerLocalidad1.setAdapter(localidad1);
                    spinnerLocalidad1.setEnabled(true);
                    spinnerLocalidad1.setClickable(true);
                } else {
                    List<String> defaultText = new ArrayList<String>();
                    defaultText.add("- Selecciona un municipio -");
                    ArrayAdapter<String> localidad1 = new ArrayAdapter<String>(ActivityComparacion.this, R.layout.spinner, defaultText);
                    spinnerLocalidad1.setAdapter(localidad1);
                    spinnerLocalidad1.setEnabled(false);
                    spinnerLocalidad1.setClickable(false);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
                // <-- Sacado de Stackoverflow ->>
            }
        });

        // Comportamiento al seleccionar la opcion en el spinner provincia2
        spinnerProvincia2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                // An item was selected. You can retrieve the selected item using
                // System.out.println(parent.getItemAtPosition(pos));
                // <- Sacado de StackOverFlow -->
                if (pos != 0) {
                    // String con el nombre de los municipios de la provincia, sustituyendo
                    // las "ñ", acentos y espacios
                    String municipiosDeProvincia = "municipios_" + parent.getItemAtPosition(pos);

                    municipiosDeProvincia = municipiosDeProvincia.toLowerCase();
                    municipiosDeProvincia = municipiosDeProvincia.replace('á', 'a');
                    municipiosDeProvincia = municipiosDeProvincia.replace('é', 'e');
                    municipiosDeProvincia = municipiosDeProvincia.replace('í', 'i');
                    municipiosDeProvincia = municipiosDeProvincia.replace('ó', 'o');
                    municipiosDeProvincia = municipiosDeProvincia.replace('ú', 'u');
                    municipiosDeProvincia = municipiosDeProvincia.replace("ñ", "n");
                    municipiosDeProvincia = municipiosDeProvincia.replace(" ", "_");

                    // Muestra los nombres de los municipios
                    InputStream isMunicipios2 = getResources().openRawResource(
                            getResources().getIdentifier(municipiosDeProvincia, "raw", getPackageName()));

                    CSVFile csvFileMunicipios2 = new CSVFile(isMunicipios2);
                    List<String[]> csvListMunicipios2 = csvFileMunicipios2.read();

                    // Selecciono la primera fila del archivo
                    String[] municipios = csvListMunicipios2.get(0);

                    // Crear lista
                    List<String> municipiosList = new ArrayList<String>();

                    // Texto informativo
                    municipiosList.add("- Selecciona un municipio -");

                    // Convierto el array a lista
                    for (int i = 0; i < municipios.length; i++) {
                        municipiosList.add(municipios[i]);
                    }

                    ArrayAdapter<String> localidad2 = new ArrayAdapter<String>(ActivityComparacion.this, R.layout.spinner, municipiosList);
                    spinnerLocalidad2.setAdapter(localidad2);
                    spinnerLocalidad2.setEnabled(true);
                    spinnerLocalidad2.setClickable(true);
                } else {
                    List<String> defaultText = new ArrayList<String>();
                    defaultText.add("- Selecciona un municipio -");
                    ArrayAdapter<String> localidad2 = new ArrayAdapter<String>(ActivityComparacion.this, R.layout.spinner, defaultText);
                    spinnerLocalidad2.setAdapter(localidad2);
                    spinnerLocalidad2.setEnabled(false);
                    spinnerLocalidad2.setClickable(false);
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
                // <-- Sacado de Stackoverflow ->>
            }
        });

        buttonCompara = findViewById(R.id.button);                     // Boton comparar -> boton del layout
        buttonCompara.setOnClickListener(new View.OnClickListener() {  // Listener del boton asociada a hacerComparacion
            @Override
            public void onClick(View v) {
                String provincia1 = "";
                String provincia2 = "";
                String localidad1 = "";
                String localidad2 = "";

                if(spinnerProvincia1.getSelectedItemPosition() != 0) { // Provincia seleccionada
                    provincia1 = spinnerProvincia1.getSelectedItem().toString();
                    if(spinnerLocalidad1.getSelectedItemPosition() != 0) { // Localidad seleccionada
                        localidad1 = spinnerLocalidad1.getSelectedItem().toString();
                    } else {
                        Toast.makeText(ActivityComparacion.this,getString(R.string.toast_seleccion_municipio),Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else {
                    Toast.makeText(ActivityComparacion.this, getString(R.string.toast_seleccion_provincia),Toast.LENGTH_SHORT).show();
                    return;
                }

                if(spinnerProvincia2.getSelectedItemPosition() != 0) { // Provincia seleccionada
                    provincia2 = spinnerProvincia2.getSelectedItem().toString();
                    if(spinnerLocalidad2.getSelectedItemPosition() != 0) { // Localidad seleccionada
                        localidad2 = spinnerLocalidad2.getSelectedItem().toString();
                    } else {
                        Toast.makeText(ActivityComparacion.this,getString(R.string.toast_seleccion_municipio),Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else {
                    Toast.makeText(ActivityComparacion.this,getString(R.string.toast_seleccion_provincia),Toast.LENGTH_SHORT).show();
                    return;
                }

                System.out.println("Localidades/Provincias validas");
                int cod1 = obtenerCodigoLocalidad(provincia1, localidad1);
                int cod2 = obtenerCodigoLocalidad(provincia2, localidad2);

                if(cod1 != -1 && cod2 != -1) {
                    hacerComparacion (cod1,cod2);
                } else{
                    Toast.makeText(ActivityComparacion.this,getString(R.string.toast_error_cod_provincia),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private int obtenerCodigoLocalidad(String provincia, String localidad){
        int codigo = -1;
        InputStream is = getResources().openRawResource(R.raw.codigos_zonas);
        com.example.meteocompare.CSVFile csvFile = new com.example.meteocompare.CSVFile(is);
        List<String[]> csvList = csvFile.read();

        System.out.println(csvList.size());
        for(String[] stringArray : csvList) {

            if(stringArray[4].equals(localidad) && stringArray[5].equals(provincia)) {
                codigo = Integer.parseInt(stringArray[1]) * 1000 + Integer.parseInt(stringArray[2]);
                break;
            }
        }
        return codigo;
    }

    private void hacerComparacion(int cod1, int cod2){
        getModel200(cod1, 1);
        getModel200(cod2, 2);
    }

    private void getModel200(int cod, final int index)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Call de la interfaz
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        String url = "opendata/api/prediccion/especifica/municipio/diaria/" +
                String.format("%05d", cod) +
                "/?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuZWJlbG9yekBob3RtYWlsLmNvbSIsImp0aSI6IjE0Y2M2ODMyLTA0ZjUtNDMzYS1iODkzLTBjMTlkMWU4MDg4ZSIsImlzcyI6IkFFTUVUIiwiaWF0IjoxNjUwNTY1MjYzLCJ1c2VySWQiOiIxNGNjNjgzMi0wNGY1LTQzM2EtYjg5My0wYzE5ZDFlODA4OGUiLCJyb2xlIjoiIn0.2ERs6mrPbDOgnGUcUZaNPLQHw0f3MwxODMurBZUG6Tc";

        Call<Model200> call = jsonPlaceHolderApi.getModel200(url);
        call.enqueue(new Callback<Model200>() {
            @Override
            public void onResponse(Call<Model200> call, Response<Model200> response) {
                if(!response.isSuccessful()){
                    System.out.println("Error operacion 1");
                    return;
                }
                getPrediction(response.body(), index);
            }

            @Override
            public void onFailure(Call<Model200> call, Throwable t) {

            }
        });
    }

    // Metodo recopilar datos
    private void getPrediction(Model200 model200, final int index){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        String url2 = model200.getDatos();
        url2 = url2.replace(baseUrl,"");

        System.out.println("Prediccion" + index);
        Call<List<PrediccionMunicipio>> callPrediccion = jsonPlaceHolderApi.getPrediccion(url2);

        callPrediccion.enqueue(new Callback<List<PrediccionMunicipio>>() {
            @Override
            public void onResponse(Call<List<PrediccionMunicipio>> call, Response<List<PrediccionMunicipio>> response) {
                if(!response.isSuccessful()){
                    System.out.println("Error operacion");
                    return;
                }

                List<PrediccionMunicipio> prediccionMunicipioList = response.body();
                // Lista de un solo elemento
                PrediccionMunicipio prediccion = prediccionMunicipioList.get(0);

                if(index == 1) {
                    System.out.println("Recibida prediccion 1");
                    comprobarRecepcion(prediccion, index);

                } else {
                    System.out.println("Recibida prediccion 2");
                    comprobarRecepcion(prediccion, index);
                }
            }

            @Override
            public void onFailure(Call<List<PrediccionMunicipio>> call, Throwable t) {

            }
        });
    }

    // Compruebo que ambas respuestas han llegado para continuar
    private void comprobarRecepcion(PrediccionMunicipio prediccionMunicipio, int index){
        if(index == 1) {
            pred1rx = true;
            prediccion1 = prediccionMunicipio;
            if(pred2rx == true) { // Se han recibido ambas
                procesarComparacion();
            }

        } else {
            pred2rx = true;
            prediccion2 = prediccionMunicipio;
            if (pred1rx == true) {
                procesarComparacion();
            }
        }
    }

    private void procesarComparacion(){
        Intent intent = new Intent(this, ActivityResultadoComparacion.class);
        System.out.println("Provincia; " + prediccion1.getProvincia() + "Localidad: " + prediccion1.getNombre());
        intent.putExtra("prediccionMunicipio1", prediccion1);
        intent.putExtra("prediccionMunicipio2", prediccion2);
        startActivity(intent);
    }
}


