package com.sofka.ddd.usecase.service;

import com.sofka.ddd.domain.experiencia.values.IdExperiencia;

public interface UseCaseEnviarNotificacionService {
    boolean enviarMensaje(String Correo, String BodyCorreo, IdExperiencia idExperiencia);
}
