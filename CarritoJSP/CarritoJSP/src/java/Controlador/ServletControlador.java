
package Controlador;

import Modelo.DetalleVenta;
import Modelo.Producto;
import Modelo.ProductoDB;
import Modelo.Venta;
import Modelo.VentaDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Cibertec
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String accion = request.getParameter("accion");
        if (accion.equals("AnadirCarrito")) {
            this.anadirCarrito(request, response);
       }else if (accion.equals("ModificarProducto")) {
            this.actualizarProducto(request, response);
        }else if (accion.equals("RegistrarProducto")) {
            this.registrarProducto(request, response);
        }else if (accion.equals("RegistrarVenta")) {
            this.registrarVenta(request, response);
        }else if (accion.equals("MostrarVentas")) {
            this.MostrarVentas(request, response);
        }
    }
   
    
 private void MostrarVentas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Venta> lista=new ArrayList<>();
        lista=VentaDB.obtenerVentas();
        request.setAttribute("lista",lista);
        request.getRequestDispatcher("consultarVentas.jsp").forward(request, response);
    }
 
     private void registrarVenta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession sesion = request.getSession();
        Venta v=new Venta();
        v.setCliente(request.getParameter("txtCliente").toUpperCase());
        ArrayList<DetalleVenta> detalle  = (ArrayList<DetalleVenta>) sesion.getAttribute("carrito");
        boolean rpta=VentaDB.insertarVenta(v, detalle);
        
        double total=Double.parseDouble(request.getParameter("total"));
        
        if (rpta) {
          request.getSession().removeAttribute("carrito");
        response.sendRedirect("FormularioPago.jsp?total="+total);  
        //response.sendRedirect("mensaje.jsp?men=Se registro la venta de manera correcta");
          } else {
            response.sendRedirect("mensaje.jsp?men=No se registro la venta");
        }
    }
    
 private void anadirCarrito(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         System.out.print("cantidad-->");
        HttpSession sesion = request.getSession();
        ArrayList<DetalleVenta> carrito;
        
        if (sesion.getAttribute("carrito") == null) {
            carrito = new ArrayList<DetalleVenta>();
        } else {
            carrito = (ArrayList<DetalleVenta>) sesion.getAttribute("carrito");
        }
        Producto p = ProductoDB.obtenerProducto(Integer.parseInt(request.getParameter("txtCodigo")));
        
        DetalleVenta d = new DetalleVenta();
        d.setCodigoProducto(Integer.parseInt(request.getParameter("txtCodigo")));
        d.setProducto(p);
        d.setCantidad(Double.parseDouble(request.getParameter("txtCantidad")));
        double subTotal = p.getPrecio() * d.getCantidad();
        if (subTotal > 50) {
            d.setDescuento(subTotal * 0.05);
        } else {
            d.setDescuento(0);
        }
        int indice = -1;
        for (int i = 0; i < carrito.size(); i++) {
            DetalleVenta det = carrito.get(i);
            if (det.getCodigoProducto() == p.getCodigoProducto()) {
                indice = i;
                break;
            }
        }
        if (indice == -1) {
            carrito.add(d);
        }
        sesion.setAttribute("carrito", carrito);
       response.sendRedirect("registrarVenta.jsp");
    }

   private void actualizarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Producto p = new Producto(Integer.parseInt(request.getParameter("txtCodigo")),
        request.getParameter(("txtNombre").toString()),
         Double.parseDouble(request.getParameter("txtPrecio")));
        boolean rpta = ProductoDB.actualizarProducto(p);
        if (rpta) {
            response.sendRedirect("mensaje.jsp?men=Se actualizo el producto de manera correcta");
        } else {
            response.sendRedirect("mensaje.jsp?men=No se actualizo el producto");
        } 
        //response.sendRedirect("FormularioPago.jsp?total="+total);
   }
   
   private void registrarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pro=request.getParameter("txtNombre");
        double pre=Double.parseDouble(request.getParameter("txtPrecio"));
        String img=request.getParameter("txtImagen");
        
        Producto p=new Producto(pro, pre, img);
         boolean rpta = ProductoDB.insertarProducto(p);
        if (rpta) {
            response.sendRedirect("mensaje.jsp?men=Se registro del producto de manera correcta");
        } else {
           response.sendRedirect("mensaje.jsp?men=No se registro el producto");
        }
   }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
