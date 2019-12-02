package com.heinsonh.api.ejb;

import javax.ejb.Local;

import com.heinsonh.api.ejb.dao.OperacionDAO;
import com.heinsonh.api.ejb.domain.Empleado;

@Local
public interface EmpleadoLocalEJB extends OperacionDAO<Empleado> {

}
