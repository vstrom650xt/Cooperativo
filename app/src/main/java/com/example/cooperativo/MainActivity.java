package com.example.cooperativo;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String auxiliar;

    private Button btnEnviar;

    private RadioButton b1 ;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.radioButtonCiclismo);
        radioGroup = findViewById(R.id.radioGroup);

/*
        Bundle extra2 = getIntent().getExtras();
        String rkey2 = extra2.getString("name");
        String rkey3 = extra2.getString("age");

        System.out.println(rkey2);
        System.out.println(rkey3);


*/

        ActivityResultLauncher<Intent> someActivity = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),result -> {

            if(result.getResultCode() == RESULT_CANCELED)
                Toast.makeText(this, "Cancelado por el usuario", Toast.LENGTH_LONG).show();
            else if (result.getResultCode() == Activity.RESULT_OK) {
                Intent data = result.getData();
                String resulName = data.getExtras().getString("name");
                String resultAge= data.getExtras().getString("edad");

            }

        });



//recoger texto de un radiogrup
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int rdButonId= radioGroup.getCheckedRadioButtonId();
                View radioButon = radioGroup.findViewById(rdButonId);
                int indice = radioGroup.indexOfChild(radioButon);
                RadioButton rb = (RadioButton) radioGroup.getChildAt(indice);
                auxiliar = rb.getText().toString();
                System.out.println(auxiliar);

            }


        });


        btnEnviar = findViewById(R.id.enviarBoton);
        btnEnviar.setOnClickListener(view -> lanzarRdButton(null));

    }

    public void lanzarRdButton(View view){
        Intent i = new Intent(this,SecondActivity.class);
        i.putExtra("rd",auxiliar);
        startActivity(i);

    }

}