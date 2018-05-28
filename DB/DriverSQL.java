package DB;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class DriverSQL {
	private Statement st=null;
	private static Connection con=null;
	
	public Connection conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/usuarios-tiempo","root","");
			if(con==null) {
				System.out.println("base de datos cargada");
			}else {
				System.out.println("base de base de datos cargada");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public ResultSet executeSql(String sql) {
		// TODO Auto-generated method stub
		try {
			st = con.createStatement();
			return st.executeQuery(sql);
		}catch (SQLException e){
			//recorrer el resultado
			e.printStackTrace();
			
		}
		return null;
		
	}
	public void updateSql(String sql) {
		// TODO Auto-generated method stub
		try {
			st = con.prepareStatement(sql);
			//st.executeUpdate(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}

	}

}
