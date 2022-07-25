package application;

import java.net.Socket;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.*;
import java.io.*;

public class Client extends Application {
	
	DataOutputStream toServer = null;
	DataInputStream fromServer = null;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			try {
				
				Socket s = new Socket("localhost", 728);
				toServer = new DataOutputStream(s.getOutputStream());
				fromServer = new DataInputStream(s.getInputStream());
				
			} catch (IOException e){
				System.out.println(e);
			}
			
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("ClientScene.fxml"));
			Parent root = (Parent) loader.load();
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Client");
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException{
		launch(args);
	}
	
	public void handle(ActionEvent event) {
		try {
			Controller.updateLabel(fromServer.readBoolean());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
