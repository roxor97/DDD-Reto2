package com.sofka.ddd.usecase.perfil;

import com.sofka.ddd.domain.perfil.Perfil;
import com.sofka.ddd.domain.perfil.commands.AgregarNuevaReferencia;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;

public class UseCaseAgregarNuevaReferencia extends UseCase<RequestCommand<AgregarNuevaReferencia>, ResponseEvents> {
    
    @Override
    public void executeUseCase(RequestCommand<AgregarNuevaReferencia> requestCommand) {
        var command = requestCommand.getCommand();
        var perfil = Perfil.from(command.getIdPerfil(),retrieveEvents());

        perfil.agregarNuevaReferencia(command.getInfoContacto(),command.getNombreCompleto());
        emit().onResponse(new ResponseEvents(perfil.getUncommittedChanges()));
    }
}
