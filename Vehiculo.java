
import java.time.LocalDate;

public class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private int anio;
    private char condicion;

    public Vehiculo(String patente, String marca, String modelo, int anio) {
        setPatente(patente);
        setMarca(marca);
        setModelo(modelo);
        setAnio(anio);
        this.condicion = 'D';
    }

    public void setPatente(String patente) {
        if (validarPatente(patente)) {
            this.patente = patente.toUpperCase();
        } else {
            mostrarMensaje("Patente invalida");
        }
    }

    public void setMarca(String marca) {
        if (validarMarca(marca)) {
            this.marca = marca.toUpperCase();
        } else {
            mostrarMensaje("Marca invalida");
        }
    }

    public void setModelo(String modelo) {
        if (validarModelo(modelo)) {
            this.modelo = modelo.toUpperCase();
        } else {
            mostrarMensaje("Modelo invalido");
        }
    }

    public void setAnio(int anio) {
        if (validarAnio(anio)) {
            this.anio = anio;
        } else {
            mostrarMensaje("El año ingresado es invalido");
        }
    }

    public boolean validarAnio(int anio) {
        int anioActual = LocalDate.now().getYear();
        return anio >= 2000 && anio <= anioActual;
    }

    public boolean validarPatente(String patente) {
        return (patente != null && !patente.trim().isEmpty());
    }

    public boolean validarMarca(String marca) {
        return (marca != null && !marca.trim().isEmpty());
    }

    public boolean validarModelo(String modelo) {
        return (modelo != null && !modelo.trim().isEmpty());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void asignarMantencion() {
        if (this.condicion == 'A') {
            mostrarMensaje("No se puede enviar a mantención, el vehículo está arrendado");
        } else {
            this.condicion = 'M';
        }
    }

    public void marcarDisponible() {
        this.condicion = 'D';
    }

    public void marcarArrendado() {
        this.condicion = 'A';
    }

    public char getCondicion() {
        return condicion;
    }

    public String getVehiculo() {
        return patente + " " + marca + " " + modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "patente='" + patente + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", condicion=" + condicion +
                '}';
    }
}
