package com.sofka.ddd.usecase.service;

import com.sofka.ddd.domain.perfil.values.IdPerfil;

public interface UseCaseEnviarNotificacionPerfilService {
    boolean enviarMensaje(String Correo, String BodyCorreo, IdPerfil idPerfil);
}
