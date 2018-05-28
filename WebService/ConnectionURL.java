package WebService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ListIterator;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Server.Cliente;

public class ConnectionURL {
	private InputStream is=null;
	private HttpURLConnection urlConnection = null;
	
	private static void cosultaURL(String url) {
		// TODO Auto-generated method stub
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			// find all of the table rows
			Elements rows2 = ((Element) doc).select("td");
			//System.out.println(rows.toString());
			System.out.println("--------------------------------------------");
			System.out.println("esto contiene"+rows2.text());
			String[] tipoMsj=rows2.text().split(" ");
			Cliente.addConsultas("RESPUESTA: "+rows2.text());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void tratarLink(String consulta) {
		switch (consulta) {
			case "C064":
				String URL ="http://www.euskalmet.euskadi.eus/s07-3970x/es/meteorologia/lectur_fr.apl?e=5&anyo=2018&mes=2&dia=22&hora=09:50%2010:50&CodigoEstacion="+consulta+"&pagina=1&R01HNoPortal=true";
				cosultaURL(URL);
				break;
				
			case "C071":
				String URL1 ="http://www.euskalmet.euskadi.eus/s07-3970x/es/meteorologia/lectur_fr.apl?e=5&anyo=2018&mes=2&dia=22&hora=09:50%2010:50&CodigoEstacion="+consulta+"&pagina=1&R01HNoPortal=true";
				cosultaURL(URL1);
				break;
			case "C018":
				String URL2 ="http://www.euskalmet.euskadi.eus/s07-3970x/es/meteorologia/lectur_fr.apl?e=5&anyo=2018&mes=2&dia=22&hora=09:50%2010:50&CodigoEstacion="+consulta+"&pagina=1&R01HNoPortal=true";
				cosultaURL(URL2);
				break;
		
		}
		
	}
	
	public InputStream gesIs() {
		return is;
	}

	public static void main(String[] args) {
		
		//elemento a leer
		Scanner sc=new Scanner(System.in);
		System.out.println("escribe la consulta");
		
		tratarLink(sc.nextLine());
		// http://www.euskalmet.euskadi.eus/s07-3970x/es/meteorologia/lectur_fr.apl?e=5&anyo=2018&mes=2&dia=22&hora=09:50%2010:50&CodigoEstacion=C064&pagina=1&R01HNoPortal=true 
	}

}
