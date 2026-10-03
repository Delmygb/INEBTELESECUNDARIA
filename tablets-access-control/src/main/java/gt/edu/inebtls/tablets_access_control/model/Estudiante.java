package gt.edu.inebtls.tablets_access_control.model;

public class Estudiante {
    private String nombre;
    private String estadodelatablet;
    private int edad;

    // Constructor vacío (obligatorio)
    public Estudiante() {
    }

    // Constructor con parámetros
    public Estudiante(String nombre, String estadodelatablet, int edad) {
        this.nombre = nombre;
        this.estadodelatablet = estadodelatablet;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadodelatablet() {
        return estadodelatablet;
    }

    public void setEstadodelatablet(String estadodelatablet) {
        this.estadodelatablet = estadodelatablet;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}