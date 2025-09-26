package Proyecto;

public class Cliente {
    private String nombre;
    private String nit;
    private String correo;

    public Cliente(String nombre, String nit, String correo) {
        this.nombre = nombre;
        this.nit = nit;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    public String getNit() {
        return nit; 
    }
    public void setNit(String nit) { 
        this.nit = nit;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) { 
        this.correo = correo;
    }

    public String toLinea() {
        return "CLIENTE;" + nombre + ";" + nit + ";" + correo;
    }

    public static Cliente desdeLinea(String linea) {
        String[] a = linea.split(";");
        if (a.length != 4) return null;
        return new Cliente(a[1], a[2], a[3]);
    }

    @Override
    public String toString() {
        return "[Cliente] " + nombre + " | NIT: " + nit + " | Correo: " + correo;
    }
}
