package com.sofka.ddd.domain.perfil.values;

import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class InfoContacto implements ValueObject<String> {

    private final String info;

    public InfoContacto(String info){
        this.info = Objects.requireNonNull(info, "La informacion no puede ser nula");
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        InfoContacto Informacion = (InfoContacto) o;
        return Objects.equals(info,Informacion.info);
    }

    @Override
    public int hashCode(){
        return Objects.hash(info);
    }

    @Override
    public String value(){
        return info;
    }
}
