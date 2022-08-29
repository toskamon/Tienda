package tienda.Servicios;

import java.util.Collection;
import tienda.Entidades.Fabricante;
import tienda.persistencia.fabricanteDAO;

public class FabricanteService {

    private final fabricanteDAO dao;

    public FabricanteService() {
        this.dao = new fabricanteDAO();
    }

    public void crearFabricante(int codigo, String nombre) throws Exception {
        try {

            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }

            if (codigo < 0) {
                throw new Exception("Debe ingresar un numero de codigo valido");
            }

            if (dao.buscarFabricantePorNombre(nombre) != null) {
                throw new Exception("Ya existe un fabricante con el nombre indicado " + nombre);
            }
            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);
            fabricante.setCodigo(codigo);
            dao.guardarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }
    
     public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {

        try {

            //Validamos
            if (nombre== null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del fabricante");
            }

           Fabricante fabricante = dao.buscarFabricantePorNombre(nombre);
           if (fabricante== null){
               throw new Exception ("no existe un fabricante con ese nombre");
           }

            return fabricante;
        } catch (Exception e) {
          throw  e;
        }
    }
      public Fabricante buscarFabricantePorCodigo(Integer codigo) throws Exception {

        try {

            //Validamos
            if (codigo == null) {
                throw new Exception("Debe indicar el codigo");
            }

            Fabricante fabricante = dao.buscarFabricantePorCodigo(codigo);

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }
     
 public void modificarCodigoFabricante(String nombre, int codigoActual,int codigoNuevo) throws Exception {

        try {

            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del fabricante");
            }

            if (codigoActual < 0 ) {
                throw new Exception("el codigo no existe");
            }

            if (codigoNuevo < 0 ) {
                throw new Exception("el codigo debe tener un numero positivo");
            }

            //con esto buscamos un fabricante
            Fabricante fabricante = buscarFabricantePorNombre(nombre);

           
            if (fabricante.getCodigo()!= codigoActual) {
                throw new Exception("El codigo actual no es el registrado en la base de datos para el nombre indicado");
            }

            //Modificamos
            fabricante.setCodigo(codigoNuevo);

            dao.modificarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }
 public Collection<Fabricante> listarFabricante() throws Exception {

        try {

            Collection<Fabricante> fabricantes = dao.listarFabricantes();

            return fabricantes;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirFabricantes() throws Exception {

        try {

            //Listamos los fabricantes
            Collection<Fabricante> fabricantes = listarFabricante();

            //Imprimimos los fabricantes
            if (fabricantes.isEmpty()) {
                throw new Exception("No existen fabricantes para imprimir");
            } else {
                for (Fabricante f : fabricantes) {
                    System.out.println(f);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

}

