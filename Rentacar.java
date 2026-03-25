import java.time.LocalDate;

public class Rentacar {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("12345678-9", "Juan Perez");
        System.out.println(cliente1.toString());
        Vehiculo auto1 = new Vehiculo("abc123", "toyota", "yaris", 2022);
        System.out.println(auto1.toString());

        cliente1.deshabilitar();
        System.out.println(cliente1.toString());
        auto1.asignarMantencion();
        System.out.println(auto1.toString());

        Cliente clienteInvalido = new Cliente("123", "");
        System.out.println(clienteInvalido.toString());

        Vehiculo autoInvalido = new Vehiculo("", "", "", 1990);
        System.out.println(autoInvalido.toString());

        Arriendo arr1 = new Arriendo(auto1, cliente1, LocalDate.now(), 3, 45000);

        arr1.ingresarArriendo();
        System.out.println(arr1.toString());

        Cliente cliente2 = new Cliente("11111111-1", "Maria Lopez");
        System.out.println(cliente2.toString());
        Vehiculo auto2 = new Vehiculo("def456", "kia", "rio", 2021);
        System.out.println(auto2.toString());

        Arriendo arr2 = new Arriendo(auto2, cliente2, LocalDate.now(), 3, 45000);
        System.out.println(arr2.toString());

        if (arr2.ingresarArriendo()) {
            arr2.generarTicket();
        }

        Devolucion d1 = new Devolucion(arr2, LocalDate.now());
        System.out.println(d1.toString());
        d1.ingresarDevolucion(auto2);

        Vehiculo otroAuto = new Vehiculo("zzz999", "mazda", "3", 2020);
        Devolucion d2 = new Devolucion(arr2, LocalDate.now());
        d2.ingresarDevolucion(otroAuto);
    }
}