package com.sofka.ddd.domain.perfil;



import java.util.Objects;

import com.sofka.ddd.domain.generics.NombreCompleto;
import com.sofka.ddd.domain.perfil.values.IdReferencia;
import com.sofka.ddd.domain.perfil.values.InfoContacto;

import co.com.sofka.domain.generic.Entity;

public class Referencia extends Entity<IdReferencia> {

    private final InfoContacto infoContacto;
    private NombreCompleto nombreCompleto;
    public Referencia(IdReferencia idReferencia, InfoContacto infoContacto, NombreCompleto nombreCompleto) {
        super(idReferencia);
        this.infoContacto = Objects.requireNonNull(infoContacto);
        this.nombreCompleto = Objects.requireNonNull(nombreCompleto);
    }

    public void actualizarNombreCompleto(String nombre, String apellido){
        Objects.requireNonNull(nombre);
        Objects.requireNonNull(apellido);
        this.nombreCompleto = this.nombreCompleto.actualizarNombreCompleto(nombre,apellido);
    }

    public InfoContacto infoContacto() {
        return infoContacto;
    }

    public NombreCompleto nombreCompleto() {
        return nombreCompleto;
    }
}
