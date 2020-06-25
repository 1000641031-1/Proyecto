package com.example.nas.ui.home;

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

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View vista= inflater.inflate(R.layout.fragment_home, container, false);
        Button reservar =vista.findViewById(R.id.btnReservar);
        Button solicitar =vista.findViewById(R.id.btnSolicitar);


        reservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.reservarninera);
            }
        });
        solicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findNavController(v).navigate(R.id.listar_perfiles);
            }
        });
        return vista;
    }
}
