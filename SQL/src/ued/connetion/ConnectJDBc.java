package ued.connetion;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
public class ConnectJDBc {
	public static Connection getConnection() {
        try {
            String user = "root";
            String pass = "hailun123";
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306";
            Connection con = DriverManager.getConnection(url, user, pass);
            
            //4. Tạo đối tượng Statement
        	String sql = "SELECT * FROM dssv.dsbh";
			Statement stm = con.createStatement();
			//5. Thi hành câu truy vấn
			ResultSet rs = stm.executeQuery(sql);
			
            return con;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;

    }
  
    public static void main(String[] args) {
        Connection con = ConnectJDBc.getConnection();
        if (con != null) {
            System.out.println("Ket noi thanh cong!");
        } else {
            System.out.println("Ket noi that bai!");
        }
    }
}

