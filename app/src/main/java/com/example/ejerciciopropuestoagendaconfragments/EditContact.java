package com.example.ejerciciopropuestoagendaconfragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import javax.xml.transform.Result;

public class EditContact extends AppCompatActivity {

    EditText nombre, apellidos, telefono, correo;
    Contacto c;
    int posicionLista;
    Button enviar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_contact);
        c = getIntent().getParcelableExtra("Contacto");
        nombre = (EditText)findViewById(R.id.nombreEditText);
        apellidos = (EditText)findViewById(R.id.apellidosEditText);
        telefono = (EditText)findViewById(R.id.telefonoEditText);
        correo = (EditText)findViewById(R.id.emailEditText);
        nombre.setText(c.getNombre());
        apellidos.setText(c.getApellidos());
        telefono.setText(String.valueOf(c.getNumTelefono()));
        correo.setText(c.getCorreo());
        enviar = (Button)findViewById(R.id.editarButton);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.setNombre(String.valueOf(nombre.getText()));
                c.setApellidos(String.valueOf(apellidos.getText()));
                c.setNumTelefono(Long.valueOf(String.valueOf(telefono.getText())));
                c.setCorreo(String.valueOf(correo.getText()));
                Intent intent = new Intent();
                intent.putExtra("SALIDA", c);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
