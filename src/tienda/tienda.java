package tienda;

import java.util.Scanner;
import tienda.Entidades.Fabricante;
import tienda.Entidades.Producto;
import tienda.Servicios.FabricanteService;
import tienda.Servicios.ProductoDTO;
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
            System.out.println("6.Ingresar un producto a la base de datos.");
            System.out.println("7.Ingresar un fabricante a la base de datos");
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

                    break;

                case 7:

                    break;

                case 8:

                    break;

                case 9:
                    EXIT = true;

                    break;

            }

        }

        // Fabricante fabricante = f1.buscarFabricantePorNombre("eklflk");
        //  System.out.println(fabricante);
        // p1.listarProductos();
        //  p1.listarPorNombreYPrecio();
        // p1.crearProducto("monitor",500 ,5);
          //p1.listarProductosPorNombre("Portátil");
           
        // p1.buscarPorNombreyPrecioB();
         p1.buscarPorNombreyPrecioB();
        
        // p1.crearProducto("gustavotoscano", 120, 3);
        // f1.crearFabricante(50, "gustavotoscano");
        //  p1.buscarPorNombreyPrecioB();
       //  p1.listarProductosEntrePrecios();
    }

}
