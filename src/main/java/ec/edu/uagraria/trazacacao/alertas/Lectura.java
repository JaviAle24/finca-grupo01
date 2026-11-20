package ec.edu.uagraria.trazacacao.alertas;

/** Una medicion del dominio: que se midio, sobre que elemento y cuanto. */
public record Lectura(Magnitud magnitud, String codigoOrigen, double valor) { }

