package com.sofka.ddd.domain.gestioneducacion;

import com.sofka.ddd.domain.gestioneducacion.events.*;

import co.com.sofka.domain.generic.EventChange;

public class GestionEducacionChange extends EventChange {
    public GestionEducacionChange(GestionEducacion gestionEducacion) {

        apply((GestionEducacionCreado event)->{
            gestionEducacion.idHojaDeVida = event.getHojaDeVidaId();
        });

        apply((EducacionAgregada event)->{
            gestionEducacion.educacion = new Educacion(
                    event.getId(),
                    event.getTarjetaProfesional(),
                    event.getTipo(),
                    event.getEstudio(),
                    event.getInstitucion(),
                    event.getPeriodo()
            );
        });

        apply((TipoEducacionModificado event)->{
            gestionEducacion.educacion.tipo = event.getTipo();
        });

    }
}
