package com.sofka.ddd.usecase;

import com.sofka.ddd.domain.generics.IdHojaDeVida;
import com.sofka.ddd.domain.perfil.commands.CrearPerfil;
import com.sofka.ddd.domain.perfil.events.PerfilCreado;
import com.sofka.ddd.domain.perfil.values.FotoDePerfil;
import com.sofka.ddd.domain.perfil.values.IdPerfil;
import com.sofka.ddd.domain.perfil.values.InfoContacto;
import com.sofka.ddd.usecase.perfil.CrearPerfilUseCase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;

class CrearPerfilUseCaseTest {
    @Test
    public void crearPerfil(){
        
        IdPerfil idPerfil = IdPerfil.of("xxxxx");
        IdHojaDeVida idHojaDeVida = IdHojaDeVida.of("zzzzz");
        InfoContacto infoContacto = new InfoContacto("demoddd@demo.com");
        FotoDePerfil fotoDePerfil = new FotoDePerfil("www.imagenesddd.com/images/perfil.jpg");
        
        var command = new CrearPerfil(
                idPerfil,
                idHojaDeVida,
                infoContacto,
                fotoDePerfil
        );
        var useCase = new CrearPerfilUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        PerfilCreado event = (PerfilCreado)events.getDomainEvents().get(0);
        
        Assertions.assertEquals( "xxxxx", event.aggregateRootId());
        Assertions.assertEquals( "www.imagenesddd.com/images/perfil.jpg", event.getFotoDePerfil().value());
    }

@Test
    public void crearPerfilFailsBecauseOfContactInfo(){
        
        IdPerfil idPerfil = IdPerfil.of("xxxxx");
        IdHojaDeVida idHojaDeVida = IdHojaDeVida.of("zzzzz");
        InfoContacto infoContacto = new InfoContacto("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx@gmail.com");
        FotoDePerfil fotoDePerfil = new FotoDePerfil("www.imagenesddd.com/images/perfil.jpg");
       
        var command = new CrearPerfil(
                idPerfil,
                idHojaDeVida,
                infoContacto,
                fotoDePerfil
        );
        var useCase = new CrearPerfilUseCase();
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow();
        PerfilCreado event = (PerfilCreado)events.getDomainEvents().get(0);
        //Asserts
        Assertions.assertEquals( "xxxxx", event.aggregateRootId());
        Assertions.assertEquals( "www.imagenesddd.com/images/perfil.jpg", event.getFotoDePerfil().value());
    }
}