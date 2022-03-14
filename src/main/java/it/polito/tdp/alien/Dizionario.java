package it.polito.tdp.alien;

import java.util.LinkedList;
import java.util.List;

public class Dizionario {
	
	private List<Parola> dizionario;

	public Dizionario() {
		dizionario = new LinkedList<Parola>();
	}
	
	public void clearDizionario() {
		dizionario.clear();
	}
	
	public void addParola(String parolaAliena, String parola) {
		Parola p = new Parola(parolaAliena, parola);
		dizionario.add(p);
	}
	
	public String traduciParolaAliena(String parolaAliena) {
		
		for(Parola p : dizionario) {
			if(p.getParolaAliena().compareTo(parolaAliena)==0) {
				return p.getParola();
			}
		}
		return null;
	}
	
	
	
}
