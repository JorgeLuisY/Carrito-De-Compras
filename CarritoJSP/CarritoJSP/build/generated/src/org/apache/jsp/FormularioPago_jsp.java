package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FormularioPago_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("<body>\n");
      out.write("      \n");
      out.write("\n");
      out.write("<form action=”https://www.paypal.com/cgi-bin/webscr” method=”post”>\n");
      out.write("\n");
      out.write("<input type=\"hidden\" name=\"cmd\" value=\"_ext-enter\" />\n");
      out.write("<input type=\"hidden\" name=\"redirect_cmd\" value=\"_xclick\" />\n");
      out.write("<input type=\"hidden\" name=\"business\" value=\"tucuentadepaypal@ejemplo.com\" />\n");
      out.write("<input type=\"hidden\" name=\"item_name\" value=\"Nombre del producto o productos\" />\n");
      out.write("<input type=\"hidden\" name=\"item_number\" value=\"Numero de referencia del producto\" />\n");
      out.write("<input type=\"hidden\" name=\"quantity\" value=\"2\" />\n");
      out.write("<input type=\"hidden\" name=\"amount\" value=\"14.99\" />\n");
      out.write("<input type=\"hidden\" name=\"currency_code\" value=\"EUR\" />\n");
      out.write("<input type=\"hidden\" name=\"return\" value=\"http://www.nutecoweb.com/return.html>\" />\n");
      out.write("<input type=\"hidden\" name=\"cancel_return\" value=\"http://www.nutecoweb.com/cancel.php\" />\n");
      out.write("<input type=\"hidden\" name=\"bn\" value=\"PP-BuyNowBF:btn_buynowCC_LG.gif:NonHostedGuest\" />\n");
      out.write("<input type=\"image\" src=\"http://www.paypal.com/es_XC/i/btn/x-click-but01.gif\" border=\"0\" name=\"submit\" alt=\"Pagar para completar la compra.\" />\n");
      out.write("\n");
      out.write("</form>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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
