package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.Entidades.Producto;

import tienda.Servicios.ProductoDTO;

public final class productoDAO extends DAO {

    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");
            }
            String sql = "INSERT INTO Producto (nombre, precio,codigo_Fabricante) "
                    + "VALUES ( '" + producto.getNombre() + "' , '" + producto.getPrecio() + "' ," + producto.getCodigoFabricante() + " );";

            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }

    }

    public void modificarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }
            String sql = "UPDATE Producto SET "
                    + " nombre = '" + producto.getNombre() + "' , precio = '" + producto.getPrecio() + "' , codigoFabricante = " + producto.getCodigoFabricante()
                    + " WHERE codigo = '" + producto.getCodigo() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarProducto(int codigo) throws Exception {
        try {
            String sql = "DELETE FROM Producto WHERE codigo = " + codigo + "";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Collection<Producto> listarProductosPorNombre(String nombre) throws Exception {
        try {
            String sql = "SELECT * FROM Producto WHERE Nombre like '%" + nombre + "%'";
            consultarBase(sql);
            Producto producto = null;
             Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
                //   Fabricante fabricante =fabricanteService.buscarFabricantePorCodigo(codigo);
                //  producto.setCodigoFabricante(fabricante.getCodigo());
                //   int r = producto.getCodigoFabricante();
                //  r = resultado.getInt(4);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarProductos() throws Exception {
        try {
            String sql = "SELECT * FROM Producto ";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    public Collection<ProductoDTO> listarPorNombreYPrecio() throws Exception {
        try {
            String sql = "SELECT Nombre,Precio FROM Producto ";
            consultarBase(sql);
            ProductoDTO productoDto = null;
            Collection<ProductoDTO> productos = new ArrayList();
            while (resultado.next()) {
                productoDto = new ProductoDTO();

                productoDto.setNombre(resultado.getString(1));
                productoDto.setPrecio(resultado.getInt(2));

                productos.add(productoDto);
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarProductosPorPrecio() throws Exception {
        try {
            String sql = "SELECT * FROM Producto where precio between 120 and 202; ";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getInt(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);
            }
            desconectarBase();
            return productos;

        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }

    public ProductoDTO buscarPorNombreyPrecioMinimo() throws Exception {
        try {
            String sql = "SELECT  nombre, min(precio) from producto";
            consultarBase(sql);
            ProductoDTO productoDto = null;
            while (resultado.next()) {
                productoDto = new ProductoDTO();

                productoDto.setNombre(resultado.getString(1));
                productoDto.setPrecio(resultado.getInt(2));
                 System.out.println(productoDto);
                //   Fabricante fabricante =fabricanteService.buscarFabricantePorCodigo(codigo);
                //  producto.setCodigoFabricante(fabricante.getCodigo());
                //   int r = producto.getCodigoFabricante();
                //  r = resultado.getInt(4);
            }
            desconectarBase();
            return productoDto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}
