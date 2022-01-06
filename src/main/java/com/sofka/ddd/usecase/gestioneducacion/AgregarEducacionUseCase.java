package com.sofka.ddd.usecase.gestioneducacion;

import com.sofka.ddd.domain.gestioneducacion.GestionEducacion;
import com.sofka.ddd.domain.gestioneducacion.commands.AgregarNuevaEducacion;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class AgregarEducacionUseCase extends UseCase<RequestCommand<AgregarNuevaEducacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarNuevaEducacion> requestCommand) {

        var command = requestCommand.getCommand();

        GestionEducacion gestionEducacion;

        gestionEducacion = GestionEducacion.from(
                command.getIdGestionEducacion(),
                retrieveEvents()
        );

        gestionEducacion.agregarNuevaEducacion(
                command.getTarjetaProfesional(),
                command.getTipo(),
                command.getEstudio(),
                command.getInstitucion(),
                command.getPeriodo()
        );

        if (!(gestionEducacion.educacion().tarjetaProfesional().value().respuesta().equalsIgnoreCase("y") || gestionEducacion.educacion().tarjetaProfesional().value().retorno())) {
            throw new BusinessException(command.getIdGestionEducacion().value(), "El aspirante debe tener tarjeta profesional");
        }

        emit().onResponse(new ResponseEvents(gestionEducacion.getUncommittedChanges()));
    }

}
