package com.sofka.ddd.usecase.Experiencia;

import java.util.List;

import com.sofka.ddd.domain.experiencia.events.ExperienciaCreada;
import com.sofka.ddd.domain.experiencia.values.IdExperiencia;
import com.sofka.ddd.usecase.service.EnviarNotificacionService;
import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class UseCaseNotificarExperienciaCreada extends UseCase<TriggeredEvent<ExperienciaCreada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ExperienciaCreada> triggeredEvent){
        var event = triggeredEvent.getDomainEvent();
        var service = getService(EnviarNotificacionService.class).orElseThrow();

        Boolean correoOk = service.enviarMensaje(
                "demoddd@demoddd.com",
                "Su experiencia creada con exito",
                IdExperiencia.of(event.aggregateRootId())
        );

        if (!correoOk) {
            throw new BusinessException(event.aggregateRootId(), "No se pudo crear la experiencia");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
