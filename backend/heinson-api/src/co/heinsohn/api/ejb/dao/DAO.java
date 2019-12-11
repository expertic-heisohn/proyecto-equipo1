package co.heinsohn.api.ejb.dao;

//import javax.persistence.EntityManager;

import org.hibernate.Session;

import co.heinsohn.api.hibernate.HibernateUtil;

public class DAO {
	
	//protected EntityManager entityManager;
	public Session createSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }

}
