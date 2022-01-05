package com.sofka.ddd.domain.perfil.events;

import com.sofka.ddd.domain.generics.IdHojaDeVida;
import com.sofka.ddd.domain.perfil.values.FotoDePerfil;
import com.sofka.ddd.domain.perfil.values.InfoContacto;

import co.com.sofka.domain.generic.DomainEvent;

public class PerfilCreado extends DomainEvent {
    private final IdHojaDeVida idHojaDeVida;
    private final InfoContacto infoContacto;
    private final FotoDePerfil fotoDePerfil;

    public PerfilCreado(IdHojaDeVida idHojaDeVida, FotoDePerfil fotoDePerfil,InfoContacto infoContacto) {
        super("sofka.ddd.perfilcreado");
        this.idHojaDeVida = idHojaDeVida;
        this.fotoDePerfil = fotoDePerfil;
        this.infoContacto = infoContacto;
    }

    public IdHojaDeVida getIdHojaDeVida() {
        return idHojaDeVida;
    }

    public FotoDePerfil getFotoDePerfil() {
        return fotoDePerfil;
    }

    public InfoContacto getInfoContacto() {
        return infoContacto;
    }
}
