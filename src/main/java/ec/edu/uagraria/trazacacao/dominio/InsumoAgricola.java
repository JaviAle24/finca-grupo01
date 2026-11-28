package ec.edu.uagraria.trazacacao.dominio;

public record InsumoAgricola(
        String nombre,
        double cantidad,
        String unidad,
        double precioUnitario
){

    public InsumoAgricola {
        if (cantidad < 0 || precioUnitario < 0) {
            throw new IllegalArgumentException(
                    "Cantidad y precio deben ser mayores o iguales a cero");
        }
    }

    public double costo() {
        return cantidad * precioUnitario;
    }
}
