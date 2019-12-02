package com.heinsonh.api.ejb.dao;

import java.util.List;

/**
 * Es un contrato y nos permite exponer las diferentes operaciones
 * a la base de datos o de persistencia
 * @author
 *
 * @param <D> ES UN GENERIS, y nos va a servir para generar los metodos
 * GRUD de nuestra aplicacion
 */

public interface OperacionDAO<D> {
	
	List<D> consultarTodos();
	
	D consultarPorId(Long id);
	
	Boolean eliminarPorId(Long id);
	
	D insertar(D d);
	
	D actualizar(D d);

}
