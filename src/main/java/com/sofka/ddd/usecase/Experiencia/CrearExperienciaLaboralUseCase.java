package com.sofka.ddd.usecase.Experiencia;

import com.sofka.ddd.domain.experiencia.Experiencia;
import com.sofka.ddd.domain.experiencia.commands.CrearExperienciaLaboral;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class CrearExperienciaLaboralUseCase extends UseCase<RequestCommand<CrearExperienciaLaboral>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearExperienciaLaboral> requestCommand) {
        Experiencia experiencia;
        var command = requestCommand.getCommand();

        experiencia = Experiencia.from(command.getIdExperiencia(), retrieveEvents());

        emit().onResponse(new ResponseEvents(experiencia.getUncommittedChanges()));

    }

}