package com.sofka.ddd.domain.gestioneducacion.values;

import co.com.sofka.domain.generic.Identity;

public class IdGestionEducacion extends Identity {

    public IdGestionEducacion(String uuid) {
        super(uuid);
    }

    public IdGestionEducacion() {
    }

    public static IdGestionEducacion of(String id){
        return new IdGestionEducacion(id);
    }
}
