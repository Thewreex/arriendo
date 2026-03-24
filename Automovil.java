public class Automovil {
import java.time.LocalDate;

// ============================
// CLASE AUTOMOVIL
// ============================
class Automovil {
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
// CLASE CLIENTE
// ============================
class Cliente {
    private String cedula;
    private String nombre;
    private boolean vigencia;

    public Cliente(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.vigencia = true;
    }

    public String getCedula() { return cedula; }
    public String getNombre() { return nombre; }
    public boolean isVigente() { return vigencia; }

    public void setVigencia(boolean vigencia) {
        this.vigencia = vigencia;
    }
}

// ============================
// CLASE ARRIENDO
// ============================
class Arriendo {
    private int numeroArriendo;
    private Automovil vehiculo;
    private Cliente cliente;
    private LocalDate fechaArriendo;
    private int dias;
    private int monto;

    public Arriendo(int numeroArriendo, Automovil vehiculo, Cliente cliente,
                    String fechaArriendo, int dias, int monto) {

        this.numeroArriendo = numeroArriendo;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        this.fechaArriendo = LocalDate.parse(fechaArriendo);

        if (dias > 1 && dias < 10) {
            this.dias = dias;
        } else {
            throw new IllegalArgumentException("Días deben ser entre 2 y 9");
        }

        this.monto = monto;
    }

    public int getNumeroArriendo() { return numeroArriendo; }
    public Automovil getVehiculo() { return vehiculo; }
    public Cliente getCliente() { return cliente; }
    public LocalDate getFechaArriendo() { return fechaArriendo; }
    public int getDias() { return dias; }
    public int getMonto() { return monto; }
}

// ============================
// CLASE DEVOLUCION
// ============================
class Devolucion {
    private Arriendo arriendo;
    private LocalDate fechaDevolucion;

    public Devolucion(Arriendo arriendo, String fechaDevolucion) {
        this.arriendo = arriendo;
        LocalDate fechaDev = LocalDate.parse(fechaDevolucion);

        if (!fechaDev.isBefore(arriendo.getFechaArriendo())) {
            this.fechaDevolucion = fechaDev;
        } else {
            throw new IllegalArgumentException("Fecha de devolución inválida");
        }
    }

    public Arriendo getArriendo() { return arriendo; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
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
