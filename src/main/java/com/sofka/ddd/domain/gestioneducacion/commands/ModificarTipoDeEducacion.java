package com.sofka.ddd.domain.gestioneducacion.commands;

import com.sofka.ddd.domain.gestioneducacion.values.IdEducacion;
import com.sofka.ddd.domain.gestioneducacion.values.IdGestionEducacion;
import com.sofka.ddd.domain.gestioneducacion.values.Tipo;

import co.com.sofka.domain.generic.Command;

public class ModificarTipoDeEducacion extends Command {

    private final IdGestionEducacion idGestionEducacion ;
    private final IdEducacion idEducacion;
    private final Tipo tipo;

    public ModificarTipoDeEducacion(IdGestionEducacion idGestionEducacion, IdEducacion idEducacion, Tipo tipo) {
        this.idGestionEducacion = idGestionEducacion;
        this.idEducacion = idEducacion;
        this.tipo = tipo;
    }

    public IdGestionEducacion getIdGestionEducacion() {
        return idGestionEducacion;
    }

    public IdEducacion getIdEducacion() {
        return idEducacion;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
