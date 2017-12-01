package Modelo;

import java.sql.*;
import java.util.ArrayList;
import Utils.Conexion;
import javax.swing.JOptionPane;

public class VentaDB {
    public static boolean insertarVenta(Venta varventa, ArrayList<DetalleVenta> d) {
        boolean rpta = false;
        try {
            Connection cn = Conexion.getConexion();
//            CallableStatement c2 = cn.prepareCall("{call sp_RegistrarVenta(?,?)}");
            PreparedStatement cl = cn.prepareStatement("INSERT INTO venta (cliente)  VALUES (?);");
//            PreparedStatement c2 = cn.prepareStatement("SELECT MAX(codigoVenta) FROM venta;");
//            c2.registerOutParameter(1, Types.INTEGER);
            cl.setString(1, varventa.getCliente());
            int i=cl.executeUpdate();
            
            int nco = 1;
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(codigoVenta) FROM venta;");
            if (rs.next()) {
             nco =rs.getInt(1);
            }
            
            int i2 = 0;
            varventa.setCodigoVenta(nco);
            PreparedStatement cl2 = cn.prepareStatement("INSERT INTO detalleventa (codigoVenta,codigoProducto,cantidad,descuento)  VALUES (?,?,?,?);");
            for (DetalleVenta aux : d) {
            cl2.setInt(1,nco);
            cl2.setInt(2, aux.getCodigoProducto());
            cl2.setDouble(3, aux.getCantidad());
            cl2.setDouble(4, aux.getDescuento());
            i2=cl2.executeUpdate();
            }
            if(i2==1){
                rpta=true;
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);}
        return rpta;
    }
    
     public static ArrayList<Venta> obtenerVentas() {
        ArrayList<Venta> lista = new ArrayList<Venta>();
        try {
            CallableStatement cl=Conexion.getConexion().prepareCall("{call sp_ventas()}");
            ResultSet rs = cl.executeQuery();
            while (rs.next()) {
                Venta v=new Venta(rs.getInt(1), rs.getString(2), 
                        rs.getTimestamp(3));
                lista.add(v);
            }
        } catch (Exception e) {System.out.println("ventas-->"+e);}
        return lista;
    }
    
}
