package controlador;

import dao.ProductoDAO;
import modelo.Producto;
import java.util.List;

public class ProductoController {

    private ProductoDAO productoDAO;

    public ProductoController() {
        productoDAO = new ProductoDAO();
    }

    public boolean guardarProducto(String codigo, String nombre, double precio) {

        Producto producto = new Producto();

        producto.setCodProducto(codigo);
        producto.setNombre(nombre);
        producto.setPrecio(precio);

        return productoDAO.insertar(producto);
    }

    public List<Producto> listarProductos() {
        return productoDAO.listar();
    }

    public boolean editarProducto(String codigoOriginal, String codigoNuevo, String nombre, double precio) {

        Producto producto = new Producto();

        producto.setCodProducto(codigoNuevo);
        producto.setNombre(nombre);
        producto.setPrecio(precio);

        return productoDAO.editar(codigoOriginal, producto);
    }

    public boolean eliminarProducto(String codigo) {
        return productoDAO.eliminar(codigo);
    }

}