package co.heinsohn.api.rest;


import co.heinsohn.api.ejb.EmpleadoEJB;
import co.heinsohn.api.ejb.EmpleadorEJB;
import co.heinsohn.api.ejb.EmpleadorLocalEJB;
import co.heinsohn.api.ejb.domain.Empleador;
import com.google.gson.Gson;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/EmpleadorRestServlet")
public class EmpleadorRestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB(beanName = "EmpleadorEJB")
    private EmpleadorLocalEJB empleadorEJB;

    public EmpleadorRestServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Empleador> listaEmpleadores = empleadorEJB.consultarTodos();

        Gson gson = new Gson();
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(gson.toJson(listaEmpleadores));
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Empleador empleador = new Empleador();
        empleador.setNit(req.getParameter("empler_nit"));
        empleador.setRazonSocial(req.getParameter("empler_razon_social"));
        empleador.setDireccionEmpresa(req.getParameter("empler_direccion"));
        empleador.setTelefonoEmpresa(req.getParameter("empler_telefono"));

        empleadorEJB.insertar(empleador);

        Gson gson = new Gson();
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(gson.toJson(empleador));
        out.flush();

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader bufferedReader = req.getReader();

        StringBuilder builderPayload = new StringBuilder();

        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            builderPayload.append(line);
        }

        Gson gson = new Gson();
        // Convertir el JSON a Objeto
        Empleador empleador = gson.fromJson(builderPayload.toString(), Empleador.class);
        System.out.println(empleador);

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        out.print(gson.toJson(empleador));
        out.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        empleadorEJB.eliminarPorId(id);

    }
}
