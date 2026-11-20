package ec.edu.uagraria.trazacacao.alertas;

/** SINGLETON: los umbrales del tema, en un solo lugar y configurables. */
public enum Configuracion {
    INSTANCIA;

    private double humedadMaxima = 7.0;
    private double diasMaxFermentacion = 7.0;
    private double qrMinimo = 1.0;

    public double humedadMaxima() { return humedadMaxima; }

    public void cambiarHumedadMaxima(double nuevo) { humedadMaxima = nuevo; }

    public double diasMaxFermentacion() { return diasMaxFermentacion; }

    public void cambiarDiasMaxFermentacion(double nuevo) { diasMaxFermentacion = nuevo; }

    public double qrMinimo() { return qrMinimo; }

    public void cambiarQrMinimo(double nuevo) { qrMinimo = nuevo; }
}
