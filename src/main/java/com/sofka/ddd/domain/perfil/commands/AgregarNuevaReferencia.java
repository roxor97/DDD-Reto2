package com.sofka.ddd.domain.perfil.commands;

import com.sofka.ddd.domain.generics.NombreCompleto;
import com.sofka.ddd.domain.perfil.values.IdPerfil;
import com.sofka.ddd.domain.perfil.values.IdReferencia;
import com.sofka.ddd.domain.perfil.values.InfoContacto;

import co.com.sofka.domain.generic.Command;

public class AgregarNuevaReferencia extends Command {
    private final IdPerfil idPerfil;
    private final IdReferencia idReferencia;
    private final InfoContacto infoContacto;
    private final NombreCompleto nombreCompleto;

    public AgregarNuevaReferencia(IdPerfil idPerfil,IdReferencia idReferencia, InfoContacto infoContacto, NombreCompleto nombreCompleto) {
        this.idPerfil = idPerfil;
        this.idReferencia = idReferencia;
        this.infoContacto = infoContacto;
        this.nombreCompleto = nombreCompleto;
    }

    public IdPerfil getIdPerfil() {
        return idPerfil;
    }

    public IdReferencia getIdReferencia() {
        return idReferencia;
    }

    public InfoContacto getInfoContacto() {
        return infoContacto;
    }

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }
}
