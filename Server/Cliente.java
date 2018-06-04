package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

public class Cliente extends Thread{
	private ServerThings server;
	private InforCliente infCli;
	private PrintWriter mOut;
	private BufferedReader mIn;
	private static Vector mListConsultas = new Vector();
	
	public Cliente (InforCliente mInforCli, ServerThings mServer) throws IOException {
		System.out.println("Cliente Conectado");
		this.infCli=mInforCli;
		this.server=mServer;
		Socket socket = mInforCli.mSocket;
		mIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		mOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
	}
	public synchronized static void addConsultas(String mConsulta){
		mListConsultas.add(mConsulta);
		System.out.println("estoy en enviar consulta");
    }
	public void sendConsultaCliente() throws InterruptedException{
		String consulta= null;
		while (mListConsultas.size()==0)
			wait();
			consulta = (String)mListConsultas.get(0);
			mListConsultas.remove(0);
			mOut.println(consulta);
			mOut.flush();
			
			
	}
	
	public void run() {
		String mensaje;
		try {
	           while ( (mensaje= mIn.readLine())!=null) {
	               ServerThings.tipoMensaje(mensaje);
	               //sendConsultas(mensaje);
	               sendConsultaCliente();
	           }
	          
	        } catch (IOException | InterruptedException e) {
	        	System.out.println(e);
	        }
	 
		infCli.mCliente.interrupt();
		
	}
}
