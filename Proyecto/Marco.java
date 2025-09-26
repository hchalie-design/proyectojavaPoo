package Proyecto;

public class Marco extends Producto {
    private String material;

    public Marco() {}
    public Marco(String codigo, String nombre, double precio, int stock, String material) {
        super(codigo, nombre, precio, stock);
        this.material = material;
    }

    public String getMaterial() {
        return material; 
    }
    public void setMaterial(String material) { 
        this.material = material; 
    }

    @Override public String tipo() {
        return "MARCO"; 
    }
    @Override public String extra() {
        return material; 
    }
}
