package com.sofka.ddd.domain.gestioneducacion.commands;

import com.sofka.ddd.domain.generics.IdHojaDeVida;
import com.sofka.ddd.domain.gestioneducacion.values.IdGestionEducacion;

import co.com.sofka.domain.generic.Command;

public class CrearGestionEducacion  extends Command {

    private final IdGestionEducacion idGestionEducacion ;
    private final IdHojaDeVida idHojaDeVida;

    public CrearGestionEducacion(IdGestionEducacion idGestionEducacion, IdHojaDeVida idHojaDeVida) {
        this.idGestionEducacion = idGestionEducacion;
        this.idHojaDeVida = idHojaDeVida;
    }

    public IdGestionEducacion getIdGestionEducacion() {
        return idGestionEducacion;
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }
}
