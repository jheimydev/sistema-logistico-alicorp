package modelo;

public class Incidencia {

    private int idIncidencia;
    private String tipo;
    private String descripcion;
    private int fkIdEntrega;

    public Incidencia() {
    }

    public Incidencia(int idIncidencia, String tipo, String descripcion, int fkIdEntrega) {
        this.idIncidencia = idIncidencia;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fkIdEntrega = fkIdEntrega;
    }

    public int getIdIncidencia() {
        return idIncidencia;
    }

    public void setIdIncidencia(int idIncidencia) {
        this.idIncidencia = idIncidencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFkIdEntrega() {
        return fkIdEntrega;
    }

    public void setFkIdEntrega(int fkIdEntrega) {
        this.fkIdEntrega = fkIdEntrega;
    }
}
