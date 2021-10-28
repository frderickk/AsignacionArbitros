package archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import com.google.gson.Gson;
import objetos.Campeonato;

public class LecturaFixture {
	
	
	public static Campeonato leerFixture(String archivo) {
		Gson gson = new Gson();
		Campeonato aux = null;
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(archivo));
			aux = gson.fromJson(buffer, Campeonato.class);
		} catch (Exception e) {
			System.out.println("Error reading file : " + archivo);
			System.out.println(e.getClass());
			System.out.println(e.getStackTrace());
		}
		return aux;
	}

}
