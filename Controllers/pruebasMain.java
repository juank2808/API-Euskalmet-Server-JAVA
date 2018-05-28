package Controllers;

import java.util.Scanner;

import Models.Usuario;

public class pruebasMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int nmenu;
		
		do {
			Usuario user=new Usuario();
			System.out.println("Bienvenido al Registro de Usuarios elija una opcion: ");
			System.out.println("--------------------------------------------------------------");
			System.out.println("");
			System.out.println("1) Añadir un Usuario");
			System.out.println("2) Guardar");
			nmenu=sc.nextInt();
			switch(nmenu) {
				case 1:
					System.out.println("Añade Nombre: ");
					user.setNombre_usuario(sc.next());
					
					System.out.println("Añade Password: ");
					user.setContrasena(sc.next());
					
					UserController.anadirUser(user);
					
					break;
				case 2:
					//UserController.guardaUsuarios();
				break;	
				default: System.out.println("Tecla Pusada Incorrecta");
					
			}
		}while(nmenu<5);

	}

}
