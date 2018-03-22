package com.example.stud.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        Button rbOpcja1;
        Button rbOpcja2;
        Spinner spinner;
    String[] planety = { "Merkury" , "Wenus" , "Ziemia" , "Mars" , "Jowisz" , "Saturn" , "Uran" , "Neptun" };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rbOpcja1 =  findViewById(R.id.rbOpcja1);
        rbOpcja2 =  findViewById(R.id.rbOpcja2);
        spinner =  findViewById(R.id.spinner);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String wartosc = "" ;
                RadioButton radio = (RadioButton) view;

                if(radio.isChecked()){
                    return;
                }



                if (view.getId() == R.id.rbOpcja1) {
                    wartosc = "wybrano Opcje 1";
                } else if (view.getId() == R.id.rbOpcja2) {
                    wartosc = "Wybrano opcje 2";
                }


                Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_SHORT).show();


            }
        };

        rbOpcja1.setOnClickListener(listener);
        rbOpcja2.setOnClickListener(listener);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, planety);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setSelection(2);

        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                String [] planety = getResources().getStringArray(R.array.planety);

                Toast.makeText(MainActivity.this, planety[i], Toast.LENGTH_SHORT).show();}
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

}
