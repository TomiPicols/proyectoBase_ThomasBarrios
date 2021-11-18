package com.example.proyectobase_thomasbarrios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Insumos;

public class Insumos_act extends AppCompatActivity {

    private Spinner insumos;
    private Insumos in = new Insumos();
    private TextView result;
    private RatingBar estrella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);



        insumos = findViewById(R.id.spnInsumos);
        result = findViewById(R.id.result);
        estrella = findViewById(R.id.rb);

        // Recibo los extras

        Bundle bun=getIntent().getExtras(); // Recibo los extras y los guardo en un bundle.
        String[] listado=bun.getStringArray("insumos"); // Recibo el arreglo por su referencia.

        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adaptInsumos);
    }

    public void Calcular(View view) {
        String opcion = insumos.getSelectedItem().toString(); // Obtener la seleccion del spinner.
        int precio = 0;

        for(int i = 0; i< opcion.length(); i++)
        {
            if(opcion.equals(in.getInsumos()[i])) // Segun el insumo seleccionado...
            {
                //precio = in.getPrecios()[i]; // Obtengo los precios.
                precio = in.anadirAdicional(in.getPrecios()[i], 350); // Obtengo la regla de negocio
                estrella.setRating(i+1);
                break;
            }
        }

    result.setText("La opcion es:" + opcion + "\nEl precio es: "+ precio );
    }
}