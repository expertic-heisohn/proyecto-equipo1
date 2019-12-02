package com.heinsonh.api.ejb;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.heinsonh.api.ejb.dao.DAO;
import com.heinsonh.api.ejb.dao.OperacionDAO;
import com.heinsonh.api.ejb.domain.Empleador;

/**
 * Permite manejar las trasacciones para la adminstracion de la
 * informacion de los empleadores
 * @author 
 *
 */
@Local
@Stateless(name = "EmpleadorEJB")
public class EmpleadorEJB extends DAO implements OperacionDAO<Empleador>{

	public List<Empleador> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	public Empleador consultarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean eliminarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Empleador insertar(Empleador d) {
		// TODO Auto-generated method stub
		return null;
	}

	public Empleador actualizar(Empleador d) {
		// TODO Auto-generated method stub
		return null;
	}	
	

}
