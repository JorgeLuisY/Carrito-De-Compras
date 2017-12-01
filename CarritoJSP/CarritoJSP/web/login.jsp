<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true"%>
<%
    String usu="";
    String nom="";
    HttpSession sesionOK=request.getSession();
    
if(sesionOK.getAttribute("perfil")!=null)
    nom=(String)sesionOK.getAttribute("nom")+" "+(String)sesionOK.getAttribute("ape");
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><table border="0" width="1000" align="center">
            <tr bgcolor="skyblue">
                <th align="left"><a href="index.jsp">Catálogo</a></th>
                <%
                        if(sesionOK.getAttribute("perfil")!=null && sesionOK.getAttribute("perfil").equals("Admin")){
                    %>
                <th><a href="registrarProducto.jsp">Registrar Producto</a></th>
                <%
                    }
                        if(sesionOK.getAttribute("perfil")!=null){
                    %>
                <th><a href="registrarVenta.jsp">Registrar ventas</a></th>
                <%
                    }
                        if(sesionOK.getAttribute("perfil")!=null && sesionOK.getAttribute("perfil").equals("Admin")){
                    %>
                <th><a href="ServletControlador?accion=MostrarVentas">Consultar Ventas</a></th>
                <%
                    }
%><%if(sesionOK.getAttribute("perfil")!=null){
                    %>
                <th><a href="ServletLogueo?accion=cerrar">Cerrar Sesión</a></th>
                <th width="200"><%out.println("Bienvenido : "+nom);%>
                </th>
                <%
                    }
                %>
                
                <%
               if(sesionOK.getAttribute("perfil")==null){
               %>
                <th width="200"><a href="login.jsp">Iniciar Sesion</a></th>
                <% } %>
            </tr>
        </table>
        <h2 align="center">Logueo de Usuarios</h2>
        <table border="0" width="300" align="Center">
        <form action="ServletLogueo" method="post">
           <input type="hidden" name="accion" value="loguin"/>
           <tr>
               <td>Usuario:</td>
               <td><input type="text" placeholder="Usuario" name="txtUsu"></td>
           </tr>
            <tr>
               <td>Passoword:</td>
               <td> <input type="password" placeholder="Password" name="txtPas"></td>
           </tr>                  
           <tr>
               <th colspan="2">
                 <input type="submit" name="btn" value="Iniciar Sesion"> 
               </th>
           </tr> 
           </form>
        </table>
        <h4 align="center">
             <%
              if(request.getAttribute("msg")!=null)
                 out.println(request.getAttribute("msg"));
             %>
       </h4>
    </body>
</html>

