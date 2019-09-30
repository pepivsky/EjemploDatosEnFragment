package com.example.ejemplodatosenfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    TextView datoFragment;
    Button botonFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myfragment_layout,container,false);
        //Recibir datos del bundle
        Bundle bundle = getArguments();
        String dato = bundle.getString("datoEDT","valorPorDeefault");
        final int num = bundle.getInt("numero",0);

        datoFragment = (TextView) view.findViewById(R.id.DatoFragment);
        botonFragment = (Button) view.findViewById(R.id.botonFragment);

        //Asignar el dato del Activity al Fragment
        datoFragment.setText(dato);

        botonFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datoFragment.setText(String.valueOf(num));


            }
        });

        return view;
    }
}
