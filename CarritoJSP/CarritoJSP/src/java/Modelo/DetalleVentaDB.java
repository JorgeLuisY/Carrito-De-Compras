package Modelo;

import Utils.Conexion;
import java.sql.*;
import java.util.ArrayList;

public class DetalleVentaDB {
        public static ArrayList<DetalleVenta> obtenerDetalleVenta(int num) {
        
       ArrayList<DetalleVenta> lista = new ArrayList<DetalleVenta>();
        try {
            CallableStatement cl = Conexion.getConexion().
                    prepareCall("{call sp_detalleVenta(?)}");
            cl.setInt(1, num);
            ResultSet rs = cl.executeQuery();
            while (rs.next()) {
                DetalleVenta v=new DetalleVenta(rs.getInt(1),
                        rs.getInt(2),rs.getInt(3),rs.getDouble(4));
                lista.add(v);
            }
        }catch (Exception e) {System.out.println(e);}
        return lista;
    }
}
