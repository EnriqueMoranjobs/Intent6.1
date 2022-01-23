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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.emoran.ejercicio62binario.R;

public class MainActivity extends AppCompatActivity {
    Button button1;
    TextView textR;
    String almacenDecenas;
    String almacenUnidades;
    String almacenCentenas;


    ActivityResultLauncher<Intent> my_ActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {

                        String resultado;
                        int numero;

                        Intent vuelta = result.getData();
                        String centenas = vuelta.getStringExtra("keyunidades");
                        String decenas = vuelta.getStringExtra("keydecenas");
                        String unidades = vuelta.getStringExtra("keyunidades");


                        resultado = centenas + decenas + unidades;
                        numero = Integer.parseInt(resultado);
                        String binario = Integer.toBinaryString(numero);
                        textR.setText(binario);


                    } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                        String errorMsg = "ERROR";
                        int duration = Toast.LENGTH_LONG;
                        Context context = getApplicationContext();
                        Toast toast = Toast.makeText(context, errorMsg, duration);
                        toast.show();

                    }

                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.btn1);
        textR = (TextView) findViewById(R.id.tvResul);


    }


    public void avanza(View view) {
        Intent intent1 = new Intent(this, SegundaActivity.class);
        // lanzo actividad 2 pero cuando t cierres voy a estar esperando datos
        my_ActivityResultLauncher.launch(intent1);
    }


}

/*

 String centenas = extras.getString("keycentenas");
        String decenas = extras.getString("keydecenas");
        String unidades = extras.getString("keyunidades");


        resultado = centenas+decenas+unidades;
        numero =Integer.parseInt(resultado);
        String binario = Integer.toBinaryString(numero);
        textR.setText(binario);

 */