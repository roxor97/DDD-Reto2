package com.sofka.ddd.domain.experiencia;

import java.util.List;
import java.util.Set;

import com.sofka.ddd.domain.experiencia.events.ExperienciaCreada;
import com.sofka.ddd.domain.experiencia.events.ExperienciaLaboralAgregada;
import com.sofka.ddd.domain.experiencia.events.ExperienciaLaboralEliminada;
import com.sofka.ddd.domain.experiencia.values.ConocimientosAdqueridos;
import com.sofka.ddd.domain.experiencia.values.IdExperiencia;
import com.sofka.ddd.domain.experiencia.values.IdExperienciaLaboral;
import com.sofka.ddd.domain.generics.IdHojaDeVida;
import com.sofka.ddd.domain.generics.Institucion;
import com.sofka.ddd.domain.generics.Periodo;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

public class Experiencia extends AggregateEvent<IdExperiencia> {
    protected IdHojaDeVida idHojaDeVida;
    protected  Set<ExperienciaLaboral> experienciaLaboral;

    public Experiencia(IdExperiencia idExperiencia, IdHojaDeVida idHojaDeVida, Set<ExperienciaLaboral> experienciaLaboral){
        super(idExperiencia);
        subscribe(new ExperienciaChange(this));
        appendChange(new ExperienciaCreada(idHojaDeVida, experienciaLaboral)).apply();
    }

    private Experiencia(IdExperiencia idExperiencia){
        super(idExperiencia);
        subscribe(new ExperienciaChange(this));
    }

    public static Experiencia from(IdExperiencia idExperiencia, List<DomainEvent> events){
        var experiencia = new Experiencia(idExperiencia);
        events.forEach(experiencia::applyEvent);
        return experiencia;
    }

    public void agregarExperienciaLaboral(Institucion institucion, Periodo periodo, ConocimientosAdqueridos conocimientosAdquiridos){
        var id = new IdExperienciaLaboral();
        appendChange(new ExperienciaLaboralAgregada(id,institucion,periodo,conocimientosAdquiridos)).apply();
    }

    public void eliminarExperienciaLaboral(IdExperienciaLaboral idExperienciaLaboral){
        appendChange(new ExperienciaLaboralEliminada(idExperienciaLaboral)).apply();
    }

    public IdHojaDeVida idHojaDeVida() {
        return idHojaDeVida;
    }

    public Set<ExperienciaLaboral> experienciaLaboral() {
        return experienciaLaboral;
    }
}
