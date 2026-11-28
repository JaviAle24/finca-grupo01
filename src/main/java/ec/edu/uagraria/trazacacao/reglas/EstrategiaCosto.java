package ec.edu.uagraria.trazacacao.reglas;

import ec.edu.uagraria.semana2.finca.Lote;

@FunctionalInterface
public interface EstrategiaCosto {

    double calcular(Lote lote);

    default String descripcion() {
        return "Estrategia de costo";
    }
}