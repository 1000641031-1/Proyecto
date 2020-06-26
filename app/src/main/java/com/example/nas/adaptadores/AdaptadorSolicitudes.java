package com.example.nas.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nas.R;
import com.example.nas.entidades.solicitudNinera;

import java.util.ArrayList;

public class AdaptadorSolicitudes extends RecyclerView.Adapter<AdaptadorSolicitudes.solicitudesView> {

    /*Se declara la array*/
    private ArrayList<solicitudNinera>solicitudNineraList;
    /*Se crea una clase para listar solicitudes */
    public AdaptadorSolicitudes(ArrayList<solicitudNinera> solicitudNineraList) {
        this.solicitudNineraList = solicitudNineraList;
    }

    @NonNull
    @Override
    /*Se dice que los datos se van a poner dentro de una tarjeta, la tarjeta esta en el fragmento soli y devuleve la vista*/
    public solicitudesView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_soli,parent,false);
        return new solicitudesView(view);
    }

    @Override
    /*Se traen los datos de la Bd */
    public void onBindViewHolder(@NonNull solicitudesView holder, int position) {
        solicitudNinera solicitud = solicitudNineraList.get(position);
        holder.cantidadS.setText("Cantidad de niños: "+solicitud.getCantidad_solicitud().toString());
        holder.horasS.setText("Cantidad de horas:"+solicitud.getHora_solicitud());
        holder.precioS.setText("Precio: "+solicitud.getPrecio_solicitud().toString());
        holder.recomendacionS.setText("Recomendaciones: "+solicitud.getEspecificar_solicitud());

    }

    @Override
    public int getItemCount() {
        return solicitudNineraList.size();
    }
    /*Se listan las solicitudes con su respectivo campo*/
    public class solicitudesView extends RecyclerView.ViewHolder {
        private TextView cantidadS,precioS,horasS,recomendacionS;
        public solicitudesView(@NonNull View itemView) {
            super(itemView);
            cantidadS = itemView.findViewById(R.id.cantidad_ninos_ninera);
            precioS = itemView.findViewById(R.id.precio_ninera);
            horasS = itemView.findViewById(R.id.numero_de_horas_ninera);
            recomendacionS = itemView.findViewById(R.id.recomendacion_ninera);
        }
    }
}
