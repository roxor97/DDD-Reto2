package com.sofka.ddd.domain.perfil.commands;

import java.util.Objects;

import com.sofka.ddd.domain.generics.IdHojaDeVida;
import com.sofka.ddd.domain.perfil.values.FotoDePerfil;
import com.sofka.ddd.domain.perfil.values.IdPerfil;
import com.sofka.ddd.domain.perfil.values.InfoContacto;

import co.com.sofka.domain.generic.Command;

public class CrearPerfil extends Command {
    private final IdPerfil idPerfil;
    private final IdHojaDeVida idHojaDeVida;
    private final InfoContacto infoContacto;
    private final FotoDePerfil fotoDePerfil;

    public CrearPerfil(IdPerfil idPerfil,IdHojaDeVida idHojaDeVida, InfoContacto infoContacto, FotoDePerfil fotoDePerfil) {
        this.idPerfil = Objects.requireNonNull(idPerfil);
        this.idHojaDeVida = Objects.requireNonNull(idHojaDeVida);
        this.infoContacto = Objects.requireNonNull(infoContacto);
        this.fotoDePerfil = Objects.requireNonNull(fotoDePerfil);
    }

    public IdPerfil getIdPerfil() {
        return idPerfil;
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }

    public InfoContacto getInfoContacto() {
        return infoContacto;
    }

    public FotoDePerfil getFotoDePerfil() {
        return fotoDePerfil;
    }
}
