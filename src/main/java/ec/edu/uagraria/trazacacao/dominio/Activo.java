package ec.edu.uagraria.trazacacao.dominio;

public sealed interface Activo extends Trazable
        permits Producto, CacaoEnGrano, LoteFermentacion {

    String codigo();
}