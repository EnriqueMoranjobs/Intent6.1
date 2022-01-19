package com.emoran.ejercicio61binario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edit1;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit1 = (EditText) findViewById(R.id.et1);
        button1 = (Button) findViewById(R.id.btn1);
    }

    public void avanza(View view) {

        Intent intent1 = new Intent(this, SegundaActivity.class);
        String centenas = edit1.getText().toString();
        intent1.putExtra("keycentenas", centenas);
        startActivity(intent1);


    }


}