package Controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DB.DriverSQL;
import Models.Usuario;
import Server.Cliente;


public class UserController {
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private static PreparedStatement pstmt=null;
	static DriverSQL drv = new DriverSQL();
	public static void anadirUser(Usuario user) {
		usuarios.add(user);
	}
	
	public static void guardaUsuarios(String nombre, String pass) {
		String sql;
		
			try {
				sql = "INSERT INTO usuarios (nombre_usuario,password) VALUES(?,?);";
				if(null==pstmt) {
					PreparedStatement pstmt=drv.conexion().prepareStatement(sql);
					pstmt.setString(1, nombre);
					pstmt.setString(2, pass);
					
					
					pstmt.executeUpdate();
				}
				drv.updateSql(sql);
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
		
		
		
	}
	public static void cargarUsers() {
		drv.conexion();
		String sql = "SELECT * from usuarios;";
		ResultSet rs = drv.executeSql(sql);
		
		try {
			while(rs.next()) {
				Usuario user = new Usuario();
				String nombre_usuario =rs.getString("nombre_usuario");
				String pass = rs.getString("password");
				
				user.setNombre_usuario(nombre_usuario);
				user.setContrasena(pass);
				
				anadirUser(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static boolean compruebaUser(String nombre, String pass) {
		cargarUsers();
		for(int i = 0 ; i<usuarios.size();i++) {
			if(!nombre.equals(usuarios.get(i).getNombre_usuario()) && !pass.equals(usuarios.get(i).getContrasena())) {
				System.out.println("El usuario No existe");
				Cliente.addConsultas("ACCESO: UsuarioIncorrecto");
				cargarUsers();
				return false;
			}else {
				System.out.println("El usuario Correcto");
				Cliente.addConsultas("ACCESO: UsuarioCorrecto");
				return true;
			}
		}
		return false;
	}

}
