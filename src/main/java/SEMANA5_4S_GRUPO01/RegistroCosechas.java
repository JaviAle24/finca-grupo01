import SEMANA5_4S_GRUPO01.Cosecha;
import SEMANA5_4S_GRUPO01.CosechaInvalidaException;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Logger;

public class RegistroCosechas {

    private static final Logger LOG = Logger.getLogger(RegistroCosechas.class.getName());

    static Cosecha validar(String linea) throws CosechaInvalidaException {
        String[] campos = linea.split(",", -1);
        String lote = campos[0].trim();
        String finca = campos.length > 1 ? campos[1].trim() : "";
        String textoCajas = campos.length > 2 ? campos[2].trim() : "";

        if (finca.isBlank()) {
            throw new CosechaInvalidaException("Lote " + lote + ": la finca está vacía");
        }
        int cajas;
        try {
            cajas = Integer.parseInt(textoCajas);
        } catch (NumberFormatException e) {
            throw new CosechaInvalidaException(
                    "Lote " + lote + ": las cajas no son un número entero (\"" + textoCajas + "\")", e);
        }
        if (cajas <= 0) {
            throw new CosechaInvalidaException(
                    "Lote " + lote + ": las cajas deben ser mayores que 0 (valor: " + cajas + ")");
        }
        return new Cosecha(lote, finca, cajas);
    }

    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$s] %5$s%n");

        int filasValidas = 0;
        int totalCajas = 0;

        try (BufferedReader lector = Files.newBufferedReader(Path.of("data/cosechas_banano.csv"))) {
            lector.readLine(); // se salta la cabecera
            String linea;
            while ((linea = lector.readLine()) != null) {
                try {
                    Cosecha cosecha = validar(linea);
                    filasValidas++;
                    totalCajas += cosecha.cajas();
                } catch (CosechaInvalidaException e) {
                    LOG.warning(e.getMessage());
                }
            }
        } catch (IOException e) {
            LOG.severe("No se pudo leer el archivo: " + e.getMessage());
        }

        System.out.println("Filas válidas: " + filasValidas + " | Total de cajas: " + totalCajas);
    }
}
