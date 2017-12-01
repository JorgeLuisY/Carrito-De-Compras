package Utils;
import java.sql.*;

public class Conexion {

    public static Connection getConexion(){
        
         Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/bdcarrito",
                    "root", "");
            System.out.print("Conexion Satisfactoria");
        } catch (Exception e) { System.out.print("Error de Conexion: "+e); }
        return cn;
        
    }
    
 
    
    public static void main(String[] args) throws SQLException {
        Connection v = Conexion.getConexion();
        String sql = "SELECT * FROM venta;";
        String datos[] = new String[3];
        Statement st= v.createStatement();
        ResultSet rs = st.executeQuery(sql);
        int i;
         if (rs.next()) {
             i =rs.getInt(1);
             System.out.println("Hola " + i);
             
        }
           
    }
    
}
