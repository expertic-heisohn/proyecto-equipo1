package co.heinsohn.api.ejb;

import co.heinsohn.api.ejb.dao.OperacionDAO;
import co.heinsohn.api.ejb.domain.Empleado;

import javax.ejb.Local;

@Local
public interface EmpleadoLocalEJB extends OperacionDAO<Empleado>  {

}
