package com.sofka.ddd.domain.experiencia.values;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class ConocimientosAdqueridos implements ValueObject<String> {
    private final String conocimientos;

    public ConocimientosAdqueridos(String conocimientos){
        this.conocimientos = Objects.requireNonNull(conocimientos, "los conocimientos no pueden estar vacios");
    }

    public ConocimientosAdqueridos modificarConocimientosAdqueridos(String conocimientos) {
        return new ConocimientosAdqueridos(conocimientos);
    }

    @Override
    public String value(){
        return conocimientos;
    }
}
