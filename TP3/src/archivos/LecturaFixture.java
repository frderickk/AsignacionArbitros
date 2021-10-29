package archivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;


import objetos.Campeonato;


public class LecturaFixture {
	
	public static Campeonato leerFixture(String archivo) {
		Gson gson = new Gson();
		Campeonato aux = null;
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(archivo));
			aux = gson.fromJson(buffer, Campeonato.class);
		} catch(FileNotFoundException ex) {
	        System.out.println("Unable to open file '" + archivo + "'");                
	    }
	    catch(IOException ex) {
	        System.out.println("Error reading file '" + archivo + "'");                  
	    }
		return aux;
	}
	
	public static void main(String[] args) {
		Campeonato c = nuevoCampeonato();
		System.out.println(c.getArbitros());
	}
	
	public static Campeonato nuevoCampeonato() {
		return LecturaFixture.leerFixture("Campeonato.json");
	}

}
