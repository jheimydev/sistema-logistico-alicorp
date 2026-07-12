package modelo;

public class Despacho {

    private int idDespacho;
    private String estado;
    private String transportista;
    private int fkIdPedido;
    private int fkIdRuta;

    public Despacho() {
    }

    public Despacho(int idDespacho, String estado, String transportista, int fkIdPedido, int fkIdRuta) {
        this.idDespacho = idDespacho;
        this.estado = estado;
        this.transportista = transportista;
        this.fkIdPedido = fkIdPedido;
        this.fkIdRuta = fkIdRuta;
    }

    public int getIdDespacho() {
        return idDespacho;
    }

    public void setIdDespacho(int idDespacho) {
        this.idDespacho = idDespacho;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTransportista() {
        return transportista;
    }

    public void setTransportista(String transportista) {
        this.transportista = transportista;
    }

    public int getFkIdPedido() {
        return fkIdPedido;
    }

    public void setFkIdPedido(int fkIdPedido) {
        this.fkIdPedido = fkIdPedido;
    }

    public int getFkIdRuta() {
        return fkIdRuta;
    }

    public void setFkIdRuta(int fkIdRuta) {
        this.fkIdRuta = fkIdRuta;
    }
}
