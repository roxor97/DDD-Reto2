package com.sofka.ddd.domain.experiencia.commands;

import com.sofka.ddd.domain.experiencia.values.IdExperienciaLaboral;

import co.com.sofka.domain.generic.Command;

public class EliminarExperienciaLaboral extends Command {
    private final IdExperienciaLaboral idExperienciaLaboral;

    public EliminarExperienciaLaboral(IdExperienciaLaboral idExperienciaLaboral) {
        this.idExperienciaLaboral = idExperienciaLaboral;
    }

    public IdExperienciaLaboral getIdExperienciaLaboral() {
        return idExperienciaLaboral;
    }
}
