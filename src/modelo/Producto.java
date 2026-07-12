
package modelo;

public class Producto {
    
     private String codProducto;
    private String nombre;
    private double precio;

    public Producto() {
    }

    public Producto(String codProducto, String nombre, double precio) {
        this.codProducto = codProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
