public class Cliente {
    private String cedula;
    private String nombre;
    private boolean vigente;

    public Cliente(String cedula, String nombre) {
        // setCedula(cedula)
        // setNombre(nombre)
        this.vigente = true;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
