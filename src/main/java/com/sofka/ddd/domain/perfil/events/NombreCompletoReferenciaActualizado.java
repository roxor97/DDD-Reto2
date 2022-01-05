package com.sofka.ddd.domain.perfil.events;

import com.sofka.ddd.domain.generics.NombreCompleto;
import com.sofka.ddd.domain.perfil.values.IdPerfil;
import com.sofka.ddd.domain.perfil.values.IdReferencia;

import co.com.sofka.domain.generic.Command;

public class NombreCompletoReferenciaActualizado extends Command {

    private final IdPerfil idPerfil;
    private final IdReferencia idReferencia;
    private final NombreCompleto nombreCompleto;

    public NombreCompletoReferenciaActualizado(IdPerfil idPerfil, IdReferencia IdReferencia, NombreCompleto nombreCompleto) {
        this.idPerfil = idPerfil;
        this.idReferencia = IdReferencia;
        this.nombreCompleto = nombreCompleto;
    }

    public IdPerfil getidPerfil() {
        return idPerfil;
    }

    public IdReferencia getIdReferencia() {
        return idReferencia;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
