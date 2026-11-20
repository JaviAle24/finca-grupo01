package ec.edu.uagraria.trazacacao.alertas;

import ec.edu.uagraria.trazacacao.dominio.Activo;
import ec.edu.uagraria.trazacacao.fabrica.FabricaProductos;
import ec.edu.uagraria.trazacacao.fabrica.TipoProducto;
import java.util.ArrayList;
import java.util.List;

public class DemoTaller4 {
    public static void main(String[] args) {
        // 1. La fabrica crea los productos; nadie usa new sobre los records
        Activo p = FabricaProductos.crear(
                TipoProducto.CACAO_EN_GRANO, "Cacao Nacional o CCN-51 por lote", 120);
        System.out.println("Creado por la fabrica: " + p);
        System.out.println("Etiqueta: " + p.etiquetaTrazabilidad());

        // 2. El motor con las tres reglas del tema
        MotorAlertas motor = new MotorAlertas();
        motor.agregarRegla(Reglas.humedadAlta());
        motor.agregarRegla(Reglas.fermentacionExcedida());
        motor.agregarRegla(Reglas.loteSinQr());

        // 3. Dos observadores: consola y bitacora
        List<Alerta> bitacora = new ArrayList<>();
        motor.suscribir(a -> System.out.println(
                "[CONSOLA] " + a.tipo() + " en " + a.codigoOrigen() + ": " + a.detalle()));
        motor.suscribir(bitacora::add);

        // 4. Lecturas
        // dispara HUMEDAD_ALTA
        motor.procesar(new Lectura(Magnitud.HUMEDAD_DEL_GRANO, "LOT-0012", 8.4));
        // dispara FERMENTACION_EXCEDIDA
        motor.procesar(new Lectura(Magnitud.DIAS_DE_FERMENTACION, "LOT-0012", 9.0));
        // dispara LOTE_SIN_QR
        motor.procesar(new Lectura(Magnitud.CANTIDAD_DE_CODIGOS_QR_ASIGNADOS_AL_LOTE, "LOT-0015", 0.0));
        // en el umbral exacto: NO dispara
        motor.procesar(new Lectura(Magnitud.HUMEDAD_DEL_GRANO, "LOT-0012", 7.0));

        System.out.println("Alertas en bitacora: " + bitacora.size());
    }
}
