package com.example.ejerciciopropuestoagendaconfragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{
    TextView txtNombre, txtApellidos, txtCorreo, txtTelefono;
    ImageView image;
    Contacto contacto;
    onImageClick listener;

    public Holder(@NonNull View itemView) {
        super(itemView);
        txtNombre = (TextView)itemView.findViewById(R.id.nombreTextView);
        txtApellidos = (TextView)itemView.findViewById(R.id.apellidosTextView);
        txtCorreo = (TextView)itemView.findViewById(R.id.correoTextView);
        txtTelefono = (TextView)itemView.findViewById(R.id.telefonoTextView);
        image = (ImageView)itemView.findViewById(R.id.imgContacto);
        image.setOnClickListener(this);
    }

    public void bind(Contacto contacto){
        txtNombre.setText(contacto.getNombre());
        txtApellidos.setText(contacto.getApellidos());
        txtCorreo.setText(contacto.getCorreo());
        txtTelefono.setText(String.valueOf(contacto.getNumTelefono()));
    }

    public void setClickImage(onImageClick listener){
        if (listener!=null)
            this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener!=null)
            listener.onImageClickListener(contacto, v);
    }
}
