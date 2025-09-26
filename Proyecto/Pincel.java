package Proyecto;

public class Pincel extends Producto {
    private String tipoCerdas;

    public Pincel() {}
    public Pincel(String codigo, String nombre, double precio, int stock, String tipoCerdas) {
        super(codigo, nombre, precio, stock);
        this.tipoCerdas = tipoCerdas;
    }

    public String getTipoCerdas() { 
        return tipoCerdas;
    }
    public void setTipoCerdas(String tipoCerdas) {
        this.tipoCerdas = tipoCerdas; 
    }

    @Override
    public String tipo() {
        return "PINCEL";
    }
    @Override 
    public String extra() {
        return tipoCerdas; 
    }
}
