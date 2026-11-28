package ec.edu.uagraria.trazacacao.dominio;

public record LoteFermentacion(String codigo, String especie, double pesoKg,
                               double precioPorKg) implements Activo {
    // Reto del grupo: agregue aquí la validación del peso
}
