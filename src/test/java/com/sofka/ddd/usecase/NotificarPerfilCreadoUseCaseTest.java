package com.sofka.ddd.usecase;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.sofka.ddd.domain.generics.IdHojaDeVida;
import com.sofka.ddd.domain.perfil.events.PerfilCreado;
import com.sofka.ddd.domain.perfil.values.FotoDePerfil;
import com.sofka.ddd.domain.perfil.values.IdPerfil;
import com.sofka.ddd.domain.perfil.values.InfoContacto;
import com.sofka.ddd.usecase.perfil.NotificarPerfilCreadoUseCase;
import com.sofka.ddd.usecase.service.EnviarNotificacionPerfilService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;


@ExtendWith(MockitoExtension.class)
class NotificarPerfilCreadoUseCaseTest {
    @Mock
    EnviarNotificacionPerfilService enviarNotificacionPerfilService;

    @Test
    void notificarPerfilCreado() {

        IdPerfil idPerfil = IdPerfil.of("yyyyy");
        IdHojaDeVida idHojaDeVida = IdHojaDeVida.of("xxxxx");
        FotoDePerfil fotoDePerfil = new FotoDePerfil("www.imagenesddd.com/images/perfil.jpg");
        InfoContacto infoContacto = new InfoContacto("junyperez97@gmail.com");

        var event = new PerfilCreado(idHojaDeVida, fotoDePerfil, infoContacto);
        event.setAggregateRootId(idPerfil.value());
        var useCase = new NotificarPerfilCreadoUseCase();
        when(enviarNotificacionPerfilService.enviarMensaje(
                "demoddd@demoddd.com", "Su perfil creado con exito", idPerfil)).thenReturn(true);

        ServiceBuilder builder = new ServiceBuilder();
        builder.addService(enviarNotificacionPerfilService);
        useCase.addServiceBuilder(builder);

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow();

        verify(enviarNotificacionPerfilService).enviarMensaje(
                "demoddd@demoddd.com",
                "Su perfil creado con exito",
                idPerfil);
    }
}
