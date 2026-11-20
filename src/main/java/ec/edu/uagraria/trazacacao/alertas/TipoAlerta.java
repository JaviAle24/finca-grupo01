package ec.edu.uagraria.trazacacao.alertas;

public enum TipoAlerta {
    HUMEDAD_ALTA("Humedad del grano por encima del umbral antes de exportar"),
    FERMENTACION_EXCEDIDA("Lote que supera los días máximos de fermentación"),
    LOTE_SIN_QR("Lote listo para exportar sin código QR asignado");

    private final String descripcion;

    TipoAlerta(String descripcion) { this.descripcion = descripcion; }

    public String descripcion() { return descripcion; }
}
