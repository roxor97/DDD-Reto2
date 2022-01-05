package com.sofka.ddd.domain.experiencia;

import java.util.Objects;

import com.sofka.ddd.domain.experiencia.values.ConocimientosAdqueridos;
import com.sofka.ddd.domain.experiencia.values.IdExperienciaLaboral;
import com.sofka.ddd.domain.generics.Institucion;
import com.sofka.ddd.domain.generics.Periodo;

import co.com.sofka.domain.generic.Entity;

public class ExperienciaLaboral extends Entity<IdExperienciaLaboral> {
    private final Institucion institucion;
    private ConocimientosAdqueridos conocimientosAdqueridos;
    private final Periodo periodo;
    

    public ExperienciaLaboral(IdExperienciaLaboral idExperienciaLaboral, Institucion institucion, Periodo periodo, ConocimientosAdqueridos conocimientosAdquiridos) {
        super(idExperienciaLaboral);
        this.institucion = Objects.requireNonNull(institucion);
        this.periodo = Objects.requireNonNull(periodo);
        this.conocimientosAdqueridos = Objects.requireNonNull(conocimientosAdquiridos);
    }

    public void modificarConocimientosAdquiridos(String conocimientos){
        Objects.requireNonNull(conocimientos);
        this.conocimientosAdqueridos = this.conocimientosAdqueridos.modificarConocimientosAdqueridos(conocimientos);
    }

    public Institucion institucion() {
        return institucion;
    }

    public Periodo periodo() {
        return periodo;
    }

    public ConocimientosAdqueridos conocimientosAdquiridos() {
        return conocimientosAdqueridos;
    }
}
