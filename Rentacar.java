
public class Rentacar {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("12345678-9", "Juan Perez");
        Vehiculo auto = new Vehiculo("abc123", "toyota", "yaris", 2022, "");

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
