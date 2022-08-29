package tienda.Servicios;


import java.util.Collection;

import tienda.Entidades.Producto;

import tienda.persistencia.productoDAO;

public class ProductoService {

    private FabricanteService serviceFabricante;
    private productoDAO dao;

    public ProductoService() {
        this.dao = new productoDAO();

    }

    public void crearProducto(String nombre, double precio, int codigoFabricante) throws Exception {

        try {

         
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            if (precio == 0) {
                throw new Exception("Debe indicar un precio");
            }

            if (codigoFabricante == -1) {
                throw new Exception("Debe indicar un numero positivo");
            }

          
           
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);

            dao.guardarProducto(producto);

        } catch (Exception e) {
            throw e;
        }
    }

    public Producto modificarProducto(int codigo, String nombre, double precio, int codigoFabricante) throws Exception {

        try {
         

            //Validamos
         
            if (codigo < 0) {
                throw new Exception("Debe indicar un codigo valido");
            }

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }

            if (precio == 0) {
                throw new Exception("Debe indicar el precio");
            }
            if (codigoFabricante < 0) {
                throw new Exception("Debe indicar el fabricante");
            }
            //Buscamos
            Producto producto =dao.buscarProductoPorCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigoFabricante);

            dao.modificarProducto(producto);
            return producto;
        } catch (Exception e) {
            throw e;
        }
        
    }

    public Collection<Producto> listarProductosPorNombre(String nombre) throws Exception {

        try {

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre ");
            }
            Collection<Producto> productos = dao.listarProductosPorNombre(nombre);

            if (productos == null) {
                throw new Exception("No se encontró un producto con ese codigo ");
            }
            System.out.println(productos);
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductos();
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para listar");
            } else {
                for (Producto P : productos) {
                    
                   System.out.println(P.toString());
                }
            }
         
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }



    public Collection<ProductoDTO> listarPorNombreYPrecio() throws Exception {

        try {

            Collection<ProductoDTO> productos = dao.listarPorNombreYPrecio();
             if (productos.isEmpty()) {
                throw new Exception("No existen productos para listar");
            } else {
                for (ProductoDTO P : productos) {
                    
                    System.out.println(P.toString());
                }
            }

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }



    public Collection<Producto> listarProductosEntrePrecios() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductosPorPrecio();
             if (productos.isEmpty()) {
                throw new Exception("No existen productos para listar");
            } else {
                for (Producto P : productos) {
                    System.out.println(P.toString());
                }
            }

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }



    public ProductoDTO buscarPorNombreyPrecioB() throws Exception {

        ProductoDTO producto = dao.buscarPorNombreyPrecioMinimo();

        if (producto == null) {
            throw new Exception("No se encontró un producto con ese codigo ");
        }

        return producto;

    }
}
