package ec.edu.uagraria.trazacacao.dominio;

public interface Trazable {

    String codigo();

    default String etiquetaTrazabilidad() {
        return "Código de trazabilidad: " + codigo();
    }

    static String generarCodigo(String prefijo, int secuencia) {
        return prefijo + "-" + secuencia;
    }
}