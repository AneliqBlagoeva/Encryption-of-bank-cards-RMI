/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reusableEncryptionView;

import java.net.URL;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import server.Chryptable;

/**
 *
 * @author Administrator
 */
public class EncryptionView extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        URL path = getClass().getResource("FXMLEncryptionPane.fxml");
        Parent root = FXMLLoader.load(path);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            Chryptable encryption = null;
            try {
                encryption = (Chryptable) registry.lookup("Encryption");    
            } catch (NotBoundException ex) {
                System.out.println(ex);
            } catch (AccessException ex) {
                System.out.println(ex);
            }
            System.out.println("Server object " + encryption + " found");
        } catch (Exception ex) {
            System.out.println("Cannot connect to server!");
        }

        launch(args);

    }

}
