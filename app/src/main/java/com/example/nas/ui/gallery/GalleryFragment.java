package com.example.nas.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.nas.R;

import static androidx.navigation.Navigation.findNavController;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View vista= inflater.inflate(R.layout.fragment_gallery, container, false);
        Button actualizarpadre =vista.findViewById(R.id.actualizarpadre);
        Button cambiarpadre=vista.findViewById(R.id.cambiarpadre);

        actualizarpadre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.actualizarpadre2);
            }
        });
        cambiarpadre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.cambiarpadre3);
            }
        });
        return vista;
    }
}
