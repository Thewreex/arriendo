
import java.time.LocalDate;

public class Devolucion {
    private Arriendo arriendo;
    private LocalDate fechaDevolucion;

    public Devolucion(Arriendo arriendo, LocalDate fechaDevolucion) {
        this.arriendo = arriendo;
        setFecha(fechaDevolucion);
    }

    public void setFecha(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean validarFechaDevolucion(LocalDate fechaDevolucion) {
        if (fechaDevolucion == null) {
            return false;
        }

        return !fechaDevolucion.isBefore(arriendo.getFechaArriendo());
    }

    public boolean ingresarDevolucion(Vehiculo vehiculoIngresado) {

        if (vehiculoIngresado != arriendo.getVehiculo()) {
            mostrarMensaje("El vehículo no corresponde al arriendo");
            return false;
        }

        if (!validarFechaDevolucion(fechaDevolucion)) {
            mostrarMensaje("Fecha de devolución inválida");
            return false;
        }

        vehiculoIngresado.marcarDisponible();

        mostrarMensaje("Devolución realizada correctamente");
        return true;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    @Override
    public String toString() {
        return "Devolucion{" +
                "arriendo=" + arriendo.toString() +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
