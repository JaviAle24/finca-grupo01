package ec.edu.uagraria.trazacacao.fabrica;

/** Los tres tipos de producto del tema, con el prefijo de su codigo. */
public enum TipoProducto {
    CACAO_EN_GRANO("CUL"),
    LOTE_FERMENTACION("ANI"),
    INSUMO_AGRICOLA("INS");

    private final String prefijo;

    TipoProducto(String prefijo) { this.prefijo = prefijo; }

    public String prefijo() { return prefijo; }
}
