package controlador;

import dao.ClienteDAO;
import modelo.Cliente;
import java.util.List;


public class ClienteController {

    private ClienteDAO clienteDAO;

    public ClienteController() {
        clienteDAO = new ClienteDAO();
    }

    public boolean guardarCliente(int idCliente, String nombre, String tipo, String contacto) {

        Cliente cliente = new Cliente();

        cliente.setIdCliente(idCliente);
        cliente.setNombre(nombre);
        cliente.setTipo(tipo);
        cliente.setContacto(contacto);

        return clienteDAO.insertar(cliente);

    }
    
    public List<Cliente> listarClientes() {
    return clienteDAO.listar();
}

    public boolean editarCliente(int idOriginal, int idNuevo, String nombre, String tipo, String contacto) {

    Cliente cliente = new Cliente();

    cliente.setIdCliente(idNuevo);
    cliente.setNombre(nombre);
    cliente.setTipo(tipo);
    cliente.setContacto(contacto);

    return clienteDAO.editar(idOriginal, cliente);
}
    
    public boolean eliminarCliente(int id) {
    return clienteDAO.eliminar(id);
}
    
    
}