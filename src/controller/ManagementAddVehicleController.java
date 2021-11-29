package controller;

import classes.MainRunner;
import classes.VehicleQueue;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ManagementAddVehicleController {

    public JFXTextField txtNumber;
    public JFXTextField txtWeight;
    public JFXTextField txtPassengers;
    public JFXComboBox cmbType;

    public void initialize(){

        cmbType.getItems().addAll(
                "Van","CargoLorry","Bus"
        );
    }

    //-add new vehicle and details to this system
    public void addVehicle(ActionEvent actionEvent) {

        if (txtNumber.getText().isEmpty() || txtWeight.getText().isEmpty() || txtPassengers.getText().isEmpty()
              || cmbType.getSelectionModel().isEmpty()) {

            new Alert(Alert.AlertType.ERROR, "Fill all the fields", ButtonType.CLOSE).show();

        } else {
            boolean b = VehicleQueue.isExists(txtNumber.getText());

            if(b==true){

                new Alert(Alert.AlertType.ERROR, "Vehicle number is already Exists", ButtonType.CLOSE).show();
            }else {

                if(txtNumber.getText().matches("^[A-Z|0-9]{2}[-][0-9]{4}$")){
                    if(txtWeight.getText().matches("^[1-9]{3,4}$")){
                        if(txtPassengers.getText().matches("^[1-6]{1,2}$")){

                            MainRunner.addNewVehicle(cmbType.getSelectionModel().getSelectedItem().toString(), txtNumber.getText(), txtWeight.getText(), txtPassengers.getText());
                            new Alert(Alert.AlertType.CONFIRMATION, "Vehicle added successfully", ButtonType.CLOSE).show();

                            txtNumber.clear();
                            txtWeight.clear();
                            txtPassengers.clear();
                            cmbType.getSelectionModel().clearSelection();

                        }else{
                            new Alert(Alert.AlertType.INFORMATION, "Passenger number is out of range", ButtonType.CLOSE).show();
                        }
                    }else{
                        new Alert(Alert.AlertType.INFORMATION, "Vehicle weight is out of range", ButtonType.CLOSE).show();
                    }
                }else{
                    new Alert(Alert.AlertType.INFORMATION, "Vehicle number is out of range", ButtonType.CLOSE).show();
                }
            }
        }
    }
}
