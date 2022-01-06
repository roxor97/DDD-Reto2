package com.sofka.ddd.domain.experiencia.commands;

import java.util.Objects;

import com.sofka.ddd.domain.experiencia.values.IdExperiencia;
import com.sofka.ddd.domain.generics.IdHojaDeVida;

import co.com.sofka.domain.generic.Command;

public class CrearExperienciaLaboral extends Command {
    private final IdHojaDeVida idHojaDeVida;

    public CrearExperienciaLaboral(IdHojaDeVida idHojaDeVida) {
        this.idHojaDeVida = Objects.requireNonNull(idHojaDeVida);
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }

    public IdExperiencia getIdExperiencia() {
        return new IdExperiencia();
    }
}
