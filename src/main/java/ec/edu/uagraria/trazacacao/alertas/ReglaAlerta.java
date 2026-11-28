package ec.edu.uagraria.trazacacao.alertas;

import java.util.Optional;

/** STRATEGY: cada regla decide si una lectura genera alerta. */
@FunctionalInterface
public interface ReglaAlerta {
    Optional<Alerta> evaluar(Lectura lectura);
}
