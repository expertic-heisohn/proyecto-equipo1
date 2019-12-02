package com.heinsonh.api.ejb.dao;

import org.hibernate.Session;

import com.heinsonh.api.hibernate.HibernateUtil;

public abstract class DAO {
		
	//La idea es obtener una session de la unidad de persistencia
	public Session createSession() {
		return HibernateUtil.getSessionFactory().openSession();
	}

}
