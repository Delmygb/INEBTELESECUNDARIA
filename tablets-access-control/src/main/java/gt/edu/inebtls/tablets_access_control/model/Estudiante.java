package gt.edu.inebtls.tablets_access_control.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(max = 120, message = "El nombre no puede pasar de 120 caracteres.")
    @Column(nullable = false, length = 120)
    private String nombre;

    @NotBlank(message = "El código es obligatorio.")
    @Size(min = 3, max = 20, message = "El código debe tener entre 3 y 20 caracteres.")
    @Column(nullable = false, length = 20)
    private String codigo;

    @NotNull(message = "El año escolar es obligatorio.")
    @Min(value = 1000, message = "El año debe ser 1000 o posterior.")
    @Max(value = 2100, message = "El año no puede pasar de 2100.")
    @Column(name = "anio_escolar")
    private Integer anioEscolar;

    @Column(name = "tienetableta", nullable = false)
    private boolean tienetableta = true;

    // CONSTRUCTOR VACÍO OBLIGATORIO PARA JPA
    public Estudiante() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getAnioEscolar() {
        return anioEscolar;
    }

    public void setAnioEscolar(Integer anioEscolar) {
        this.anioEscolar = anioEscolar;
    }

    public boolean isTienetableta() {
        return tienetableta;
    }

    public void setTienetableta(boolean tienetableta) {
        this.tienetableta = tienetableta;
    }
}