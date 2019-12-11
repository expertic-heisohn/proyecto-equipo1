package co.heinsohn.api.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.heinsohn.api.util.DateUtil;
import co.heinsohn.api.util.NumberUtil;
import com.google.gson.Gson;

import co.heinsohn.api.ejb.EmpleadoLocalEJB;
import co.heinsohn.api.ejb.domain.Empleado;

/**
 * Servlet implementation class EmpleadoRestServlet
 */
@WebServlet("/EmpleadoRestServlet")
public class EmpleadoRestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(beanName = "EmpleadoEJB")
	private EmpleadoLocalEJB empleadoEJB;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpleadoRestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if( req.getParameter("id") != null) {
			//CONSULTAMOS POR ID DE USUARIO
			consultarPorId(req, response);
		}else {
			List<Empleado> listaEmpleados = empleadoEJB.consultarTodos();
			
			Gson gson = new Gson();
			PrintWriter out = response.getWriter();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(gson.toJson(listaEmpleados));
			out.flush();
		}
	}

	private void consultarPorId(HttpServletRequest req, HttpServletResponse response) throws IOException {
		// llamar el ejb para consultar por ID
		
		empleadoEJB.consultarPorId(Long.parseLong(req.getParameter("id")));
		
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		//out.print(gson.toJson());
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BufferedReader bufferedReader = request.getReader();

		StringBuilder builderPayload = new StringBuilder();

		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			builderPayload.append(line);
		}

		Gson gson = new Gson();
		// Convertir el JSON a Objeto
		Empleado empleado = gson.fromJson(builderPayload.toString(), Empleado.class);
		System.out.println(empleado);
		
		empleadoEJB.insertar(empleado);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(gson.toJson(empleado));
		out.flush();

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BufferedReader bufferedReader = request.getReader();

		StringBuilder builderPayload = new StringBuilder();

		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			builderPayload.append(line);
		}

		Gson gson = new Gson();
		// Convertir el JSON a Objeto
		Empleado empleado = gson.fromJson(builderPayload.toString(), Empleado.class);
		System.out.println(empleado);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(gson.toJson(empleado));
		out.flush();
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		empleadoEJB.eliminarPorId(id);
	}

}
