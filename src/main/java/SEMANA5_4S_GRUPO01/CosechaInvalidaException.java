package SEMANA5_4S_GRUPO01;

/**
 * Excepción checked del dominio agrícola: indica que una fila del
 * archivo de cosechas de banano no cumple las reglas de validación.
 */
public class CosechaInvalidaException extends Exception {
    private static final long serialVersionUID = 1L;
    public CosechaInvalidaException(String mensaje) {
        super(mensaje);
    }
    public CosechaInvalidaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
