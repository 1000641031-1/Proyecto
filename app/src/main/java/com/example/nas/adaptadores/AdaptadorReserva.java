package com.example.nas.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nas.R;
import com.example.nas.entidades.solicitudReserva;

import java.util.ArrayList;

public class AdaptadorReserva extends RecyclerView.Adapter<AdaptadorReserva.reservaView> {

    private ArrayList<solicitudReserva> solicitudReservaList;

    public AdaptadorReserva(ArrayList<solicitudReserva> solicitudReservaList) {
        this.solicitudReservaList = solicitudReservaList;
    }

    @NonNull
    @Override
    public AdaptadorReserva.reservaView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_reser,parent,false);
        return new AdaptadorReserva.reservaView(view);

    }

    @Override
    public void onBindViewHolder(@NonNull  AdaptadorReserva.reservaView holder, int position) {
        solicitudReserva reserva = solicitudReservaList.get(position);
        holder.cantidadR.setText("Cantidad de niños: "+reserva.getCantidad_reservar());
        holder.numero_horasR.setText("Cantidad de horas:"+reserva.getnumero_horas());
        holder.precioR.setText("Precio sugerido: "+reserva.getPrecio_reservar());
        holder.horasR.setText("Hora : "+reserva.getHora_reservar());
        holder.fechaR.setText("Fecha: "+reserva.getFecha_reservar());

    }


    @Override
    public int getItemCount() {
        return solicitudReservaList.size();
    }


    public class reservaView extends RecyclerView.ViewHolder {
        private TextView cantidadR,precioR,horasR,fechaR,numero_horasR;
        public reservaView(@NonNull View itemView) {
            super(itemView);
            cantidadR = itemView.findViewById(R.id.cantidad_reserva);
            numero_horasR = itemView.findViewById(R.id.numero_horas_reserva);
            precioR = itemView.findViewById(R.id.precio_reserva);
            horasR = itemView.findViewById(R.id.hora_reserva);
            fechaR = itemView.findViewById(R.id.fecha_reserva);



        }
    }
}

