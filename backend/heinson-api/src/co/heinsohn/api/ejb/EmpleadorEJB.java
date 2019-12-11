package co.heinsohn.api.ejb;


import co.heinsohn.api.ejb.dao.DAO;
import co.heinsohn.api.ejb.domain.Empleador;
import org.hibernate.Session;

import javax.ejb.Stateless;
import java.util.List;

@Stateless(name = "EmpleadorEJB")
public class EmpleadorEJB extends DAO implements EmpleadorLocalEJB {

    @Override
    public List<Empleador> consultarTodos() {
        Session session = createSession();
        List<Empleador> empleadores = session.createQuery("select e from Empleador e", Empleador.class)
                .getResultList();
        session.close();
        return empleadores;
    }

    @Override
    public Empleador consultarPorId(Long id) {
        Session session = createSession();
        return session.find(Empleador.class, id);
    }

    @Override
    public Boolean eliminarPorId(Long id) {
        Session session = createSession();
        session.beginTransaction();
        Empleador empleador = session.find(Empleador.class, id);
        session.delete(empleador);
        session.getTransaction().commit();
        session.close();
        return Boolean.TRUE;
    }

    @Override
    public Empleador insertar(Empleador empleador) {
        Session session = createSession();
        session.beginTransaction();
        session.persist(empleador);
        session.getTransaction().commit();
        session.close();
        return empleador;
    }

    @Override
    public Empleador actualizar(Empleador empleador) {
        Session session = createSession();
        session.beginTransaction();
        session.merge(empleador);
        session.getTransaction().commit();
        session.close();
        return empleador;
    }

}
