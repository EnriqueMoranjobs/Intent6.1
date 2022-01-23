package com.emoran.ejercicio62binario;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.emoran.ejercicio62binario.R;

public class CuartaActivity extends AppCompatActivity {
    EditText editT4;
    String unidades;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuarta);
        editT4 = (EditText) findViewById(R.id.et4);
        unidades = editT4.getText().toString();



    }
    //SALIR
    public void retorno(View view){
        Intent vuelta = new Intent(this,MainActivity.class);
        vuelta.putExtra("keyunidades",unidades);
        setResult(RESULT_OK,vuelta);
        finish();
        // lanzo actividad 2 pero cuando t cierres voy a estar esperando datos


    }
}

