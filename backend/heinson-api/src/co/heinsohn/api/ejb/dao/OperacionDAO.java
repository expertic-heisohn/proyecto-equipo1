package co.heinsohn.api.ejb.dao;

import java.util.List;

public interface OperacionDAO<D> {
	
	public List<D> consultarTodos();
	
	public D consultarPorId(Long id);
	
	public Boolean eliminarPorId(Long id);
	
	public D insertar(D d);
	
	public D actualizar(D d);
	
	
	

}
