package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
	
	@FXML
	private TextField tf;
	@FXML
	private static Label label;
	
	private static int num;
	
	public void submit(ActionEvent e) {
		
		num = Integer.parseInt(tf.getText());
		
	}

	public static void updateLabel(boolean readBoolean) {
		
		boolean b = Server.isPrime(num);
		label.setText("Is it a prime number? " + b);
		
	}
}
