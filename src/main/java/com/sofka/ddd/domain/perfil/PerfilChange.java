package com.sofka.ddd.domain.perfil;
import java.util.HashSet;
import java.util.Objects;
import co.com.sofka.domain.generic.EventChange;
import com.sofka.ddd.domain.perfil.events.NuevaReferenciaAgregada;
import com.sofka.ddd.domain.perfil.events.PerfilCreado;
import com.sofka.ddd.domain.perfil.events.ReferenciaEliminada;

public class PerfilChange extends EventChange {
    public PerfilChange(Perfil perfil){
        apply((PerfilCreado event) -> {
            perfil.referencias = new HashSet<>();
            perfil.idHojaDeVida = Objects.requireNonNull(event.getIdHojaDeVida());
            perfil.fotoDePerfil = Objects.requireNonNull(event.getFotoDePerfil());
            perfil.infoContacto = Objects.requireNonNull(event.getInfoContacto());
        });

        apply((NuevaReferenciaAgregada event)->{
            perfil.referencias.add(new Referencia(
                    event.getIdReferencia(),
                    event.getInfoContacto(),
                    event.getNombreCompleto()
            ));
        });

        apply((ReferenciaEliminada event)->{
            var IdReferencia = event.getIdReferencia();
            perfil.referencias.removeIf(referencia -> referencia.identity().equals(IdReferencia));
        });
    }
}
