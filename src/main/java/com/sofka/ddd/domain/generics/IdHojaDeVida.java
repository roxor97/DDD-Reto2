package com.sofka.ddd.domain.generics;

import co.com.sofka.domain.generic.Identity;

public class IdHojaDeVida extends Identity {
    private IdHojaDeVida(String value){
        super(value);
    }

    public IdHojaDeVida(){

    }

    public static IdHojaDeVida of(String value){
        return new IdHojaDeVida(value);
    }
}
