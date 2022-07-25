package application;

import java.net.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.*;

public class Server{
	/*
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Server");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	public static void main(String[] args) throws IOException{
		
		ServerSocket ss = new ServerSocket(728);
		Socket s = ss.accept();
		
		DataInputStream in = new DataInputStream(s.getInputStream());
		DataOutputStream out = new DataOutputStream(s.getOutputStream());
		
		//launch(args);
		/*
		Thread t = new Thread (new Runnable() {

			@Override
			public void run() {
				
				try {
					out.writeBoolean(isPrime(0));
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		t.start();
		*/
	}
	
	public static boolean isPrime(int n) {
		
		if (n < 2) {
			
			return false;
			
		} else {
			
			for (int i=2; i<n/2; i++) {
				if (n % i == 0) {
					return false;
				}
			}
			
			return true;
			
		}
	}	
}
