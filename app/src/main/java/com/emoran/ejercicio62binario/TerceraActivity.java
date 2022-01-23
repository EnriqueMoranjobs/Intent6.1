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

public class TerceraActivity extends AppCompatActivity {
    EditText edit3;
    String AlmacenUnidades;
    String decenas;

    ActivityResultLauncher<Intent> my_ActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent vuelta = result.getData();

                       //Sacame las unidades del intent anterior  y ponmelas en el intent nuevo
                         AlmacenUnidades = vuelta.getStringExtra("keyunidades");
                         vuelta.putExtra("keyunidades",AlmacenUnidades);

                       // añade  las decenas al intent nuevo
                        vuelta.putExtra("keydecenas",decenas);



                    } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                        String errorMsg = "ERROR";
                        int duration = Toast.LENGTH_LONG;
                        Context context = getApplicationContext();
                        Toast toast = Toast.makeText(context,errorMsg,duration);
                        toast.show();

                    }

                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        edit3 = (EditText) findViewById(R.id.et3);
        decenas=edit3.getText().toString();

    }

    public void next(View view) {
         Intent intent3 = new Intent(this, CuartaActivity.class);
        // lanzo actividad 2 pero cuando t cierres voy a estar esperando datos
          my_ActivityResultLauncher.launch(intent3);
          finish();

    }

}