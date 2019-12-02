package com.heinsonh.api.ejb.domain;

import java.util.Date;

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
@Table(name = "tbl_empleados")
public class Empleado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private long id;
	
	
	@Column(name = "emp_nombre", nullable = false)
	private String nombre;
	
	@Column(name = "emp_apellido", nullable = false, length = 20 )
	private String apellido;
	
	//me premite crear y configurar una columna en la tabla
	@Column(name = "emp_identificacion", nullable = false, unique = true)
	private String identificacion;

	
	@Column(name = "emp_direccion", nullable = false, length = 22)
	private String direccion;
	
	@Column(name = "emp_telefono", length = 16)
	private String telefono;
	
	@Column(name = "emp_salario")
	private Double salario;
	
	@Column(name = "emp_feNacimiento", length = 16)
	private Date feNacimiento;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double double1) {
		this.salario = double1;
	}

	public Date getFeNacimiento() {
		return feNacimiento;
	}

	public void setFeNacimiento(Date date) {
		this.feNacimiento = date;
	}

}
