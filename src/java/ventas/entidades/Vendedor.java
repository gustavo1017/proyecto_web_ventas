package ventas.entidades;

/**
 *
 * @author Alumno
 */
public class Vendedor {
    private String codigo;
    private String nombre;
    private String apellido;
    private double sueldo;
    private String feIngreso;
    private String tipo;
    private String usuario;
    private String password;

    public Vendedor(String codigo, String nombre, String apellido, double sueldo, String feIngreso, String tipo, String usuario, String password) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sueldo = sueldo;
        this.feIngreso = feIngreso;
        this.tipo = tipo;
        this.usuario = usuario;
        this.password = password;
    }

    public Vendedor() {
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getFeIngreso() {
        return feIngreso;
    }

    public void setFeIngreso(String feIngreso) {
        this.feIngreso = feIngreso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
