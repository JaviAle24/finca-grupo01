package ec.edu.uagraria.trazacacao.dominio;

public class Valorador {
    public static double valor(Activo activo) {
        return switch (activo) {
            case Producto p -> p.precioUnitario() * p.unidades();
            case CacaoEnGrano c  -> c.hectareas() * c.costoPorHectarea();
            case LoteFermentacion a   -> a.pesoKg() * a.precioPorKg();
        };  // sin default: la interfaz es sealed
    }
}
