package com.emoran.ejercicio61binario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CuartaActivity extends AppCompatActivity {
    TextView textv4;
    TextView textR;
    Bundle extras;
    String mensaje;
    String resultado;
    int numero;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuarta);
        textv4 = (TextView) findViewById(R.id.tv4);
        textR = (TextView) findViewById(R.id.tvResul);
        extras = this.getIntent().getExtras();
        mensaje = extras.getString("keyunidades");
        textv4.setText(mensaje);

        String centenas = extras.getString("keycentenas");
        String decenas = extras.getString("keydecenas");
        String unidades = extras.getString("keyunidades");


        resultado = centenas+decenas+unidades;
        numero =Integer.parseInt(resultado);
        String binario = Integer.toBinaryString(numero);

        textR.setText(binario);


    }
}