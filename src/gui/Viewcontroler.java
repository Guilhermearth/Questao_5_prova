package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;


public class Viewcontroler implements Initializable {

	
	@FXML
	private TextField nome;
	
	@FXML
	private TextField sobrenome;
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		
		
		
	}
	
	@FXML
	private void botaocadastrarclicado(ActionEvent event) {
		System.out.println("clicado");
		System.out.println("Nome: " + nome.getText() + " " + sobrenome.getText());
	}
	
	@FXML
	private void botaocancelarclicado(ActionEvent event) {
		System.out.println("clicado");
		nome.setText("");
		sobrenome.setText("");
		
		
	}
	
}
