package com.sofka.ddd.usecase;

import java.util.List;

import com.sofka.ddd.domain.generics.IdHojaDeVida;
import com.sofka.ddd.domain.generics.NombreCompleto;
import com.sofka.ddd.domain.perfil.commands.AgregarNuevaReferencia;
import com.sofka.ddd.domain.perfil.events.NuevaReferenciaAgregada;
import com.sofka.ddd.domain.perfil.events.PerfilCreado;
import com.sofka.ddd.domain.perfil.values.FotoDePerfil;
import com.sofka.ddd.domain.perfil.values.IdPerfil;
import com.sofka.ddd.domain.perfil.values.IdReferencia;
import com.sofka.ddd.domain.perfil.values.InfoContacto;
import com.sofka.ddd.usecase.perfil.AgregarNuevaReferenciaUseCase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import static org.mockito.Mockito.when;




@ExtendWith(MockitoExtension.class)
class AgregarReferenciaUseCaseTest {
    @Mock
    DomainEventRepository domainEventRepository;

    @Test
    void agregarReferencia(){
        
        IdPerfil idPerfil = IdPerfil.of("xxxxx");
        IdReferencia idReferencia = IdReferencia.of("yyyyy");
        InfoContacto info = new InfoContacto("Telefono : 3016724654");
        NombreCompleto nombreCompleto = new NombreCompleto("harvey", "perez");
        
        var command = new AgregarNuevaReferencia(idPerfil,
                idReferencia,
                info,
                nombreCompleto);
        var useCase = new AgregarNuevaReferenciaUseCase();
        when(domainEventRepository.getEventsBy("xxxxx")).thenReturn(events());
        useCase.addRepository(domainEventRepository);
        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(idPerfil.value())
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (NuevaReferenciaAgregada) events.get(0);
        
        Assertions.assertEquals("Telefono : 3016724654", event.getInfoContacto().value());
        Mockito.verify(domainEventRepository).getEventsBy("xxxxx");
    }

    private List<DomainEvent> events() {
        IdHojaDeVida idHojaDeVida = IdHojaDeVida.of("yyyyy");
        FotoDePerfil fotoDePerfil = new FotoDePerfil("a");
        InfoContacto infoContacto = new InfoContacto("");
        return List.of(new PerfilCreado(
                idHojaDeVida,
                fotoDePerfil,
                infoContacto));
    }
}
