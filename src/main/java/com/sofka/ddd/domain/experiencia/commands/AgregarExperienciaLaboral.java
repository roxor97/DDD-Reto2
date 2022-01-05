package com.sofka.ddd.domain.experiencia.commands;

import com.sofka.ddd.domain.experiencia.values.IdExperiencia;
import com.sofka.ddd.domain.experiencia.values.IdExperienciaLaboral;
import com.sofka.ddd.domain.experiencia.values.ConocimientosAdqueridos;
import com.sofka.ddd.domain.generics.Institucion;
import com.sofka.ddd.domain.generics.Periodo;

import co.com.sofka.domain.generic.Command;

public class AgregarExperienciaLaboral extends Command {
    private final IdExperiencia idExperiencia;
    private final IdExperienciaLaboral idExperienciaLaboral;
    private final Institucion institucion;
    private final ConocimientosAdqueridos conocimientosAdqueridos;
    private final Periodo periodo;
    

    public AgregarExperienciaLaboral( IdExperiencia idExperiencia,IdExperienciaLaboral idExperienciaLaboral, Institucion institucion, Periodo periodo, ConocimientosAdqueridos conocimientosAdqueridos) {
        this.idExperiencia = idExperiencia;
        this.idExperienciaLaboral = idExperienciaLaboral;
        this.institucion = institucion;
        this.periodo = periodo;
        this.conocimientosAdqueridos = conocimientosAdqueridos;
    }

    public IdExperiencia getIdExperiencia() {
        return idExperiencia;
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

    public ConocimientosAdqueridos getConocimientosAdqueridos() {
        return conocimientosAdqueridos;
    }
}
