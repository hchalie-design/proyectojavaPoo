package Proyecto;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Controlador controlador = new Controlador();
        controlador.cargar();                        
        List<Cliente> clientes = ArchivoUtil.cargarClientes(); 

        int opcion;
        do {
            mostrarMenu();
            opcion = leerInt("Opcion: ");

            switch (opcion) {
                case 1:
                    crearProducto(controlador);
                    guardarTodo(controlador, clientes);
                    break;

                case 2:
                    listarProductos(controlador);
                    break;

                case 3:
                    actualizarProducto(controlador);
                    guardarTodo(controlador, clientes);
                    break;

                case 4:
                    eliminarProducto(controlador);
                    guardarTodo(controlador, clientes);
                    break;

                case 5:
                    crearCliente(clientes);
                    guardarTodo(controlador, clientes);
                    break;

                case 6:
                    listarClientes(clientes);
                    break;

                case 0:
                    guardarTodo(controlador, clientes);
                    System.out.println("Cambios guardados ");
                    break;

                default:
                    System.out.println("Opcion invalida ");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("\n=== GALERIA ARTE MARCOS - CRUD ===");
        System.out.println("1) Crear producto");
        System.out.println("2) Leer productos");
        System.out.println("3) Actualizar producto");
        System.out.println("4) Eliminar producto");
        System.out.println("5) Crear cliente");
        System.out.println("6) Mostrar clientes");
        System.out.println("0) Salir");
    }

    private static void guardarTodo(Controlador c, List<Cliente> clientes) {
        ArchivoUtil.guardarTodo(c.listar(), clientes); 
    }
    private static void crearProducto(Controlador c) {
        System.out.println("\nTipo de producto:");
        System.out.println("1) Marco");
        System.out.println("2) Pincel");
        System.out.println("3) Producto ");
        int tipo = leerInt("Opcion: ");

        String codigo = leerTexto("Codigo: ");
        String nombre = leerTexto("Nombre: ");
        double precio = leerDouble("Precio: ");
        int stock = leerInt("Stock: ");

        Producto p;
        if (tipo == 1) {
            String material = leerTexto("Material del marco: ");
            p = new Marco(codigo, nombre, precio, stock, material);
        } else if (tipo == 2) {
            String cerdas = leerTexto("Tipo de punta: ");
            p = new Pincel(codigo, nombre, precio, stock, cerdas);
        } else {
            p = new ProductoSimple(codigo, nombre, precio, stock);
        }

        boolean ok = c.agregar(p);
        if (ok) {
            System.out.println("Producto agregado ");
        } else {
            System.out.println("No se pudo agregar ");
        }
    }

    private static void listarProductos(Controlador c) {
        System.out.println("\n=== LISTA DE PRODUCTOS ===");
        List<Producto> lista = c.listar();
        if (lista.isEmpty()) {
            System.out.println("No hay ");
            return;
        }
        for (Producto p : lista) {
            System.out.println(p);
        }
    }

    private static void actualizarProducto(Controlador c) {
        System.out.println("\n=== ACTUALIZAR PRODUCTO ===");
        String codigo = leerTexto("Codigo a actualizar: ");
        Producto existente = c.buscar(codigo);
        if (existente == null) {
            System.out.println("No existe ");
            return;
        }
        String nuevoNombre = leerTexto("Nuevo nombre: ");
        double nuevoPrecio = leerDouble("Nuevo precio: ");
        int nuevoStock = leerInt("Nuevo stock: ");

        boolean ok = c.actualizar(codigo, nuevoNombre, nuevoPrecio, nuevoStock);
        if (ok) {
            System.out.println("Producto actualizado ");
        } else {
            System.out.println("No se pudo actualizar ");
        }
    }

    private static void eliminarProducto(Controlador c) {
        System.out.println("\n=== ELIMINAR PRODUCTO ===");
        String codigo = leerTexto("Codigo a eliminar: ");
        boolean ok = c.eliminar(codigo);
        if (ok) {
            System.out.println("Producto eliminado ");
        } else {
            System.out.println("No existe ");
        }
    }

    private static void crearCliente(List<Cliente> clientes) {
        System.out.println("\n=== CREAR CLIENTE ===");
        String nombre = leerTexto("Nombre: ");
        String nit = leerTexto("NIT: ");
        String correo = leerTexto("Correo: ");
        clientes.add(new Cliente(nombre, nit, correo));
        System.out.println("Cliente creado ");
    }

    private static void listarClientes(List<Cliente> clientes) {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes ");
            return;
        }
        for (Cliente cli : clientes) {
            System.out.println(cli);
        }
    }
    private static int leerInt(String etiqueta) {
        while (true) {
            System.out.print(etiqueta);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Número invalido ");
            }
        }
    }

    private static double leerDouble(String etiqueta) {
        while (true) {
            System.out.print(etiqueta);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Número invalido ");
            }
        }
    }

    private static String leerTexto(String etiqueta) {
        System.out.print(etiqueta);
        return sc.nextLine().trim();
    }
}
