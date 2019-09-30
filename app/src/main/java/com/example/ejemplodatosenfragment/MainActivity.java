package com.example.ejemplodatosenfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText dato;
    Button enviarDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dato = (EditText)findViewById(R.id.Dato);
        enviarDato = (Button)findViewById(R.id.EnviarDato);


        enviarDato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Pasar el dato del editText al fragment
                int numero = 19;
                String informacion = dato.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("datoEDT", informacion);
                bundle.putInt("numero",numero);


                //Crear fragment

                FragmentManager fragmentManager = getSupportFragmentManager();
                MyFragment fragment  = new MyFragment();
                fragment.setArguments(bundle); //Recibir el dato en el fragment
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.add(R.id.contenedorFragment, fragment);
                transaction.commit();

            }
        });
    }
}
