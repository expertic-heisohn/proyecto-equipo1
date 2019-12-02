package com.heinsonh.api.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.Stateless;

import org.hibernate.Session;

import com.heinsonh.api.ejb.dao.DAO;
import com.heinsonh.api.ejb.dao.OperacionDAO;
import com.heinsonh.api.ejb.domain.Empleado;

import com.heinsonh.api.ejb.EmpleadoLocalEJB;
import com.heinsonh.api.ejb.EmpleadoRemoteEJB;

/**
 * 	Permite manejar las transacciones para la adminstracion
 * de la informacion de los empleados
 * @author 
 *
 */
@Stateless(name = "EmpleadoEJB")
public class EmpleadoEJB extends DAO implements EmpleadoLocalEJB, EmpleadoRemoteEJB {
	
	@override
	public List<Empleado> consultarTodos() {
		Session session = createSession();
		List<Empleado> empleados = session.createQuery("SELECT e FROM Empleado e", Empleado.class).getResultList();
		//JDCB - usamos SQL
		//JPA o Hibernate, Podemo usar JPQL - HSQL -> Generan consultas SQL
		session.close();
		return empleados;
	}

	@override
	public Empleado consultarPorId(Long id) {
		Session session = createSession();
		
		//JDCB - usamos SQL
		//JPA o Hibernate, Podemo usar JPQL - HSQL -> Generan consultas SQL
		return session.find(Empleado.class, id);
	}

	@override
	public Boolean eliminarPorId(Long id) {
		Session session = createSession();
		session.beginTransaction();
		Empleado empleado = session.find(Empleado.class, id);
		session.delete(empleado);
		session.getTransaction().commit();
		session.close();
		return Boolean.TRUE;
	}

	@override
	public Empleado insertar(Empleado empleado) {
		Session session = createSession();
		session.beginTransaction();		

		session.persist(empleado);			
		
		session.getTransaction().commit();
		session.close();
		return empleado;
	}

	@override
	public Empleado actualizar(Empleado empleado) {
		Session session = createSession();
		session.beginTransaction();
		session.merge(empleado);
		session.getTransaction().commit();
		session.close();
		return empleado;
	}

}
