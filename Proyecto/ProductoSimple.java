package Proyecto;

public class ProductoSimple extends Producto {
    public ProductoSimple(String codigo, String nombre, double precio, int stock) {
        super(codigo, nombre, precio, stock);
    }

    @Override
    public String tipo() {
        return "Producto simple";
    }

    @Override
    public String extra() {
        return "-";
    }
}
