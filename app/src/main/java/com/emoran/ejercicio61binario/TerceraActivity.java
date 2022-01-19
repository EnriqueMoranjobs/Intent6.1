package com.emoran.ejercicio61binario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TerceraActivity extends AppCompatActivity {
    EditText edit3;
    TextView textv3;
    Bundle extras;
    String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);
        edit3 = (EditText) findViewById(R.id.et3);
        textv3 = (TextView) findViewById(R.id.tv3);
        extras = this.getIntent().getExtras();
        mensaje = extras.getString("keydecenas");
        textv3.setText(mensaje);

    }

    public void next(View view) {
        String unidades = edit3.getText().toString();
        String decenas = extras.getString("keydecenas");
        String centenas = extras.getString("keycentenas");

        Intent intent3 = new Intent(this,CuartaActivity.class);
        intent3.putExtra("keyunidades", unidades);
        intent3.putExtra("keydecenas", decenas);
        intent3.putExtra("keycentenas", centenas);
        startActivity(intent3);
    }

}