package com.example.cooperativo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity{

    private Button btnAceptar,btnCancelar;
    private EditText editTextNombre, editTextEdad;
    String auxNom,auxEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second); //espabila billy

        Bundle extra = getIntent().getExtras();
        String rkey = extra.getString("rd");
        ActivityResultLauncher<Intent> someActivity = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {});
        btnAceptar = findViewById(R.id.aceptarButton);
        
        btnAceptar.setOnClickListener(view -> lanzarAceptarButton(null));
        


    }


    public void lanzarAceptarButton(View view){
        Intent i = new Intent(this,MainActivity.class);
        i.putExtra("name",auxNom);
        i.putExtra("edad",auxEdad);

        System.out.println(auxNom + "     " + auxEdad);
        startActivity(i);

    }
/*
    public void lanzarCancelarButton(View view){
        Intent i = new Intent(this,MainActivity.class);
        Toast.makeText(this, "operacion cancelada", Toast.LENGTH_SHORT).show();
    }

 */
}
