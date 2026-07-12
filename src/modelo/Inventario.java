package modelo;

public class Inventario {

    private int idInventario;
    private String fkCodProducto;
    private int cantidad;

    public Inventario() {
    }

    public Inventario(int idInventario, String fkCodProducto, int cantidad) {
        this.idInventario = idInventario;
        this.fkCodProducto = fkCodProducto;
        this.cantidad = cantidad;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public String getFkCodProducto() {
        return fkCodProducto;
    }

    public void setFkCodProducto(String fkCodProducto) {
        this.fkCodProducto = fkCodProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}