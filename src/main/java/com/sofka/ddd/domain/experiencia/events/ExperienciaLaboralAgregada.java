package com.sofka.ddd.domain.experiencia.events;

import com.sofka.ddd.domain.experiencia.values.ConocimientosAdqueridos;
import com.sofka.ddd.domain.experiencia.values.IdExperienciaLaboral;
import com.sofka.ddd.domain.generics.Institucion;
import com.sofka.ddd.domain.generics.Periodo;

import co.com.sofka.domain.generic.DomainEvent;

public class ExperienciaLaboralAgregada extends DomainEvent {
    private final IdExperienciaLaboral idExperienciaLaboral;
    private final Institucion institucion;
    private final ConocimientosAdqueridos conocimientosAdqueridos;
    private final Periodo periodo;
    

    public ExperienciaLaboralAgregada(IdExperienciaLaboral idExperienciaLaboral, Institucion institucion, Periodo periodo, ConocimientosAdqueridos conocimientosAdqueridos) {
        super("sofka.ddd.experienciaLaboralAgregada");
        this.idExperienciaLaboral = idExperienciaLaboral;
        this.institucion = institucion;
        this.periodo = periodo;
        this.conocimientosAdqueridos = conocimientosAdqueridos;
    }

    public IdExperienciaLaboral getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public ConocimientosAdqueridos getConocimientosAdquiridos() {
        return conocimientosAdqueridos;
    }
}
