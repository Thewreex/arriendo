public class Vehiculo {
import java.time.LocalDate;

// ============================
//  Vehiculo
// ============================
class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private int anio;
    private String condicion;

    public Automovil(String patente, String marca, String modelo, int anio, String condicion) {
        this.patente = patente.toUpperCase();
        this.marca = marca.toUpperCase();
        this.modelo = modelo.toUpperCase();

        int anioActual = LocalDate.now().getYear();
        if (anio >= 2000 && anio <= anioActual) {
            this.anio = anio;
        } else {
            throw new IllegalArgumentException("Año inválido");
        }

        if (condicion == null || condicion.isEmpty()) {
            this.condicion = "D";
        } else {
            this.condicion = condicion.toUpperCase();
        }
    }

    public String getPatente() { return patente; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAnio() { return anio; }
    public String getCondicion() { return condicion; }
}





// ============================
// CLASE PRINCIPAL
// ============================
public class Vehiculo {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("12345678-9", "Juan Perez");
        Automovil auto = new Automovil("abc123", "toyota", "yaris", 2022, "");

        Arriendo arriendo = new Arriendo(
                1,
                auto,
                cliente,
                "2026-03-20",
                5,
                100000
        );

        Devolucion devolucion = new Devolucion(arriendo, "2026-03-25");

        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Auto: " + auto.getMarca() + " " + auto.getModelo());
        System.out.println("Fecha arriendo: " + arriendo.getFechaArriendo());
        System.out.println("Fecha devolución: " + devolucion.getFechaDevolucion());
    }
}
}
