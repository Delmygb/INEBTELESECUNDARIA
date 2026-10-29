package gt.edu.inebtls.tablets_access_control.model;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String codigo;
    private Integer anioEscolar;
    
    // Mantenemos ambas referencias para evitar cualquier conflicto con el repositorio
    private boolean estadoTableta;
    private boolean tienetableta;

    public Estudiante() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Integer getAnioEscolar() { return anioEscolar; }
    public void setAnioEscolar(Integer anioEscolar) { this.anioEscolar = anioEscolar; }

    public boolean isEstadoTableta() { return estadoTableta; }
    public void setEstadoTableta(boolean estadoTableta) { 
        this.estadoTableta = estadoTableta; 
        this.tienetableta = estadoTableta;
    }

    public boolean isTienetableta() { return tienetableta; }
    public void setTienetableta(boolean tienetableta) { 
        this.tienetableta = tienetableta; 
        this.estadoTableta = tienetableta;
    }
}