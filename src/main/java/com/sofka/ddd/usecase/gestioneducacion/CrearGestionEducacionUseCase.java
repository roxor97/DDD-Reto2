package com.sofka.ddd.usecase.gestioneducacion;

import com.sofka.ddd.domain.gestioneducacion.GestionEducacion;
import com.sofka.ddd.domain.gestioneducacion.commands.CrearGestionEducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearGestionEducacionUseCase extends UseCase<RequestCommand<CrearGestionEducacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearGestionEducacion> requestCommand) {
        var command = requestCommand.getCommand();

        GestionEducacion gestionEducacion;

        gestionEducacion = new GestionEducacion(
                command.getIdGestionEducacion(),
                command.getIdHojaDeVida()
        );

        emit().onResponse(new ResponseEvents(gestionEducacion.getUncommittedChanges()));

    }

}
