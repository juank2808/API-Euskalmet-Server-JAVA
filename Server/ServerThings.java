package Server;

import java.net.Socket;
import java.util.Vector;

import Controllers.UserController;
import WebService.ConnectionURL;

public class ServerThings extends Thread {
	 private Vector mClientes = new Vector();
	 private Vector mConsultasMsj = new Vector();
	 
	public synchronized void addmCliente(InforCliente mCliente) {
		mClientes.add(mCliente);
	}
	private synchronized String getSiguienteConsulta() throws InterruptedException {
		while (mConsultasMsj.size()==0)
			wait();
			String consulta = (String)mConsultasMsj.get(0);
			mConsultasMsj.remove(0);
			return consulta;
		
	}
	
	public static void tipoMensaje(String mensaje) {
		
	
		String[] tipoMsj=mensaje.split(" ");
			System.out.println(tipoMsj[0]+" "+tipoMsj[1]);
		UserController.cargarUsers();
		
		//hacer el que si el mensaje es igual a esto hara acceso o consulta
		
		switch (tipoMsj[0]) {
			case "ACCESO":
				UserController.compruebaUser(tipoMsj[2], tipoMsj[4]);
				;break;
			case "REGISTRO":
				//llamo al metodo a Guardar
				UserController.guardaUsuarios(tipoMsj[2], tipoMsj[4]);
				;break;
			case "CONSULTA":
				//llamo al metodo a consultar
				
				System.out.println(tipoMsj[1]);
				ConnectionURL.tratarLink(tipoMsj[1]);
				
				;break;
		}
		
	}
	
	public void run(){
		try {
			while(true) {
					String consults = getSiguienteConsulta();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
