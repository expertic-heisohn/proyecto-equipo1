package co.heinsohn.api.ejb;

import java.util.List;
import javax.ejb.Stateless;

import org.hibernate.Session;
import co.heinsohn.api.ejb.dao.DAO;
import co.heinsohn.api.ejb.domain.Empleado;


@Stateless(name = "EmpleadoEJB")
public class EmpleadoEJB extends DAO implements EmpleadoLocalEJB{

	@Override
	public List<Empleado> consultarTodos(){
		 Session session = createSession();
	        List<Empleado> empleados = session.createQuery("select e from Empleado e", Empleado.class)
	                .getResultList();
	        session.close();
	        return empleados;
	}


	@Override
	public Empleado consultarPorId(Long id) {
		Session session = createSession();
        return session.find(Empleado.class, id);
	}

	@Override
	public Boolean eliminarPorId(Long id) {
		Session session = createSession();
        session.beginTransaction();
        Empleado empleado = session.find(Empleado.class, id);
        session.delete(empleado);
        session.getTransaction().commit();
        session.close();
        return Boolean.TRUE;
	}

	@Override
	public Empleado insertar(Empleado empleado) {
		Session session = createSession();
        session.beginTransaction();
        session.persist(empleado);
        session.getTransaction().commit();
        session.close();
        return empleado;
	}

	@Override
	public Empleado actualizar(Empleado empleado) {
		Session session = createSession();
        session.beginTransaction();
        session.merge(empleado);
        session.getTransaction().commit();
        session.close();
        return empleado;
	}

}
