
package Controlador;

import Modelo.Persona;
import Modelo.PersonaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


public class Controlador extends HttpServlet {
    Persona p = new Persona();
    PersonaDao pdao= new PersonaDao();
    

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        switch (accion) {
            case "Listar":
                List<Persona> datos = pdao.listar();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
                case "Nuevo":
                    request.getRequestDispatcher("agregar.jsp").forward(request, response);
                    break;
                case "Guardar":
                    p.setId(request.getParameter("txtid"));
                    p.setNombre(request.getParameter("txtnombre"));
                    p.setApellido(request.getParameter("txtapellido"));
                    p.setEmail(request.getParameter("txtemail"));
                    p.setTelefono(request.getParameter("txttelefono"));
                    pdao.agregar(p);
                    request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
               break;
                case "Editar":
                    Persona p = pdao.listarById(request.getParameter("id")); 
                    request.setAttribute("persona", p);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
                case "Actualizar":
                    Persona p2 = new Persona();
                    p2.setId(request.getParameter("txtid"));
                    p2.setNombre(request.getParameter("txtnombre"));
                    p2.setApellido(request.getParameter("txtapellido"));
                    p2.setEmail(request.getParameter("txtemail"));
                    p2.setTelefono(request.getParameter("txttelefono"));
                    pdao.actualizar(p2);
                    System.out.println(p2);
                    request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
               break;
                case    "Eliminar":
                    String id = request.getParameter("id");
                    pdao.eliminar(id);
                    request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
               break;
                default:
                throw new AssertionError();
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
