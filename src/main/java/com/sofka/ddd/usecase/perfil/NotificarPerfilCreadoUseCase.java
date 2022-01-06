package com.sofka.ddd.usecase.perfil;

import java.util.List;

import com.sofka.ddd.domain.perfil.events.PerfilCreado;
import com.sofka.ddd.domain.perfil.values.IdPerfil;
import com.sofka.ddd.usecase.service.EnviarNotificacionPerfilService;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class NotificarPerfilCreadoUseCase extends UseCase<TriggeredEvent<PerfilCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<PerfilCreado> triggeredEvent){
        var event = triggeredEvent.getDomainEvent();
        var service = getService(EnviarNotificacionPerfilService.class).orElseThrow();

        Boolean  correoOk = service.enviarMensaje(
                "demoddd@demoddd.com",
                "Su perfil creado con exito",
                IdPerfil.of(event.aggregateRootId())
        );

        if (!correoOk) {
            throw new BusinessException(event.aggregateRootId(), "No se nos hizo posible crear el pefil");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
