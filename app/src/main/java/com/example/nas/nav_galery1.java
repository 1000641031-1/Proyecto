package com.example.nas;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nas.ui.gallery.GalleryViewModel;

import static androidx.navigation.Navigation.findNavController;


public class nav_galery1 extends Fragment {

    private GalleryViewModel galleryViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista= inflater.inflate(R.layout.fragment_nav_galery1, container, false);

        /*Se le asigna una variable para los Button */
        Button actualizarninera=vista.findViewById(R.id.btnActualizarninera1);
        Button cambiarninera=vista.findViewById(R.id.btnCambiarninera);
        /*Se llama la variable que se le asigno al botón y después se le selecciona el id del activity al cual se va a dirigir*/
        actualizarninera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.actualizarninera);
            }
        });
        /*Se llama la variable que se le asigno al botón y después se le selecciona el id del activity al cual se va a dirigir*/
        cambiarninera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.cambiarninera);
            }
        });



        return vista;
    }
}
