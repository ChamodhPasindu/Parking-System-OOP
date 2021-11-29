package controller;

import classes.DriverQueue;
import classes.MainRunner;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class ManagementAddDriverController {

    public JFXTextField txtName;
    public JFXTextField txtNIC;
    public JFXTextField txtLicense;
    public JFXTextArea txtAddress;
    public JFXTextField txtNumber;
    public JFXButton btnAddDriver;

    //--add new driver and details to this system
    public void addDriver(ActionEvent actionEvent) {

        if(txtName.getText().isEmpty() || txtNIC.getText().isEmpty() || txtLicense.getText().isEmpty() ||
                txtAddress.getText().isEmpty() || txtNumber.getText().isEmpty()){
                new Alert(Alert.AlertType.ERROR, "Fill all the fields", ButtonType.CLOSE).show();

        }else{

            Boolean nic = DriverQueue.checkNic(txtNIC.getText());
            Boolean license = DriverQueue.checkLicense(txtLicense.getText());;
            if(nic || license){

                new Alert(Alert.AlertType.ERROR, "Nic or License is already exists ", ButtonType.CLOSE).show();

            }else {

                if(txtName.getText().matches("^[A-Z]\\w{4,10}+ [A-Z]\\w{4,10}+$")){
                    if(txtNIC.getText().matches("^[1-9]{10}[V]$")){
                        if(txtLicense.getText().matches("^[B][1-9]{7}$")){
                            if(txtAddress.getText().matches("^[A-Z][a-z]{5,15}$")) {
                                if (txtNumber.getText().matches("^[0][7][1|2|5|6|7|8][0-9]{7}$")) {

                                    MainRunner.addNewDriver(txtName.getText(), txtNIC.getText(), txtLicense.getText(), txtAddress.getText(), txtNumber.getText());
                                    new Alert(Alert.AlertType.CONFIRMATION, "Driver added successfully", ButtonType.CLOSE).show();
                                    txtName.clear();
                                    txtNIC.clear();
                                    txtLicense.clear();
                                    txtNumber.clear();
                                    txtAddress.clear();

                                } else {
                                    new Alert(Alert.AlertType.INFORMATION, "Contact number is out of range", ButtonType.CLOSE).show();
                                }
                            }else{
                                new Alert(Alert.AlertType.INFORMATION, "Address is out of range", ButtonType.CLOSE).show();
                            }
                        }else {
                            new Alert(Alert.AlertType.INFORMATION, "License number is out of range", ButtonType.CLOSE).show();
                        }
                    }else{
                        new Alert(Alert.AlertType.INFORMATION, "NIC number is out of range", ButtonType.CLOSE).show();
                    }
                }else{
                    new Alert(Alert.AlertType.INFORMATION, "Incorrect name", ButtonType.CLOSE).show();

                }

            }
        }

    }
}
