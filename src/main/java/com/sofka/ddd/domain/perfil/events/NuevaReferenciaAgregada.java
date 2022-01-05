package com.sofka.ddd.domain.perfil.events;

import com.sofka.ddd.domain.generics.NombreCompleto;
import com.sofka.ddd.domain.perfil.values.IdReferencia;
import com.sofka.ddd.domain.perfil.values.InfoContacto;

import co.com.sofka.domain.generic.DomainEvent;

public class NuevaReferenciaAgregada extends DomainEvent {
    private final IdReferencia idReferencia;
    private final InfoContacto infoContacto;
    private final NombreCompleto nombreCompleto;

    public NuevaReferenciaAgregada(IdReferencia idReferencia, InfoContacto infoContacto, NombreCompleto nombreCompleto){
        super("sofka.ddd.nuevareferenciaagregada");
        this.idReferencia = idReferencia;
        this.infoContacto = infoContacto;
        this.nombreCompleto = nombreCompleto;
    }

    public IdReferencia getIdReferencia() {
        return idReferencia;
    }

    public InfoContacto getInfoContacto() {
        return infoContacto;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
