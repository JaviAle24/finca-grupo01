package ec.edu.uagraria.trazacacao.fabrica;

import ec.edu.uagraria.trazacacao.dominio.*;

public final class FabricaProductos {

    private FabricaProductos() {
    }

    public static Activo crear(TipoProducto tipo, String nombre, double cantidad) {

        String codigo = Trazable.generarCodigo(tipo.prefijo(), 1);

        return switch (tipo) {

            case CACAO_EN_GRANO ->
                    new CacaoEnGrano(codigo, nombre, cantidad, 0.0);

            case LOTE_FERMENTACION ->
                    new LoteFermentacion(codigo, nombre, cantidad, 0.0);

            case INSUMO_AGRICOLA ->
                    throw new IllegalArgumentException("INSUMO_AGRICOLA no soportado");
        };
    }
}



