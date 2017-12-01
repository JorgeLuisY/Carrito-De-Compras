package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Modelo.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

    String usu="";
    String nom="";
    HttpSession sesionOK=request.getSession();
    
if(sesionOK.getAttribute("perfil")!=null)
    nom=(String)sesionOK.getAttribute("nom")+" "+(String)sesionOK.getAttribute("ape");
    
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Carrito de Compras</title>\n");
      out.write("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/estilos.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/owl.carousel.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css\">\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/flaticon.css\"> \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <nav class=\"navbar navbar-default navbar-fixed-top\">\n");
      out.write("  <div class=\"container\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">FcCarrito</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\n");
      out.write("      <ul class=\"nav navbar-nav\">\n");
      out.write("        <li><a href=\"index.jsp\">Catálogo</a></li>\n");
      out.write("        ");

                        if(sesionOK.getAttribute("perfil")!=null && sesionOK.getAttribute("perfil").equals("Admin")){
                    
      out.write("\n");
      out.write("        <li><a href=\"registrarProducto.jsp\">Registrar Producto</a></li>\n");
      out.write("                ");

                    }
                        if(sesionOK.getAttribute("perfil")!=null){
                    
      out.write("\n");
      out.write("                <li><a href=\"registrarVenta.jsp\">Registrar ventas</a></li>\n");
      out.write("                ");

                    }
                        if(sesionOK.getAttribute("perfil")!=null && sesionOK.getAttribute("perfil").equals("Admin")){
                    
      out.write("\n");
      out.write("                <li><a href=\"ServletControlador?accion=MostrarVentas\">Consultar Ventas</a></li>\n");
      out.write("                ");

                    }

      out.write("\n");
      out.write("                ");
if(sesionOK.getAttribute("perfil")!=null){
                    
      out.write("\n");
      out.write("                <li><a href=\"ServletLogueo?accion=cerrar\">Cerrar Sesión</a></li>\n");
      out.write("                ");

                    }
                    
      out.write("\n");
      out.write("      </ul>      \n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("        ");
if(sesionOK.getAttribute("perfil")!=null){
                    
      out.write("\n");
      out.write("           <li>");
out.println("Bienvenido : "+nom);
      out.write("\n");
      out.write("                </li>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("                \n");
      out.write("                ");

               if(sesionOK.getAttribute("perfil")==null){
               
      out.write("\n");
      out.write("                <li><a href=\"login.jsp\">Iniciar Sesion</a></li>\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("      </ul>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("        \n");
      out.write("   <!-- STAR SLIDER -->\n");
      out.write("       <div class=\"container-fluid\">\n");
      out.write("           <div class=\"row\">\n");
      out.write("               <div class=\"col-md-12\">\n");
      out.write("                   <div class=\"jumbotron\">\n");
      out.write("                      <h1>Carrito</h1>\n");
      out.write("                      <p>DE COMPRAS</p>\n");
      out.write("                      <p>Formando Codigo</p>\n");
      out.write("                    </div>\n");
      out.write("               </div>\n");
      out.write("           </div>\n");
      out.write("       </div>\n");
      out.write("       <!-- END SLIDER -->     \n");
      out.write("        \n");
      out.write("        \n");
      out.write("         <!-- STAR PRODUCTO -->\n");
      out.write("       <section id=\"producto\">\n");
      out.write("           <div class=\"container\">\n");
      out.write("               <div class=\"row\">\n");
      out.write("                   <div class=\"col-md-12\">\n");
      out.write("                       <div class=\"titulo\">\n");
      out.write("                           <h2>Catalogo de Productos</h2>\n");
      out.write("                           <div class=\"hr\"></div>\n");
      out.write("                       </div>\n");
      out.write("                   </div>\n");
      out.write("                   \n");
      out.write("                   \n");
      out.write("                   ");

                  ArrayList<Producto> lista = ProductoDB.obtenerProducto();
               
                  for (Producto p : lista) {
                
      out.write("\n");
      out.write("                    <div class=\"col-sm-4 col-lg-4 col-md-4\">\n");
      out.write("                        <div class=\"thumbnail text-center\">                            \n");
      out.write("                            <img src=\"img/");
      out.print(p.getImagen());
      out.write("\" class=\"img-responsive\" alt=\"\">                                                                                         \n");
      out.write("                            <div class=\"caption\">\n");
      out.write("                                <h4 class=\"pull-right precio\">");
      out.print( p.getPrecio());
      out.write("</h4>\n");
      out.write("                                <h4><a href=\"#\">");
      out.print( p.getNombre());
      out.write("</a>\n");
      out.write("                                </h4>\n");
      out.write("                                \n");
      out.write("                                ");

                            if(sesionOK.getAttribute("perfil")!=null && sesionOK.getAttribute("perfil").equals("Admin")){
                             
      out.write("\n");
      out.write("                     <a class=\"btn btn-primary\" href=\"actualizarProducto.jsp?id=");
      out.print( p.getCodigoProducto());
      out.write("\">Modificar</a> \n");
      out.write("                     ");
 
                        }
                     
      out.write("\n");
      out.write("                     <a class=\"btn btn-primary\" href=\"anadirCarrito.jsp?id=");
      out.print( p.getCodigoProducto());
      out.write("\">Añadir</a>\n");
      out.write("              </div>                                \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                ");

                    }
                    
      out.write("\n");
      out.write("                   \n");
      out.write("                   \n");
      out.write("                </div>\n");
      out.write("           </div>\n");
      out.write("       </section>\n");
      out.write("         \n");
      out.write("         </main> \n");
      out.write("  <script src=\"js/jquery.js\"></script>\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("<script src=\"js/owl.carousel.js\"></script>\n");
      out.write("<script src=\"js/code.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
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
