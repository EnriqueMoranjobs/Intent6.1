package com.emoran.ejercicio61binario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
EditText edit2;
TextView textv2;
Bundle extras;
String mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        edit2 = (EditText) findViewById(R.id.ed2);
        textv2 = (TextView) findViewById(R.id.tv2);
        extras = this.getIntent().getExtras();
        mensaje= extras.getString("keycentenas");
        textv2.setText(mensaje);


    }
    public  void siguiente(View view){

        String decenas = edit2.getText().toString();
        String centenas = extras.getString("keycentenas");
        Intent intent2 = new Intent(this,TerceraActivity.class);
        intent2.putExtra("keydecenas",decenas);
        intent2.putExtra("keycentenas",centenas);
        startActivity(intent2);









    }
}