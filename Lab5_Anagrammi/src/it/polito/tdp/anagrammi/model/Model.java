package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class Model {

	Set <Parola> soluzioniGiuste; 
	Set <Parola> soluzioniSbagliate; 
	ArrayList<Character> caratteri; 
	Set<String> dizionario; 
	
	public Model() {
		DizionarioDAO dao= new DizionarioDAO(); 
		dizionario= dao.dizionario(); 
	}
	
	
	
	
	public void genera(String par) {
		Parola parziale= new Parola(par); 
		this.soluzioniSbagliate= new HashSet<Parola>(); 
		this.soluzioniGiuste= new HashSet<Parola>(); 
		this.cerca(parziale,0); 
	}
	
	

	
	
	private void cerca(Parola parziale, int L) {
		
		if(L==parziale.getSize()) {
			//le posizioni sono tutte piene
			//ULTIMA ITERAZIONE
			if(esisteParola(parziale)==true) {
				
				soluzioniGiuste.add(parziale.clone()); }
			else 
				soluzioniSbagliate.add(parziale.clone()); 
			
			
			return; 
		}
		
		//TUTTE LE ALTRE ITERAZIONI
		for(char c: parziale.getPar().toCharArray()) {
			if(parziale.possoInserire(c)) {
				parziale.add(c);
				
				cerca(parziale,L+1);
				parziale.remove(c); 
			}
			
			
		}
		
		
		
	}
	
	

	
	
	public Set<Parola> restituisciGiusto(){
		return this.soluzioniGiuste;
	}
	public Set<Parola> restituisciSbagliato(){
		return this.soluzioniSbagliate;
	}
	
	public boolean esisteParola(Parola parziale) {
		
		
			 
		
		return this.dizionario.contains(parziale.restituisciStringa());
	}
	
	
	
	
}
