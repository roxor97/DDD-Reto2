package com.sofka.ddd.domain.gestioneducacion.values;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class TarjetaProfesional implements ValueObject<TarjetaProfesional.Properties> {

    private final String respuesta;
    private final Boolean retorno;

    public TarjetaProfesional(String respuesta, Boolean retorno) {
        this.respuesta = Objects.requireNonNull(respuesta);
        this.retorno = Objects.requireNonNull(retorno);
        if( this.respuesta.isBlank()){
            throw new IllegalArgumentException("La respuesta de la tarjeta profesional no puede estar vacia");
        }
    }

    @Override
    public Properties value() {
        return new Properties() {
            @Override
            public String respuesta() {
                return respuesta;
            }

            @Override
            public Boolean retorno() {
                return retorno;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TarjetaProfesional that = (TarjetaProfesional) o;
        return Objects.equals(respuesta, that.respuesta) && Objects.equals(retorno, that.retorno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(respuesta, retorno);
    }

    public interface  Properties {
        String respuesta();
        Boolean retorno();
    }

}
