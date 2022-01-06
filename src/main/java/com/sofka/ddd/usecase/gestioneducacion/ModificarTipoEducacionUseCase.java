package com.sofka.ddd.usecase.gestioneducacion;

import com.sofka.ddd.domain.gestioneducacion.GestionEducacion;
import com.sofka.ddd.domain.gestioneducacion.commands.ModificarTipoDeEducacion;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class ModificarTipoEducacionUseCase extends UseCase<RequestCommand<ModificarTipoDeEducacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarTipoDeEducacion> requestCommand) {

        var command = requestCommand.getCommand();

        GestionEducacion gestionEducacion;

        gestionEducacion = GestionEducacion.from(
                command.getIdGestionEducacion(),
                retrieveEvents()
        );

        gestionEducacion.actualizarTipoEducacion(
                command.getIdEducacion(),
                command.getTipo()
        );

        emit().onResponse(new ResponseEvents(gestionEducacion.getUncommittedChanges()));
    }
}
