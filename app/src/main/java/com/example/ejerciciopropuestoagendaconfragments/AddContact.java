package com.example.ejerciciopropuestoagendaconfragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddContact extends Fragment {

    EditText nombre, apellidos, email, telefono;
    FloatingActionButton fab;
    listenerAdd listenerAdd;
    Contacto contacto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View r = inflater.inflate(R.layout.add_contact, container, false);
        nombre = (EditText)r.findViewById(R.id.nombreEditText2);
        apellidos = (EditText)r.findViewById(R.id.apellidosEditText2);
        email = (EditText)r.findViewById(R.id.emailEditText2);
        telefono = (EditText)r.findViewById(R.id.telefonoEditText2);
        fab = (FloatingActionButton)r.findViewById(R.id.fabAdd);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacto c = new Contacto();
                c.setNombre(String.valueOf(nombre.getText()));
                c.setApellidos(String.valueOf(apellidos.getText()));
                c.setNumTelefono(Long.valueOf(String.valueOf(telefono.getText())));
                c.setCorreo(String.valueOf(email.getText()));
                listenerAdd.onSelectedItemAdd(contacto);
            }
        });

        return r;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listenerAdd = (com.example.ejerciciopropuestoagendaconfragments.listenerAdd) context;
    }


    /*@Override
    public View onCreateView(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }*/
}
