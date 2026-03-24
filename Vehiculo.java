
import java.time.LocalDate;

public class Vehiculo {
    private String patente;
    private String marca;
    private String modelo;
    private int anio;
    private String condicion;

    public Vehiculo(String patente, String marca, String modelo, int anio, String condicion) {
        this.patente = patente.toUpperCase();
        this.marca = marca.toUpperCase();
        this.modelo = modelo.toUpperCase();

        int anioActual = LocalDate.now().getYear();
        if (anio >= 2000 && anio <= anioActual) {
            this.anio = anio;
        } else {
            throw new IllegalArgumentException("Año inválido");
        }

        this.condicion = (condicion == null || condicion.isEmpty()) ? "D" : condicion.toUpperCase();
    }

    public String getPatente() { return patente; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public int getAnio() { return anio; }
    public String getCondicion() { return condicion; }
}
