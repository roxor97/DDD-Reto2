package com.sofka.ddd.domain.experiencia.events;

import com.sofka.ddd.domain.experiencia.values.IdExperienciaLaboral;

import co.com.sofka.domain.generic.DomainEvent;

public class ExperienciaLaboralEliminada extends DomainEvent {
    private final IdExperienciaLaboral idExperienciaLaboral;

    public ExperienciaLaboralEliminada(IdExperienciaLaboral idExperienciaLaboral) {
        super("sofka.ddd.experiencialaboraleliminada");
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    public IdExperienciaLaboral getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }
}
