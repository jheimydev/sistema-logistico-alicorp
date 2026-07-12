package modelo;

import java.sql.Timestamp;

public class Entrega {

    private int idEntrega;
    private Timestamp fechaEntrega;
    private int fkIdDespacho;

    public Entrega() {
    }

    public Entrega(int idEntrega, Timestamp fechaEntrega, int fkIdDespacho) {
        this.idEntrega = idEntrega;
        this.fechaEntrega = fechaEntrega;
        this.fkIdDespacho = fkIdDespacho;
    }

    public int getIdEntrega() {
        return idEntrega;
    }

    public void setIdEntrega(int idEntrega) {
        this.idEntrega = idEntrega;
    }

    public Timestamp getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Timestamp fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getFkIdDespacho() {
        return fkIdDespacho;
    }

    public void setFkIdDespacho(int fkIdDespacho) {
        this.fkIdDespacho = fkIdDespacho;
    }
}
