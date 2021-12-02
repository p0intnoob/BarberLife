package com.example.barberlife;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Insumos;

public class Insumo_act extends AppCompatActivity {

    private Insumos in = new Insumos();
    private Spinner insumos;
    private TextView result;
    private RatingBar estrella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumo);

        insumos = findViewById(R.id.spninsumos);
        result = findViewById(R.id.result);
        estrella = findViewById(R.id.rt);
        //RECIBO LOS EXTRAS
        Bundle bun = getIntent().getExtras(); //recibo los extras y los guarda en bundle
        String[] listado = bun.getStringArray("insumos");

        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listado);
        insumos.setAdapter(adaptInsumos);
    }

    public void Calcular(View view)
    {
        String opcion = insumos.getSelectedItem().toString();//obtener la seleccion  del spinner
        int precio =0;


        for(int i = 0; i < opcion.length(); i++)
        {
            if(opcion.equals(in.getInsumos()[i])); // segun el insumo selecionado
            {
                //precio= in.getPrecios()[i];
                precio= in.anadirAdicional(in.getPrecios()[i], 350);//obtner la regla de negocio
                estrella.setRating(i+1);//pintar estrellas
                break;
            }
        }
        result.setText("La opcion es: "+opcion+ "\nEl precio es: "+precio);
    }
}