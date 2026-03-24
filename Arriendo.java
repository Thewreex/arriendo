
import java.time.LocalDate;

public class Arriendo {
    private int numeroArriendo;
    private Vehiculo vehiculo;
    private Cliente cliente;
    private LocalDate fechaArriendo;
    private int dias;
    private int monto;

    public Arriendo(int numeroArriendo, Vehiculo vehiculo, Cliente cliente,
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
    public Vehiculo getVehiculo() { return vehiculo; }
    public Cliente getCliente() { return cliente; }
    public LocalDate getFechaArriendo() { return fechaArriendo; }
    public int getDias() { return dias; }
    public int getMonto() { return monto; }
}
