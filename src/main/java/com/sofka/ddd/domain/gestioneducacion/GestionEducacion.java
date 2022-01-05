package com.sofka.ddd.domain.gestioneducacion;

import java.util.List;
import java.util.Objects;

import com.sofka.ddd.domain.generics.IdHojaDeVida;
import com.sofka.ddd.domain.generics.Institucion;
import com.sofka.ddd.domain.generics.Periodo;
import com.sofka.ddd.domain.gestioneducacion.events.EducacionAgregada;
import com.sofka.ddd.domain.gestioneducacion.events.GestionEducacionCreado;
import com.sofka.ddd.domain.gestioneducacion.events.TipoEducacionModificado;
import com.sofka.ddd.domain.gestioneducacion.values.Estudio;
import com.sofka.ddd.domain.gestioneducacion.values.IdEducacion;
import com.sofka.ddd.domain.gestioneducacion.values.IdGestionEducacion;
import com.sofka.ddd.domain.gestioneducacion.values.TarjetaProfesional;
import com.sofka.ddd.domain.gestioneducacion.values.Tipo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

public class GestionEducacion extends AggregateEvent<IdGestionEducacion> {

    protected Educacion educacion;
    protected IdHojaDeVida idHojaDeVida;

    public GestionEducacion(IdGestionEducacion entityId, IdHojaDeVida idHojaDeVida) {
        super(entityId);
        this.idHojaDeVida = Objects.requireNonNull(idHojaDeVida);
        appendChange(new GestionEducacionCreado(idHojaDeVida)).apply();
    }

    public GestionEducacion(IdGestionEducacion idGestionEducacion) {
        super(idGestionEducacion);
        subscribe(new GestionEducacionChange(this));
    }

    public static GestionEducacion from(IdGestionEducacion entityId, List<DomainEvent> events){
        var gestionEducacion = new GestionEducacion(entityId);
        events.forEach(gestionEducacion::applyEvent);
        return gestionEducacion;
    }

    public void agregarNuevaEducacion(TarjetaProfesional tarjetaProfesional, Tipo tipo, Estudio estudio, Institucion institucion, Periodo periodo) {
        var id = new IdEducacion();
        Objects.requireNonNull(tarjetaProfesional);
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(estudio);
        Objects.requireNonNull(institucion);
        Objects.requireNonNull(periodo);
        appendChange(new EducacionAgregada(id, tarjetaProfesional, tipo, estudio, institucion, periodo)).apply();
    }

    public void actualizarTipoEducacion(IdEducacion idEducacion, Tipo tipo){
        Objects.requireNonNull(idEducacion);
        Objects.requireNonNull(tipo);
        appendChange(new TipoEducacionModificado(idEducacion, tipo)).apply();
    }

    public Educacion educacion() {
        return educacion;
    }

    public IdHojaDeVida idHojaDeVida() {
        return idHojaDeVida;
    }
}
