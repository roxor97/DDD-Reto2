package com.sofka.ddd.domain.gestioneducacion.values;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class Estudio implements ValueObject<String> {

    private final String value;

    public Estudio(String value) {

        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()) {
            throw new IllegalArgumentException("La educacion que estudio no puede estar vacía");
        }
        if (this.value.length() < 5) {
            throw new IllegalArgumentException("La educacion que estudio no puede tener menos de 5");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Estudio estudio = (Estudio) o;
        return Objects.equals(value, estudio.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String value() {
        return value;
    }
}
