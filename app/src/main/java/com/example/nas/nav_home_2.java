package com.example.nas;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static androidx.navigation.Navigation.findNavController;


/**
 * A simple {@link Fragment} subclass.
 *
 */
public class nav_home_2 extends Fragment {

    public nav_home_2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*Se le asigna una variable para los Button */
        View vista = inflater.inflate(R.layout.fragment_nav_home_2, container, false);
        Button eliminar = vista.findViewById(R.id.btneliminar);
        Button mostrar = vista.findViewById(R.id.btnmostrar);
        Button buscar = vista.findViewById(R.id.btnbuscarusu);

        /*Se llama la variable que se le asigno al botón y después se le selecciona el id del activity al cual se va a dirigir*/
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.nav_home2);
            }
        });
        /*Se llama la variable que se le asigno al botón y después se le selecciona el id del activity al cual se va a dirigir*/
        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.mostrar);
            }
        });
        /*Se llama la variable que se le asigno al botón y después se le selecciona el id del activity al cual se va a dirigir*/
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.buscarUsuario);
            }
        });
        return vista;
    }
}
