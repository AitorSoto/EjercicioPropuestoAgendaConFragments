package com.example.ejerciciopropuestoagendaconfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FragmentPrincipal extends Fragment {
    RecyclerView recyclerView;
    Adaptador adaptador;
    FloatingActionButton fab;
    SwipeDetector swipeDetector;
    TextView nombreContactoDialogo;
    int posicionContactoEnLista;
    public final ArrayList<Contacto> contactos;

    public FragmentPrincipal(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View r = inflater.inflate(R.layout.fragment_recycler, container, false);

        nombreContactoDialogo = (TextView)r.findViewById(R.id.nombreContacto);
        swipeDetector = new SwipeDetector();
        recyclerView = (RecyclerView)r.findViewById(R.id.recyclerView);
        adaptador = new Adaptador(contactos);
        recyclerView.setAdapter(adaptador);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        fab = (FloatingActionButton)r.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager FM = getActivity().getSupportFragmentManager();
                FragmentTransaction FT = FM.beginTransaction();

                Fragment fragmentLista = new AddContact();
                FT.replace(R.id.fragment_container, fragmentLista);
                FT.commit();
            }
        });
        return r;
    }
}
