package ec.edu.uagraria.trazacacao.dominio;

public record CacaoEnGrano(String codigo, String nombre, double hectareas,
                           double costoPorHectarea) implements Activo {
    public CacaoEnGrano {
        if (hectareas <= 0)
            throw new IllegalArgumentException("Las hectáreas deben ser positivas");
    }
}
