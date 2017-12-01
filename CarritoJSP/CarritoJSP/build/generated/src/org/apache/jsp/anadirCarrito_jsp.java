package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Modelo.*;
import java.util.*;

public final class anadirCarrito_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    String usu="";
    String nom="";
    HttpSession sesionOK=request.getSession();
    
if(sesionOK.getAttribute("perfil")!=null)
    nom=(String)sesionOK.getAttribute("nom")+" "+(String)sesionOK.getAttribute("ape");

    if (sesionOK.getAttribute("perfil") == null) {

      out.write('\n');
      if (true) {
        _jspx_page_context.forward("login.jsp");
        return;
      }
      out.write('\n');

} else {
usu = (String)sesionOK.getAttribute("perfil");
}

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");

    Producto p=ProductoDB.obtenerProducto(Integer.parseInt(request.getParameter("id")));

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table border=\"0\" width=\"1000\" align=\"center\">\n");
      out.write("            <tr bgcolor=\"skyblue\">\n");
      out.write("                <th><a href=\"index.jsp\">Catálogo</a></th>\n");
      out.write("                ");

                        if(sesionOK.getAttribute("perfil")!=null && sesionOK.getAttribute("perfil").equals("Admin")){
                    
      out.write("\n");
      out.write("                <th><a href=\"registrarProducto.jsp\">Registrar Producto</a></th>\n");
      out.write("                ");

                    }
                        if(sesionOK.getAttribute("perfil")!=null){
                    
      out.write("\n");
      out.write("                <th><a href=\"registrarVenta.jsp\">Registrar ventas</a></th>\n");
      out.write("                ");

                    }
                        if(sesionOK.getAttribute("perfil")!=null && sesionOK.getAttribute("perfil").equals("Admin")){
                    
      out.write("\n");
      out.write("                <th><a href=\"ServletControlador?accion=MostrarVentas\">Consultar Ventas</a></th>\n");
      out.write("                ");

                    }

      out.write(' ');
if(sesionOK.getAttribute("perfil")!=null){
                    
      out.write("\n");
      out.write("                <th><a href=\"ServletLogueo?accion=cerrar\">Cerrar Sesión</a></th>\n");
      out.write("                <th width=\"200\">");
out.println("Bienvenido : "+nom);
      out.write("\n");
      out.write("                </th>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("                \n");
      out.write("                ");

               if(sesionOK.getAttribute("perfil")==null){
               
      out.write("\n");
      out.write("                <th width=\"200\"><a href=\"login.jsp\">Iniciar Sesion</a></th>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </tr>\n");
      out.write(" </table>\n");
      out.write("        <h2 align=\"center\">Añadir producto a Carrito</h2>\n");
      out.write("    <form action=\"ServletControlador\">               \n");
      out.write(" <table border=\"0\" width=\"500\" align=\"center\">\n");
      out.write("\n");
      out.write("    <tr>\n");
      out.write("        <th rowspan=\"5\"><img src=\"img/");
      out.print(p.getImagen());
      out.write("\" width=\"140\" height=\"140\"></th>\n");
      out.write("        <th>Código</th>\n");
      out.write("        <th><input type=\"text\" name=\"txtCodigo\" value=\"");
      out.print(p.getCodigoProducto());
      out.write("\" readonly></th>\n");
      out.write("        </tr><tr>\n");
      out.write("        <th>Nombre</th>\n");
      out.write("        <th><input type=\"text\" name=\"txtNombre\" value=\"");
      out.print(p.getNombre());
      out.write("\" readonly >  </th>\n");
      out.write("        </tr><tr>\n");
      out.write("        <th>Precio</th>\n");
      out.write("        <th><input type=\"text\"  name=\"txtPrecio\" value=\"");
      out.print(p.getPrecio());
      out.write("\" readonly /></th>\n");
      out.write("        </tr><tr>\n");
      out.write("        <th>Cantidad</th>\n");
      out.write("        <th><input type=\"number\" value=\"0\" min=\"0\" name=\"txtCantidad\" value=\"0\" /></th>\n");
      out.write("        </tr>\n");
      out.write("        <tr>\n");
      out.write("        <th colspan=\"3\"><input type=\"submit\" value=\"Añadir\" name=\"btnAnadir\"></th>\n");
      out.write("        </tr>\n");
      out.write("        <input type=\"hidden\" name=\"accion\" value=\"AnadirCarrito\" />\n");
      out.write("                        \n");
      out.write(" </table> </form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
