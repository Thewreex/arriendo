
import java.time.LocalDate;

public class Devolucion {
    private Arriendo arriendo;
    private LocalDate fechaDevolucion;

    public Devolucion(Arriendo arriendo, String fechaDevolucion) {
        this.arriendo = arriendo;
        LocalDate fechaDev = LocalDate.parse(fechaDevolucion);

        if (!fechaDev.isBefore(arriendo.getFechaArriendo())) {
            this.fechaDevolucion = fechaDev;
        } else {
            throw new IllegalArgumentException("Fecha inválida");
        }
    }

    public Arriendo getArriendo() { return arriendo; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
}
