package Proyecto;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private List<Producto> inventario = new ArrayList<>();

    public void cargar() { inventario = new ArrayList<>(ArchivoUtil.cargarProductos()); }

    public List<Producto> listar() { return inventario; }

    public Producto buscar(String codigo) {
        for (Producto p : inventario)
            if (p.getCodigo().equalsIgnoreCase(codigo)) return p;
        return null;
    }

    public boolean agregar(Producto p) {
        if (p == null || buscar(p.getCodigo()) != null) return false;
        if (p.getPrecio() < 0 || p.getStock() < 0) return false;
        return inventario.add(p);
    }

    public boolean actualizar(String codigo, String nuevoNombre, double nuevoPrecio, int nuevoStock) {
        if (nuevoPrecio < 0 || nuevoStock < 0) return false;
        Producto p = buscar(codigo);
        if (p == null) return false;
        p.setNombre(nuevoNombre);
        p.setPrecio(nuevoPrecio);
        p.setStock(nuevoStock);
        return true;
    }

    public boolean eliminar(String codigo) {
        Producto p = buscar(codigo);
        if (p == null) return false;
        return inventario.remove(p);
    }
}
