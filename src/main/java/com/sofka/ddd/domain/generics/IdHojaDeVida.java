package com.sofka.ddd.domain.generics;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class IdHojaDeVida implements ValueObject<String> {

    private final String value;

    public IdHojaDeVida(String value) {
        this.value = Objects.requireNonNull(value, "El id de la hoja de vida no puede ir vacio");
        if(this.value.isBlank()){
            throw new IllegalArgumentException("El id de la hoja de vida no puede estar en blanco");
        }
    }

    @Override
    public String value() {
        return value;
    }
}
