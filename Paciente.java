
/**
 * Paciente es la clase que modela a los pacientes
 * @author javi-
 */
public class Paciente implements Comparable{
    private String nombre;
    private String descripcion;
    private char prioridad;

    public Paciente(String nombre, String descripcion, char prioridad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(char prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Compara a los pacientes según su prioridad
     * @param t
     * @return
     */
    @Override
    public int compareTo(Object t) {
        Paciente p2 = (Paciente) t;
        return this.prioridad-p2.getPrioridad();
    }

    @Override
    public String toString() {
        return "Paciente{" + "nombre=" + nombre + ", descripcion=" + descripcion + ", prioridad=" + prioridad + '}';
    }
    
}
