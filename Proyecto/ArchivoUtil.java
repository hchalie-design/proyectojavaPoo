package Proyecto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUtil {

    public static final String RUTA = "datos.txt";

    public static void guardarTodo(List<Producto> productos, List<Cliente> clientes) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(RUTA))) {
            for (Producto p : productos) {
                pw.println(p.toLinea()); 
            }
            for (Cliente c : clientes) {
                pw.println(c.toLinea()); 
            }
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public static List<Producto> cargarProductos() {
        List<Producto> lista = new ArrayList<>();
        File f = new File(RUTA);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String s;
            while ((s = br.readLine()) != null) {
                if (s.trim().isEmpty()) continue;
                String[] a = s.split(";");
                if (a.length == 0) continue;

                String tipo = a[0].toUpperCase();

                if ("CLIENTE".equals(tipo)) continue;

                if (a.length < 6) continue;
                String codigo = a[1];
                String nombre = a[2];
                double precio = Double.parseDouble(a[3]);
                int    stock  = Integer.parseInt(a[4]);
                String extra  = a[5];

                if ("MARCO".equals(tipo)) {
                    lista.add(new Marco(codigo, nombre, precio, stock, extra)); // extra = material
                } else if ("PINCEL".equals(tipo)) {
                    lista.add(new Pincel(codigo, nombre, precio, stock, extra)); // extra = tipoCerdas
                } else { 
                    lista.add(new ProductoSimple(codigo, nombre, precio, stock));
                }
            }
        } catch (Exception e) {
            System.out.println("Error al cargar productos: " + e.getMessage());
        }
        return lista;
    }

    public static List<Cliente> cargarClientes() {
        List<Cliente> lista = new ArrayList<>();
        File f = new File(RUTA);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String s;
            while ((s = br.readLine()) != null) {
                if (s.trim().isEmpty()) continue;
                if (!s.startsWith("CLIENTE;")) continue;
                Cliente c = Cliente.desdeLinea(s);
                if (c != null) lista.add(c);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar clientes: " + e.getMessage());
        }
        return lista;
    }
}
