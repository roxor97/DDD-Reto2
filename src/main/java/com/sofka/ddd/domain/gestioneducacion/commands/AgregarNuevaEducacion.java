package com.sofka.ddd.domain.gestioneducacion.commands;

import com.sofka.ddd.domain.gestioneducacion.values.IdGestionEducacion;
import com.sofka.ddd.domain.gestioneducacion.values.TarjetaProfesional;
import com.sofka.ddd.domain.gestioneducacion.values.Tipo;
import com.sofka.ddd.domain.generics.Institucion;
import com.sofka.ddd.domain.generics.Periodo;
import com.sofka.ddd.domain.gestioneducacion.values.Estudio;
import com.sofka.ddd.domain.gestioneducacion.values.IdEducacion;

import co.com.sofka.domain.generic.Command;

public class AgregarNuevaEducacion extends Command {

    private final IdGestionEducacion idGestionEducacion ;
    private final IdEducacion idEducacion;
    private final TarjetaProfesional tarjetaProfesional;
    private final Tipo tipo;
    private final Estudio estudio;
    private final Institucion institucion;
    private final Periodo periodo;

    public AgregarNuevaEducacion(IdGestionEducacion idGestionEducacion , IdEducacion idEducacion, TarjetaProfesional tarjetaProfesional, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        this.idGestionEducacion  = idGestionEducacion ;
        this.idEducacion = idEducacion;
        this.tarjetaProfesional = tarjetaProfesional;
        this.tipo = tipo;
        this.estudio = estudio;
        this.institucion = institucion;
        this.periodo = periodo;
    }

    public IdGestionEducacion  getIdGestionEduIdGestionEducacion () {
        return idGestionEducacion ;
    }

    public IdEducacion getEducacionId() {
        return idEducacion;
    }

    public TarjetaProfesional getTarjetaProfesional() {
        return tarjetaProfesional;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public Institucion getInstitucion() {
        return institucion;
    }

    public Periodo getPeriodo() {
        return periodo;
    }
}
