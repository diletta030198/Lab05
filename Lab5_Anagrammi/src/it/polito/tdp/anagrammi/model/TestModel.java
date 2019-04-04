package it.polito.tdp.anagrammi.model;

public class TestModel {
	
	
	
	public static void main(String[] args) {
		Model model= new Model(); 
		
		model.genera("ciao");
		int cont=0; 
		for(Parola p: model.soluzioniGiuste) {
			//p.stampa();
			System.out.println(p.restituisciStringa());
			cont++;
		}
		System.out.println(cont);
		
		
	}

}
