package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
	static ServerSocket serverSocket = null;
	public static final int PORT = 2018;
	private static BufferedReader in;
	private static BufferedWriter out;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			serverSocket= new ServerSocket(PORT);
			System.out.println("Server Creado");
			
			ServerThings mServerthings = new ServerThings();
			System.out.println("ServerThings en Marcha");
			mServerthings.start();
			
			while(true) {
				Socket socket = serverSocket.accept();
				InforCliente clienteInfor =new InforCliente();
				clienteInfor.mSocket = socket;
				System.out.println("Aceptando Conexiones...");
				
				Cliente cliente = new Cliente(clienteInfor,mServerthings);
				
				clienteInfor.mCliente = cliente;
				cliente.start();
				mServerthings.addmCliente(clienteInfor);
			
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}