package com.sofka.ddd.usecase.service;

import com.sofka.ddd.domain.experiencia.values.IdExperiencia;
import com.sofka.ddd.domain.generics.Periodo;

public interface UseCaseCalcularPeriodoService {
    Double calcularPeriodo(IdExperiencia idExperiencia, Periodo periodo);
}
