package com.heinsonh.api.rest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.io.BufferedReader;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.heinsonh.api.ejb.EmpleadoLocalEJB;
import com.heinsonh.api.ejb.domain.Empleado;
import com.heinsonh.api.ejb.util.DateUtil;
import com.heinsonh.api.ejb.util.NumberUtil;

/**
 * Empleado API:
 * nos permite exponer las diferentes operaciones para el manejo de la
 * informacion del empleado
 * @author
 *
 */

@WebServlet(urlPatterns = "/api/v1/empleado")
public class EmpleadoRestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	// JNDI jndi:Ejb/Empledo
	@EJB(beanName = "EmpleadoEJB")
	private EmpleadoLocalEJB empleadoEJB;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpleadoRestServlet() {
		super();
		// TODO Auto-generated constructor stub
		// POJO

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			List<Empleado> listaEmpleados = empleadoEJB.consultarTodos();
		}
	
	/**
	 * nos permite registrar la informacion de un empleado
	 */	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Empleado empleado = new Empleado();
		empleado.setNombre(request.getParameter("nombre"));
		empleado.setApellido(request.getParameter("apellido"));
		empleado.setIdentificacion(request.getParameter("identificacion"));
		empleado.setDireccion(request.getParameter("direccion"));
		empleado.setTelefono(request.getParameter("telefono"));
		empleado.setSalario(NumberUtil.StrintToDouble(request.getParameter("salario")));
		empleado.setFeNacimiento(DateUtil.StringToDate(request.getParameter("feNacimiento")));

		empleadoEJB.insertar(empleado);
		
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(gson.toJson(empleado));
		out.flush();
	}
	
	/**
	 * nos permite actualizar la informacion de un empleado
	 */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BufferedReader bufferedReader = req.getReader();
		
		StringBuilder builderPayload = new StringBuilder();
		
		String line = null;
		while((line = bufferedReader.readLine()) != null) {
			builderPayload.append(line);
		}
		
		Gson gson = new Gson();
		//Convertir el JSON a Objeto
		Empleado empleado = gson.fromJson(builderPayload.toString(), Empleado.class);
		System.out.println(empleado);
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		out.print(gson.toJson(empleado));
		out.flush();
	}
	
	/**
	 * nos permite eliminar la informacion de un empleado
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		empleadoEJB.eliminarPorId(id);
	}

}
