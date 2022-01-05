package com.sofka.ddd.domain.gestioneducacion;

import java.util.Objects;

import com.sofka.ddd.domain.generics.Institucion;
import com.sofka.ddd.domain.generics.Periodo;
import com.sofka.ddd.domain.gestioneducacion.values.Estudio;
import com.sofka.ddd.domain.gestioneducacion.values.IdEducacion;
import com.sofka.ddd.domain.gestioneducacion.values.TarjetaProfesional;
import com.sofka.ddd.domain.gestioneducacion.values.Tipo;

import co.com.sofka.domain.generic.Entity;

public class Educacion extends Entity<IdEducacion> {

    protected TarjetaProfesional tarjetaProfesional;
    protected Tipo tipo;
    protected Estudio estudio;
    protected Institucion institucion;
    protected Periodo periodo;

    public Educacion(IdEducacion entityId, TarjetaProfesional tarjetaProfesional, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        super(entityId);
        this.tarjetaProfesional = tarjetaProfesional;
        this.tipo = tipo;
        this.estudio = estudio;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public void actualizarTipo(Tipo tipo){
        Objects.requireNonNull(tipo);
        this.tipo = tipo;
    }

    public TarjetaProfesional tarjetaProfesional() {
        return tarjetaProfesional;
    }

    public Tipo tipo() {
        return tipo;
    }

    public Estudio estudio() {
        return estudio;
    }

    public Institucion institucion() {
        return institucion;
    }

    public Periodo periodo() {
        return periodo;
    }
}
