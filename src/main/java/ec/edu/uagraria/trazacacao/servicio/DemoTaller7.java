package ec.edu.uagraria.trazacacao.servicio;

import java.util.List;
import ec.edu.uagraria.trazacacao.servicio.ItemInventario;

public class DemoTaller7 {
    public static void main(String[] args) {
        Inventario inv = new Inventario();
        inv.registrar(new ItemInventario("CAC-0001", "CacaoEnGrano", "Nacional seco", 450.0));
        inv.registrar(new ItemInventario("FER-0001", "LoteFermentacion", "Cajon 1", 320.0));
        inv.registrar(new ItemInventario("INS-0001", "InsumoAgricola", "Sacos de yute", 80.0));
        inv.registrar(new ItemInventario("CAC-0002", "CacaoEnGrano", "CCN-51 seco", 610.0));
        inv.registrar(new ItemInventario("CAC-0001", "CacaoEnGrano", "Nacional (reingreso)", 50.0));

        System.out.println("Registros (List): " + inv.registros().size());
        System.out.println("Codigos unicos (Set): " + inv.codigosUnicos());
        System.out.println("Total por tipo (Map): " + inv.totalPorTipo());
        System.out.println("Ordenados por cantidad (Comparator):");
        inv.ordenadosPorCantidad().forEach(i ->
                System.out.printf("  %-9s %-17s %7.1f%n", i.codigo(), i.tipo(), i.cantidad()));

        inv.ordenadosPorCantidad().forEach(inv::encolarDespacho);
        System.out.println("Despacho (Deque): " + inv.despacharSiguiente().orElseThrow().codigo()
                + " | pendientes: " + inv.pendientesDespacho());
    }
}
