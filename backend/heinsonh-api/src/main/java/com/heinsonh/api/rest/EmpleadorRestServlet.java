package com.heinsonh.api.rest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heinsonh.api.ejb.EmpleadorEJB;

/**
 * Empleador API:
 * nos permite exponer las diferentes operaciones para el manejo de la
 * informacion del empleador
 * @author
 *
 */

@WebServlet(urlPatterns = "/api/v1/empleador")
public class EmpleadorRestServlet extends HttpServlet {
	
	private EmpleadorEJB empleadorEJB;
	
	/**
	 * Permite consultar la informacion de los empleadores o un empleador
	 */
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			super.doGet(req, resp);
		}
	
	/**
	 * nos permite registrar la informacion de un empleador
	 */	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	/**
	 * nos permite actualizar la informacion de un empleador
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
		
	}
	
	/**
	 * nos permite eliminar la informacion de un empleador
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}
