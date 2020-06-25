package com.example.nas.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nas.R;
import com.example.nas.entidades.Nineras;

import java.util.ArrayList;

public class AdaptadorNineras extends RecyclerView.Adapter<AdaptadorNineras.ninerasView>
    implements View.OnClickListener{

    private ArrayList<Nineras> nineraList;
    private View.OnClickListener listener;
    public AdaptadorNineras(ArrayList<Nineras> nineraList) {
        this.nineraList = nineraList;
    }


    @NonNull
    @Override
    public ninerasView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_servi,parent,false);
        view.setOnClickListener(this);
        return new AdaptadorNineras.ninerasView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ninerasView holder, int position) {
        Nineras nineras = nineraList.get(position);
        holder.nombreNinera.setText(nineras.getNombre());
        holder.direccionNinera.setText(nineras.getDireccion());
    }

    @Override
    public int getItemCount() {
        return nineraList.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ninerasView extends RecyclerView.ViewHolder {
        TextView nombreNinera,direccionNinera;
        public ninerasView(@NonNull View itemView) {
            super(itemView);
            nombreNinera = itemView.findViewById(R.id.itemNombreNinera);
            direccionNinera = itemView.findViewById(R.id.itemDireccionNinera);
        }
    }
}
