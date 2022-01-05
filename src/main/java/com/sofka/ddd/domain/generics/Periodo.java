package com.sofka.ddd.domain.generics;

import java.sql.Date;
import java.util.Objects;

import co.com.sofka.domain.generic.ValueObject;

public class Periodo implements ValueObject<Periodo.Properties> {
    private final Date fechaInicio;
    private final Date fechaFin;

    public Periodo(Date fechaInicio, Date fechaFin){
        this.fechaInicio = Objects.requireNonNull(fechaInicio, "fechaInicio no puede ser nulo");
        this.fechaFin = Objects.requireNonNull(fechaFin, "fechaFin no puede ser nulo");

        if(fechaInicio.after(fechaFin)){
            throw new IllegalArgumentException("fechaInicio no puede ser mayor a fechaFin");
        }

        if(fechaFin.before(fechaInicio)){
            throw new IllegalArgumentException("fechaFin no puede ser menor a fechaInicio");
        }
    }

    public Properties value() {
        return new Properties() {
            @Override
            public Date fechaInicio() {
                return fechaInicio;
            }

            @Override
            public Date fechaFin() {
                return fechaFin;
            }
        };
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Periodo period = (Periodo) o;
        return Objects.equals(fechaInicio, period.fechaInicio) && Objects.equals(fechaFin, period.fechaFin);
    }

    @Override
    public int hashCode(){
        return Objects.hash(fechaInicio,fechaFin);
    }

    public interface Properties {
        Date fechaInicio();
        Date fechaFin();
    }
}
