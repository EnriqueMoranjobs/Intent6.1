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
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {
    EditText edit2;
    Bundle extras;
    String almacenDecenas;
    String almacenUnidades;
    String centenas;


    ActivityResultLauncher<Intent> my_ActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent vuelta = result.getData();
                        //Sacame las unidades y decenas  del intent anterior  y ponmelas en el intent nuevo

                        almacenDecenas = vuelta.getStringExtra("keydecenas");
                        vuelta.putExtra("keysdecenas",almacenDecenas);

                        almacenUnidades = vuelta.getStringExtra("keyunidades");
                        vuelta.putExtra("keycentenas",centenas);

                        //añade las centenas al intent nuevo
                        vuelta.putExtra("keycentenas",centenas);

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
        setContentView(R.layout.activity_segunda);
        edit2 = (EditText) findViewById(R.id.ed2);
        centenas = edit2.getText().toString();


    }

    public void siguiente(View view) {


        Intent intent2 = new Intent(this, TerceraActivity.class);

        // lanzo actividad 2 pero cuando t cierres voy a estar esperando datos
        my_ActivityResultLauncher.launch(intent2);


    }
}