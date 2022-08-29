package tienda;

import java.util.Scanner;

import tienda.Entidades.Producto;
import tienda.Servicios.FabricanteService;

import tienda.Servicios.ProductoService;

public class tienda {

    public static void main(String[] args) throws Exception {
        ProductoService p1 = new ProductoService();
        FabricanteService f1 = new FabricanteService();
        Scanner leer = new Scanner(System.in);
        int Opcion;

        boolean EXIT = false;

        while (!EXIT) {

            System.out.println("BIENVENIDO");
            System.out.println("Por favor,eija que accion desea realizar");
            System.out.println("1. Lista el nombre de todos los productos que hay en la tabla producto.");
            System.out.println("2. Lista los nombres y los precios de todos los productos de la tabla producto.");
            System.out.println("3. Listar aquellos productos que su precio esté entre 120 y 202.");
            System.out.println("4. Buscar y listar todos los Portátiles de la tabla producto.");
            System.out.println("5. Listar el nombre y el precio del producto más barato.");
            System.out.println("6.crear un producto e ingresarlo a la base de datos.");
            System.out.println("7.crear un fabricante e Ingresarlo a la base de datos");
            System.out.println("8. Editar un producto.");
            System.out.println("9. EXIT");

            Opcion = leer.nextInt();
            switch (Opcion) {
                case 1:
                    p1.listarProductos();
                    break;
                case 2:
                    p1.listarPorNombreYPrecio();
                    break;
                case 3:
                    p1.listarProductosEntrePrecios();
                    break;

                case 4:
                    p1.listarProductosPorNombre("Portátil");
                    break;

                case 5:
                    p1.buscarPorNombreyPrecioB();
                    break;

                case 6:
                    System.out.println("ingrese el nombre del producto");
                    String nombre = leer.next();
                    System.out.println(" ingrese el precio del producto");
                    double p = leer.nextDouble();
                    System.out.println("ingrese el codigo de fabricante");
                    int cf = leer.nextInt();
                    p1.crearProducto(nombre, p, cf);

                    break;

                case 7:
                    System.out.println("ingrese el codigo ");
                    int c = leer.nextInt();
                    
                    System.out.println(" ingrese el nombre del fabricante");
                    String f = leer.next();
                    
                    f1.crearFabricante(c,f);
                    break;

                case 8:
                    System.out.println(" ingrese el codigo del producto a modificar");
                     int codigo =leer.nextInt();
                     System.out.println("ingrese el nombre del producto");
                     nombre = leer.next();
                     System.out.println("ingrese el precio");
                     double precio = leer.nextDouble();
                    System.out.println("ingrese el codigo del fabricante");
                    int codigoF = leer.nextInt();
                    Producto producto = p1.modificarProducto(codigo, nombre,precio, codigoF);
                    System.out.println(producto);
                   
                    break;

                case 9:
                    EXIT = true;
                    System.out.println("muchas gracias por elegir nuestro programa");

                    break;

            }

        }

      
    }

}
