package Models;

public class Usuario {
	String nombre_usuario;
	String contrasena;
	public Usuario () {
		
	}
	
	public Usuario (String nombre_usuario, String contrasena) {
		this.nombre_usuario=nombre_usuario;
		this.contrasena=contrasena;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

}
