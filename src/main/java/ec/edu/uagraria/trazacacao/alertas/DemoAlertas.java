package ec.edu.uagraria.trazacacao.alertas;

import java.util.ArrayList;
import java.util.List;

public class DemoAlertas {

    public static void main(String[] args) {

        MotorAlertas motor = new MotorAlertas();

        motor.agregarRegla(Reglas.humedadAlta());

        List<Alerta> bitacora = new ArrayList<>();

        // Observador con lambda
        motor.suscribir(a ->
                System.out.println(
                        "[CONSOLA] "
                                + a.tipo()
                                + " en "
                                + a.codigoOrigen()
                                + ": "
                                + a.detalle()));

        // Observador con referencia a método
        motor.suscribir(bitacora::add);

        motor.procesar(
                new Lectura(
                        Magnitud.HUMEDAD_DEL_GRANO,
                        "LOT-0012",
                        8.4));

        motor.procesar(
                new Lectura(
                        Magnitud.HUMEDAD_DEL_GRANO,
                        "LOT-0012",
                        7.0));

        System.out.println(
                "Alertas en bitacora: "
                        + bitacora.size());
    }
}