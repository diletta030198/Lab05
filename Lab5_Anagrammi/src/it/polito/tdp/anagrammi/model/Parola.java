package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parola {
	
	int size; 
	List <Character> lista;
	String par; 
	Map<Character,Integer> mappaCaratteri; 
	
	
	public Parola(String parola) {
		lista= new ArrayList<Character>(); 
		
		this.size= parola.length(); 
		
		/*char [] vettoreC= parola.toCharArray(); 
		for(char c: vettoreC) {
			lista.add(c); 
		}
		*/
		
		this.par=parola; 
		
		mappaCaratteri= new HashMap<Character,Integer>();
		char [] vettoreC= par.toCharArray(); 
		for(char c: vettoreC) {
			if(mappaCaratteri.containsKey(c)) {
				mappaCaratteri.put(c, mappaCaratteri.get(c)+1); 
			}
			else {
				this.mappaCaratteri.put(c, 1); 
			}
		}
	
	}
	
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	
	

	public List<Character> getLista() {
		return lista;
	}


	public void setLista(List<Character> parola) {
		this.lista = parola;
	}


	public void add(Character c) {
	lista.add(c); 
	}


	public Parola clone() {
		Parola p = new Parola(this.par); 
		p.lista= new ArrayList<Character>(this.lista); 
		
	return p; 
		
	}


	public String getPar() {
		return par;
	}


	public void setPar(String par) {
		this.par = par;
	}


	public void remove(char c) {
		Character t = c; 
		this.lista.remove(t); 
		
	}


	public boolean possoInserire(char c) {
		int cont=0; 
		for (char ca: lista) {
			if(c==ca)
				cont++; 
		}
		if(cont==mappaCaratteri.get(c))
			return false; 
		return true;
	}


	public void stampa() {
		for(char c: this.lista) {
			System.out.print(c);
		}
		System.out.print("\n");
		
		
	}
	
	public String parolaStringa() {
		String res="";
		for(char c: this.lista) {
			res=res+c;
		}
		return res; 
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lista == null) ? 0 : lista.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parola other = (Parola) obj;
		if (lista == null) {
			if (other.lista != null)
				return false;
		} else if (!lista.equals(other.lista))
			return false;
		return true;
	}
	
	public String restituisciStringa() {
		String res=""; 
		for(char c: this.lista) {
			res+=c;
		}
		return res; 
	}
	
	
}
