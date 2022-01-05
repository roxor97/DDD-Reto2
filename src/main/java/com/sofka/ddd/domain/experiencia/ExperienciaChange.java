package com.sofka.ddd.domain.experiencia;

import co.com.sofka.domain.generic.EventChange;
import com.sofka.ddd.domain.experiencia.events.*;

import java.util.HashSet;
import java.util.Objects;

public class ExperienciaChange  extends EventChange {
    public ExperienciaChange(Experiencia experiencia){
        apply((ExperienciaCreada event) -> {
            experiencia.experienciaLaboral = new HashSet<>();
            experiencia.idHojaDeVida = Objects.requireNonNull(event.getIdHojaDeVida());
        });

        apply((ExperienciaLaboralAgregada event)-> {
            experiencia.experienciaLaboral.add(new ExperienciaLaboral(
                    event.getIdExperienciaLaboral(),
                    event.getInstitucion(),
                    event.getPeriodo(),
                    event.getConocimientosAdquiridos()
            ));
        });

        apply((ExperienciaLaboralEliminada event) -> {
            var id = event.getIdExperienciaLaboral();
            experiencia.experienciaLaboral.removeIf(experienciaLaboral -> experienciaLaboral.identity().equals(id));
        });

    }
}
