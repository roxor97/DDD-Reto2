package com.sofka.ddd.domain.perfil.values;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class FotoDePerfil implements ValueObject<String> {

    private final String path;

    public FotoDePerfil(String path) {
        this.path = Objects.requireNonNull(path, "El path no puede estar vacia");
        if(this.path.isBlank()){
            throw new IllegalArgumentException("El path no puede estar vacia");
        }
        if (!this.path.contains("https://")){
            throw new IllegalArgumentException("El path debe contener https://");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotoDePerfil that = (FotoDePerfil) o;
        return Objects.equals(path, that.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path);
    }

    @Override
    public String value() {
        return path;
    }
}
