package Proyecto;

public abstract class Producto {                 
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;

    public Producto() {}

    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) { 
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio; 
    }
    public int getStock() { 
        return stock; 
    }
    public void setStock(int stock) { 
        this.stock = stock; 
    }

    public abstract String tipo();  
    public abstract String extra();  

    public String toLinea() {
        return tipo() + ";" + codigo + ";" + nombre + ";" + precio + ";" + stock + ";" + extra();
    }

    @Override
    public String toString() {
        return "[" + tipo() + "] " + codigo + " | " + nombre + " | Q" + precio + " | stock: " + stock;
    }
}
