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
    /*Se crea una clase para listar perfiles de niñeras */
    public AdaptadorNineras(ArrayList<Nineras> nineraList) {
        this.nineraList = nineraList;
    }


    @NonNull
    @Override
    /*Se dice que los datos se van a poner dentro de una tarjeta, la tarjeta esta en el fragmento servi y devuleve la vista*/
    public ninerasView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_servi,parent,false);
        view.setOnClickListener(this);
        return new AdaptadorNineras.ninerasView(view);
    }

    @Override
    /*Se traen los datos de la Bd */
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
    /*Se hace enevento click para mandar a otra vista  */
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ninerasView extends RecyclerView.ViewHolder {
        /*Se listan las niñeras con su respectivo campo*/
        TextView nombreNinera,direccionNinera;
        public ninerasView(@NonNull View itemView) {
            super(itemView);
            nombreNinera = itemView.findViewById(R.id.itemNombreNinera);
            direccionNinera = itemView.findViewById(R.id.itemDireccionNinera);
        }
    }
}
