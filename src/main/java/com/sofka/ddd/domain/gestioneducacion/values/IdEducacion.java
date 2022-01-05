package com.sofka.ddd.domain.gestioneducacion.values;

import co.com.sofka.domain.generic.Identity;

public class IdEducacion extends Identity {

    public IdEducacion(String id) {
        super(id);
    }

    public IdEducacion() {
    }

    public static IdEducacion of(String id){
        return new IdEducacion(id);
    }

}