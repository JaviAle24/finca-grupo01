package ec.edu.uagraria.trazacacao.alertas;

/** Las magnitudes que vigila el motor de TrazaCacao. */
public enum Magnitud {
    HUMEDAD_DEL_GRANO("humedad del grano", "%"),
    DIAS_DE_FERMENTACION("días de fermentación", "días"),
    CANTIDAD_DE_CODIGOS_QR_ASIGNADOS_AL_LOTE("cantidad de códigos QR asignados al lote listo", "códigos");

    private final String nombre;
    private final String unidad;

    Magnitud(String nombre, String unidad) { this.nombre = nombre; this.unidad = unidad; }

    public String nombre() { return nombre; }

    public String unidad() { return unidad; }
}
