package com.heinsonh.api.ejb.domain;

//JPA dependencias
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Permite decirle a JPA que el objeto puede ser persistido
@Entity
//Nos permite crear una tabla en base de datos
@Table(name = "tbl_empleadores")
public class Empleador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "empr_id")
	private long id;
	
	//me premite crear y configurar una columna en la tabla
	@Column(name = "empr_nit", nullable = false, unique = true)
	private String nit;
	
	@Column(name = "empr_razonSocial", nullable = false)
	private String razonSocial;

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

}
