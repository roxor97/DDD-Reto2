package com.sofka.ddd.usecase.perfil;

import com.sofka.ddd.domain.perfil.Perfil;
import com.sofka.ddd.domain.perfil.commands.CrearPerfil;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class UseCaseCrearPerfil extends UseCase<RequestCommand<CrearPerfil>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearPerfil> requestCommand){
        var command = requestCommand.getCommand();
        if(command.getInfoContacto().value().length() > 30){
            throw new BusinessException(command.getInfoContacto().value(), "La informacion de contacto no puede ser mayor a 30 caracteres");
        }
        var perfil = new Perfil(command.getIdPerfil(), command.getIdHojaDeVida(), command.getFotoDePerfil(),command.getInfoContacto());

        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));
    }
}
