package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginFormController {

    public AnchorPane loginContext;
    public JFXTextField txtName;
    public JFXPasswordField txtPassword;

    //--when load the login window,it has two button.
    //after pressed login button load the management window after checking user name and password
    public void login(ActionEvent actionEvent) throws IOException {

        if(txtName.getText().equals("admin") && txtPassword.getText().equals("12345")){

            URL resource = getClass().getResource("../view/ManagementPark.fxml");
            Parent load = FXMLLoader.load(resource);
            Stage window = (Stage) loginContext.getScene().getWindow();
            window.setScene(new Scene(load));

        }else{

            new Alert(Alert.AlertType.ERROR, "The user name or password that you entered is incorrect.Try Again.. ", ButtonType.CLOSE).show();
        }

    }
    //--after pressed cancel button load the parking system again
    public void cancel(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/ParkingSystem.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage)loginContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }
}
