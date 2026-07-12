package modelo;

import java.sql.Date;

public class OrdenPedido {

    private int idPedido;
    private Date fecha;
    private String estado;
    private double monto;
    private int fkIdCliente;

    public OrdenPedido() {
    }

    public OrdenPedido(int idPedido, Date fecha, String estado, double monto, int fkIdCliente) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.estado = estado;
        this.monto = monto;
        this.fkIdCliente = fkIdCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public int getFkIdCliente() {
        return fkIdCliente;
    }

    public void setFkIdCliente(int fkIdCliente) {
        this.fkIdCliente = fkIdCliente;
    }
}
