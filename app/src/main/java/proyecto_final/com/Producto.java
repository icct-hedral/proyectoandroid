package proyecto_final.com;

public class Producto {

    private String codigo;
    private String nombre;
    private String categoria;
    private int fotoproducto;

    public Producto() {
    }

    public Producto(String codigo, String nombre, String categoria, int fotoproducto) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.fotoproducto = fotoproducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getFotoproducto() {
        return fotoproducto;
    }

    public void setFotoproducto(int fotoproducto) {
        this.fotoproducto = fotoproducto;
    }
}
