package com.sofka.ddd.usecase.Experiencia;

import com.sofka.ddd.domain.experiencia.Experiencia;
import com.sofka.ddd.domain.experiencia.commands.AgregarExperienciaLaboral;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class UseCaseAgregarExperienciaLaboral extends UseCase<RequestCommand<AgregarExperienciaLaboral>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarExperienciaLaboral> requestCommand) {
        var command = requestCommand.getCommand();
        var experiencia = Experiencia.from(command.getIdExperiencia(),retrieveEvents());

        experiencia.agregarExperienciaLaboral(command.getInstitucion(),command.getPeriodo(),command.getConocimientosAdqueridos());
        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));
    }
}
