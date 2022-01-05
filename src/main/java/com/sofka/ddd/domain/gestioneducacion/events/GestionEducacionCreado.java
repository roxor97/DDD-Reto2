package com.sofka.ddd.domain.gestioneducacion.events;

import com.sofka.ddd.domain.generics.IdHojaDeVida;

import co.com.sofka.domain.generic.DomainEvent;

public class GestionEducacionCreado extends DomainEvent {

    private final IdHojaDeVida idHojaDeVida;

    public GestionEducacionCreado(IdHojaDeVida idHojaDeVida) {
        super("sofka.ddd.gestioneducacion.gestioneducacioncreada");
        this.idHojaDeVida = idHojaDeVida;
    }

    public IdHojaDeVida getHojaDeVidaId() {
        return idHojaDeVida;
    }
}