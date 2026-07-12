package modelo;

public class DetallePedido {

    private int idDetalle;
    private int fkIdPedido;
    private String fkCodProducto;
    private int cantidad;
    private double precioUnitario;

    public DetallePedido() {
    }

    public DetallePedido(int idDetalle, int fkIdPedido, String fkCodProducto, int cantidad, double precioUnitario) {
        this.idDetalle = idDetalle;
        this.fkIdPedido = fkIdPedido;
        this.fkCodProducto = fkCodProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public DetallePedido(String fkCodProducto, int cantidad, double precioUnitario) {
        this.fkCodProducto = fkCodProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getFkIdPedido() {
        return fkIdPedido;
    }

    public void setFkIdPedido(int fkIdPedido) {
        this.fkIdPedido = fkIdPedido;
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getSubtotal() {
        return cantidad * precioUnitario;
    }
}
