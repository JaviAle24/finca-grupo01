package semana2.finca;

public record Animal(String codigo, String especie, double pesoKg,
                     double precioPorKg) implements Activo {
    // Reto del grupo: agregue aquí la validación del peso
}
