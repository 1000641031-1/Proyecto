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
        Button actualizarninera=vista.findViewById(R.id.btnActualizarninera1);
        Button cambiarninera=vista.findViewById(R.id.btnCambiarninera);

        actualizarninera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.actualizarninera);
            }
        });
        cambiarninera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.cambiarninera);
            }
        });



        return vista;
    }
}
