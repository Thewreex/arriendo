
import java.time.LocalDate;

public class Arriendo {
    private int numeroArriendo;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private LocalDate fechaArriendo;
    private int dias;
    private double precioDiario;

    private static int contador = 1;

    public Arriendo(Vehiculo vehiculo, Cliente cliente,
            LocalDate fechaArriendo, int dias, double precioDiario) {
        this.numeroArriendo = contador++;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        setFechaArriendo(fechaArriendo);
        setDias(dias);
        setPrecioDiario(precioDiario);
    }

    public void setFechaArriendo(LocalDate fechaArriendo) {
        if (validarFecha(fechaArriendo)) {
            this.fechaArriendo = fechaArriendo;
        } else {
            mostrarMensaje("El valor de la fecha de arriendo no es valido");
        }
    }

    public void setDias(int dias) {
        if (validarDias(dias)) {
            this.dias = dias;
        } else {
            mostrarMensaje("Valor de dias arrendado invalido");
        }
    }

    public void setPrecioDiario(double precioDiario) {
        if (validarPrecio(precioDiario)) {
            this.precioDiario = precioDiario;
        } else {
            mostrarMensaje("Precio diario invalido");
        }
    }

    public boolean validarPrecio(double precioDiario) {
        return precioDiario > 0;
    }

    public boolean validarDias(int dias) {
        return dias > 1 && dias < 10;
    }

    public boolean validarFecha(LocalDate fechaArriendo) {
        if (fechaArriendo == null) {
            return false;
        }

        LocalDate hoy = LocalDate.now();
        return !fechaArriendo.isBefore(hoy);
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public boolean evaluarArriendo() {
        if (!cliente.isVigente()) {
            mostrarMensaje("Cliente no vigente");
            return false;
        }

        if (vehiculo.getCondicion() != 'D') {
            mostrarMensaje("Vehículo no disponible");
            return false;
        }

        return true;
    }

    public boolean ingresarArriendo() {
        if (evaluarArriendo()) {
            vehiculo.marcarArrendado();
            mostrarMensaje("Arriendo ingresado correctamente");
            return true;
        } else {
            mostrarMensaje("No se pudo ingresar el arriendo");
            return false;
        }
    }

    public LocalDate getFechaArriendo() {
        return fechaArriendo;
    }

    public void marcarDisponible() {
        vehiculo.marcarDisponible();
    }

    public double calcularMonto() {
        return precioDiario * dias;
    }

    public void generarTicket() {
        System.out.println("===============================================");
        System.out.println("        TICKET ARRIENDO DE VEHÍCULO");
        System.out.println("===============================================");

        System.out.printf("NÚMERO ARRIENDO : %s%n", numeroArriendo);
        System.out.printf("VEHÍCULO        : %s%n", vehiculo.getVehiculo());
        System.out.printf("PRECIO DIARIO   : $%.0f%n", precioDiario);

        System.out.println("\n-----------------------------------------------");

        System.out.printf("%-12s %-25s %-10s %-10s%n",
                "FECHA", "CLIENTE", "DÍAS", "A PAGAR");

        System.out.println("-----------------------------------------------");

        System.out.printf("%-12s %-25s %-10s $%-10.0f%n",
                fechaArriendo, cliente.getCliente(), dias + " días", calcularMonto());

        System.out.println("-----------------------------------------------");

        System.out.printf("%40s%n", "FIRMA CLIENTE");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public String toString() {
        return "Arriendo{" +
                "numero=" + numeroArriendo +
                ", cliente=" + cliente.getCliente() +
                ", vehiculo=" + vehiculo.getVehiculo() +
                ", dias=" + dias +
                '}';
    }
}
