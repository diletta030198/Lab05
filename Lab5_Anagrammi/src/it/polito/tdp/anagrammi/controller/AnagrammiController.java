package it.polito.tdp.anagrammi.controller;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.Parola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

    @FXML
    private ResourceBundle resources;
    
    private Model model; 

    @FXML
    private URL location;

    @FXML
    private TextField txtInserisciParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) {
    	
    	String parola = this.txtInserisciParola.getText(); 
    	
    	if(parola.matches("[a-zA-Z]+")) {
    	
   this.model.genera(parola);
   
   for(Parola p: this.model.restituisciGiusto()) {
	 
	   this.txtAnagrammiCorretti.appendText(p.restituisciStringa()+"\n");
	   
   }
   
   for(Parola p: this.model.restituisciSbagliato()) {
	   this.txtAnagrammiErrati.appendText(p.restituisciStringa()+"\n");
	 
   }
   return; 
    	}
    	else 
    		{this.txtAnagrammiCorretti.setText("La parola deve contenere solo lettere!\n");
  return; 
    		}
   
    

    }

    @FXML
    void doReset(ActionEvent event) {
      this.txtAnagrammiCorretti.clear();
      this.txtAnagrammiErrati.clear();
      this.txtInserisciParola.clear();
    }
    
    void setModel(Model model) {
    	this.model=model; 
    }

    @FXML
    void initialize() {
        assert txtInserisciParola != null : "fx:id=\"txtInserisciParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}