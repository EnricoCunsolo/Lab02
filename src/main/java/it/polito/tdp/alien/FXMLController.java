package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;

public class FXMLController {
	
	Dizionario dizionario = new Dizionario();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParole;
    
    @FXML
    private TextArea txtRisposta;

    @FXML
    void HandleClearText(ActionEvent event) {
    	txtParole.clear();
    	txtRisposta.clear();
    	dizionario.clearDizionario();
    }

    @FXML
    void handleTranslation(ActionEvent event) {
    	
    	String testo = txtParole.getText();
    	
    	if(testo.compareTo("")==0) {
    		txtRisposta.setText("Inserire Qualcosa!");
    	}
    	
    	StringTokenizer st = new StringTokenizer(testo, " ");
    	
    	String s1 = st.nextToken().toLowerCase(); // parola aliena
    	
    	if( s1.matches(".*[A-Z].*") && s1.matches(".*[a-z].*")) {
    		txtRisposta.setText("Inserire solo caratteri alfanumerici!");
    		return;
    	}
    	
    	if(st.hasMoreTokens()) {
    		String s2 = st.nextToken().toLowerCase(); // parola tradotta
    		
    		if( s2.matches(".*[A-Z].*") && s2.matches(".*[a-z].*") && s2.matches(".*?.*")) {
        		txtRisposta.setText("Inserire solo caratteri alfanumerici!");
        		return;
        	}
    		
    		dizionario.addParola(s1, s2);
    		txtRisposta.setText("La parola aliena "+s1+" con traduzione "+ s2+ " è stata aggiunta al dizionario");
    		return;
    	}
    	else { 
    		String traduzione = dizionario.traduciParolaAliena(s1);
    		
    		if(traduzione == null) {
    			txtRisposta.setText("Parola non presente!");
    			return;
    		}
    		
    		txtRisposta.setText("La parola aliena "+s1+" ha come traduzione " + "\n"+ traduzione);
    	}
    	
    	
    }

    @FXML
    void initialize() {
        assert txtParole != null : "fx:id=\"txtParole\" was not injected: check your FXML file 'Scene.fxml'.";
    }

}
