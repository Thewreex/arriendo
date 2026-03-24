public class Cliente {
    private String cedula;
    private String nombre;
    private boolean vigente;

    public Cliente(String cedula, String nombre) {
        setCedula(cedula);
        setNombre(nombre);
        this.vigente = true;
    }

    public void setCedula(String cedula) {
        if (validarCedula(cedula)) {
            this.cedula = cedula.toUpperCase();
        } else {
            mostrarMensaje("Cedula no valida");
        }
    }

    public boolean validarCedula(String cedula) {
        if (cedula == null || cedula.length() != 10) {
            return false;
        }

        if (cedula.charAt(8) != '-') {
            return false;
        }

        char ultDigito = cedula.charAt(9);
        return (ultDigito >= '0' && ultDigito <= '9') || (ultDigito == 'k' || ultDigito == 'K');
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.print(mensaje);
    }

}
