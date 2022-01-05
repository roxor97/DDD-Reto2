package com.sofka.ddd.domain.perfil.commands;

import com.sofka.ddd.domain.perfil.values.IdReferencia;

import co.com.sofka.domain.generic.Command;

public class EliminarReferencia extends Command {
    private final IdReferencia idReferencia;

    public EliminarReferencia(IdReferencia idReferencia) {
        this.idReferencia = idReferencia;
    }

    public IdReferencia getIdReferencia() {
        return idReferencia;
    }
}
