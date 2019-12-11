package co.heinsohn.api.ejb.domain;

import javax.persistence.*;

@Entity
@Table(name = "tbl_Empleadores")
public class Empleador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "empler_nit", nullable = false, length = 20)
    private String nit;

    @Column(name ="empler_razon_social", nullable = false, length = 120)
    private String razonSocial;

    @Column(name = "empler_direccion", nullable = false, length = 30)
    private String direccionEmpresa;

    @Column(name = "empler_telefono", length = 16)
    private String telefonoEmpresa;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }
}
