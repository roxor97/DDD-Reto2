package com.sofka.ddd.domain.perfil.events;

import com.sofka.ddd.domain.perfil.values.IdReferencia;

import co.com.sofka.domain.generic.DomainEvent;

public class ReferenciaEliminada extends DomainEvent{
    private final IdReferencia idReferencia;

    public ReferenciaEliminada(IdReferencia idReferencia){
        super("sofka.ddd.referenciaeliminada");
        this.idReferencia = idReferencia;
    }

    public IdReferencia getIdReferencia() {
        return idReferencia;
    }
}
