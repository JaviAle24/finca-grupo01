package ec.edu.uagraria.trazacacao.alertas;

import java.util.Objects;

/** Evento inmutable que recibe cada observador. */
public record Alerta(TipoAlerta tipo, String codigoOrigen, String detalle) {
    public Alerta {
        Objects.requireNonNull(tipo);
        Objects.requireNonNull(codigoOrigen);
    }
}