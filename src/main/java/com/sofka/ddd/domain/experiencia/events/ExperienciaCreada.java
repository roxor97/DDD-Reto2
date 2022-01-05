package com.sofka.ddd.domain.experiencia.events;

import java.util.Set;

import com.sofka.ddd.domain.experiencia.ExperienciaLaboral;
import com.sofka.ddd.domain.generics.IdHojaDeVida;

import co.com.sofka.domain.generic.DomainEvent;

public class ExperienciaCreada extends DomainEvent {
    private final IdHojaDeVida idHojaDeVida;
    private final Set<ExperienciaLaboral> experienciaLaboral;

    public ExperienciaCreada(IdHojaDeVida idHojaDeVida, Set<ExperienciaLaboral> experienciaLaboral) {
        super("sofka.ddd.experienciacreada");
        this.idHojaDeVida = idHojaDeVida;
        this.experienciaLaboral = experienciaLaboral;
    }

    public Set<ExperienciaLaboral> getExperienciaLaboral() {
        return experienciaLaboral;
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }
}
