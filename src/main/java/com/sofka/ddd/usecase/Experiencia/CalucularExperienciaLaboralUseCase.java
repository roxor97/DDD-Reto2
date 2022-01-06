package com.sofka.ddd.usecase.Experiencia;

import java.util.List;

import com.sofka.ddd.domain.experiencia.events.ExperienciaCreada;
import com.sofka.ddd.domain.experiencia.values.IdExperiencia;
import com.sofka.ddd.domain.generics.Periodo;
import com.sofka.ddd.usecase.service.CalcularPeriodoService;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;

public class CalucularExperienciaLaboralUseCase extends UseCase<TriggeredEvent<ExperienciaCreada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ExperienciaCreada> triggeredEvent){
        var event = triggeredEvent.getDomainEvent();
        var idExperiencia = IdExperiencia.of(event.aggregateRootId());
        Periodo periodo = event.getExperienciaLaboral().iterator().next().periodo();
        var service = getService(CalcularPeriodoService.class).orElseThrow();

        Double periodoTrabajado =
                service.calcularPeriodo(
                        idExperiencia,
                        periodo
                );
        if (periodoTrabajado <= 0) {
            throw new BusinessException(event.aggregateRootId(), "El periodo de experiencia laboral no es valido");
        }
        emit().onResponse(new ResponseEvents(List.of()));
    }
}
