package ec.edu.uagraria.trazacacao.alertas;

import java.util.Optional;

/** Las tres reglas del tema, escritas como lambdas. */
public final class Reglas {
    private Reglas() { }

    /** HUMEDAD_ALTA: humedad del grano > humedadMaxima. */
    public static ReglaAlerta humedadAlta() {
        return l -> {
            double umbral = Configuracion.INSTANCIA.humedadMaxima();
            boolean aplica = l.magnitud() == Magnitud.HUMEDAD_DEL_GRANO;
            if (aplica && l.valor() > umbral) {
                String detalle = l.magnitud().nombre() + " = " + l.valor()
                        + " " + l.magnitud().unidad() + " (umbral " + umbral + ")";
                return Optional.of(new Alerta(TipoAlerta.HUMEDAD_ALTA, l.codigoOrigen(), detalle));
            }
            return Optional.empty();
        };
    }

    /** FERMENTACION_EXCEDIDA: días de fermentación > diasMaxFermentacion. */
    public static ReglaAlerta fermentacionExcedida() {
        return l -> {
            double umbral = Configuracion.INSTANCIA.diasMaxFermentacion();
            boolean aplica = l.magnitud() == Magnitud.DIAS_DE_FERMENTACION;
            if (aplica && l.valor() > umbral) {
                String detalle = l.magnitud().nombre() + " = " + l.valor()
                        + " " + l.magnitud().unidad() + " (umbral " + umbral + ")";
                return Optional.of(new Alerta(TipoAlerta.FERMENTACION_EXCEDIDA, l.codigoOrigen(), detalle));
            }
            return Optional.empty();
        };
    }

    /** LOTE_SIN_QR: cantidad de códigos QR asignados al lote listo < qrMinimo. */
    public static ReglaAlerta loteSinQr() {
        return l -> {
            double umbral = Configuracion.INSTANCIA.qrMinimo();
            boolean aplica = l.magnitud() == Magnitud.CANTIDAD_DE_CODIGOS_QR_ASIGNADOS_AL_LOTE;
            if (aplica && l.valor() < umbral) {
                String detalle = l.magnitud().nombre() + " = " + l.valor()
                        + " " + l.magnitud().unidad() + " (umbral " + umbral + ")";
                return Optional.of(new Alerta(TipoAlerta.LOTE_SIN_QR, l.codigoOrigen(), detalle));
            }
            return Optional.empty();
        };
    }
}
