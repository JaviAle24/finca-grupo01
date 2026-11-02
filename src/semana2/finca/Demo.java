package semana2.finca;
public class Demo {
    public static void main(String[] args) {
        java.util.List<Activo> activos = java.util.List.of(
                new Producto("PR-001", "Saco de papa 50 kg", 50.50, 93),
                new Cultivo("CU-001", "Oregano", 6.5, 1800.0),
                new Animal("AN-001", "Cuy", 1.5, 10.5));
        double total = 0;
        for (Activo a : activos) {
            double v = Valorador.valor(a);
            total += v;
            System.out.printf("%s -> USD %.2f%n", a, v);
        }
        System.out.printf("Valor total de la finca: USD %.2f%n", total);
        System.out.println("10 qq = " + UnidadMedida.QUINTAL.aKilos(10) + " kg");
    }
}

