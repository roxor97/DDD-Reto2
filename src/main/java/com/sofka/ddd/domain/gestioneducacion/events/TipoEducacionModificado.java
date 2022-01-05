package com.sofka.ddd.domain.gestioneducacion.events;

import com.sofka.ddd.domain.gestioneducacion.values.IdEducacion;
import com.sofka.ddd.domain.gestioneducacion.values.Tipo;

import co.com.sofka.domain.generic.DomainEvent;

public class TipoEducacionModificado extends DomainEvent {
    private final IdEducacion idEducacion;
    private final Tipo tipo;

    public TipoEducacionModificado(IdEducacion idEducacion, Tipo tipo) {
        super("sofka.ddd.gestioneducacion.tipoeducacionmodificado");
        this.idEducacion = idEducacion;
        this.tipo = tipo;
    }

    public IdEducacion getEducacionId() {
        return idEducacion;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
