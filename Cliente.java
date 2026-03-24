
public class Cliente {
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
