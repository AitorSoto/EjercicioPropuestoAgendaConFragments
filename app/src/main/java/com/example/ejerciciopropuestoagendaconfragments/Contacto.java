package com.example.ejerciciopropuestoagendaconfragments;

import android.os.Parcel;
import android.os.Parcelable;

public class Contacto implements Parcelable {
    private String nombre;
    private String apellidos;
    private long numTelefono;
    private String correo;

    public Contacto() {

    }

    public Contacto(String nombre, String apellidos, long numTelefono, String correo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numTelefono = numTelefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public long getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(long numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", numTelefono=" + numTelefono +
                ", correo='" + correo + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.apellidos);
        dest.writeLong(this.numTelefono);
        dest.writeString(this.correo);
    }

    protected Contacto(Parcel in) {
        this.nombre = in.readString();
        this.apellidos = in.readString();
        this.numTelefono = in.readLong();
        this.correo = in.readString();
    }

    public static final Parcelable.Creator<Contacto> CREATOR = new Parcelable.Creator<Contacto>() {
        @Override
        public Contacto createFromParcel(Parcel source) {
            return new Contacto(source);
        }

        @Override
        public Contacto[] newArray(int size) {
            return new Contacto[size];
        }
    };
}
