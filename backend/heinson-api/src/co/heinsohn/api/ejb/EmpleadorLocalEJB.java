package co.heinsohn.api.ejb;

import co.heinsohn.api.ejb.dao.OperacionDAO;
import co.heinsohn.api.ejb.domain.Empleador;

import javax.ejb.Local;

@Local
public interface EmpleadorLocalEJB extends OperacionDAO<Empleador> {

}
