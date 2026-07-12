package modelo;

public class RutaDistribucion {

    private int idRuta;
    private String origen;
    private String destino;
    private double distancia;

    public RutaDistribucion() {
    }

    public RutaDistribucion(int idRuta, String origen, String destino, double distancia) {
        this.idRuta = idRuta;
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}
