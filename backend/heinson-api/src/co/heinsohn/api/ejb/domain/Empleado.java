package co.heinsohn.api.ejb.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_Id")
    private Long id;

    // me premite crear y configurar una columna en la tabla
    @Column(name = "emp_identificacion", nullable = false, unique = true)
    private String identificacion;

    @Column(name = "emp_nombre", nullable = false)
    private String nombre;

    @Column(name = "emp_apellido", nullable = false, length = 20)
    private String apellido;

    @Column(name = "emp_telefono", length = 16)
    private String telefono;

    @Column(name = "emp_direccion", nullable = false, length = 22)
    private String direccion;

    @Column(name = "emp_salario", precision = 20, scale = 2)
    private Double salario;

    @Column(name = "emp_fe_nac")
    @Temporal(TemporalType.TIMESTAMP)
    private Date feNacimiento;

    @ManyToOne
    @JoinColumn(name = "empleador_id_fk", referencedColumnName = "id")
    private Empleador empleador;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "empleados_por_empleador")
    private List<Empleador> empleadores;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getFeNacimiento() {
        return feNacimiento;
    }

    public void setFeNacimiento(Date feNacimiento) {
        this.feNacimiento = feNacimiento;
    }

    public List<Empleador> getEmpleadores() {
        if (this.empleadores == null) {
            this.empleadores = new ArrayList<Empleador>();
        }
        return empleadores;
    }

    public void setEmpleadores(List<Empleador> empleadores) {
        this.empleadores = empleadores;
    }

}
