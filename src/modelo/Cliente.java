package modelo;

public class Cliente {

    private int idCliente;
    private String nombre;
    private String tipo;
    private String contacto;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String tipo, String contacto) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.tipo = tipo;
        this.contacto = contacto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
}