package com.example.nas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import static androidx.navigation.Navigation.findNavController;


/**
 * A simple {@link Fragment} subclass.
 */
public class nav_home1 extends Fragment {

    public nav_home1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_nav_home1, container, false);

        Button solicitudes_ninera_1 = vista.findViewById(R.id.btnsolicitudes);
        Button reservas_ninera_1 = vista.findViewById(R.id.btnmis_reservas);

        solicitudes_ninera_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.listar_ninera);
            }
        });
        reservas_ninera_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.listar_reservas);
            }
        });
        return vista;
    }
}

