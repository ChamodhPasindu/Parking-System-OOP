package controller;

import classes.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ParkingSystemController  {
    public  AnchorPane parkContext;
    public JFXComboBox cmbSelectVehicle;
    public JFXComboBox cmbDriver;
    public Label lblVehicleType;
    public Label lblSlot;
    public Label lblTime;

    public JFXButton btnPark;
    public JFXButton btnDelivery;


    public void initialize() {

        //--add values to combo box(vehicle number)
        Vehicle[] vehicle=VehicleQueue.getArray();
        for (int i=0;i<vehicle.length;i++) {
            if(!vehicle[i].getNumber().equals("null")){
                cmbSelectVehicle.getItems().add(vehicle[i].getNumber());

            }
        }

        //--add values to combo box(driver name)
        Driver[] driver= DriverQueue.getArray();
        for(int i=0;i<driver.length;i++) {
            if(!driver[i].getName().equals("null"))
                if(!driver[i].getStatus().equals("left")) {
                    cmbDriver.getItems().add(driver[i].getName());
                }
        }

        btnPark.setDisable(true);
        btnDelivery.setDisable(true);

        //--add time & date to label
        Thread timerThread = new Thread(() -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ssa");
            while (true) {
                try {
                    Thread.sleep(1000); //1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                final String time = simpleDateFormat.format(new Date());
                Platform.runLater(() -> {
                    lblTime.setText(time);
                });
            }
        });   timerThread.start();

    }

    //--load again data to combo bx after one driver left out for delivery and ofter came to park
    public void updateCmbDriver(){
        Driver[] driver= DriverQueue.getArray();
        for(int i=0;i<driver.length;i++) {
            if(!driver[i].getName().equals("null")) {
                if (!driver[i].getStatus().equals("left")) {
                    cmbDriver.getItems().add(driver[i].getName());
                }
            }
        }
    }


    int slot;
    String vehicle;

    //--when select some vehicle,auto generate vehicle type and parking slot
    // (if vehicle is already park display parked)
    public void selectVehicle(ActionEvent actionEvent) {
        vehicle = cmbSelectVehicle.getSelectionModel().getSelectedItem().toString();
        String type = VehicleQueue.searchType(vehicle);
        lblVehicleType.setText(type);

        int temp=VehicleQueue.searchIndex(vehicle);

        //--already parked or not
        if(temp==0) {

            lblSlot.setText("Parked");
            btnDelivery.setDisable(false);
            btnPark.setDisable(true);

        //--park is full or not
        }else if(temp==-1){

            lblSlot.setText("Full");

        //--park has a slot for park this vehicle
        }else{
            slot=temp;
            lblSlot.setText(String.valueOf(temp));
            btnPark.setDisable(false);
            btnDelivery.setDisable(true);

        }
    }


    //--when delivery button pressed,add data to management on delivery table,
    //  delete data from in parking table if vehicle number is already had.
    public void DeliveryOnAction(ActionEvent actionEvent) {

        if (cmbDriver.getSelectionModel().isEmpty()) {

            new Alert(Alert.AlertType.ERROR, "Driver name should be entered", ButtonType.CLOSE).show();

        } else {

            btnDelivery.setDisable(true);
            btnPark.setDisable(false);
            ManagementParkController.dataFromDelivery(vehicle);
            ManagementDeliveryController.dataFromDelivery(vehicle, lblVehicleType.getText(),cmbDriver.getSelectionModel().getSelectedItem().toString() , lblTime.getText());

            Driver []driver = DriverQueue.getArray();
            for (Driver d:driver) {
                if (d.getName().equals(cmbDriver.getSelectionModel().getSelectedItem().toString())){
                    d.setStatus("left");
                }
            }



            lblSlot.setText("Left");
            VehicleQueue.editArray(vehicle);

            cmbDriver.getItems().clear();
            updateCmbDriver();


        }
    }

    //--when park button pressed,add data to management in parking table,
    // delete data from on delivery table if vehicle number is already had
    public void parkOnAction(ActionEvent actionEvent) {

        btnPark.setDisable(true);
        btnDelivery.setDisable(false);


        lblSlot.setText("Parked");
        Vehicle[]vehicleTemp=VehicleQueue.getArray();
        vehicleTemp[slot-1].park(cmbSelectVehicle.getSelectionModel().getSelectedItem().toString());

        int slot=VehicleQueue.getSlot(vehicle);
        ManagementParkController.dataFromPark(vehicle,lblVehicleType.getText(),String.valueOf(slot),lblTime.getText());
        ManagementDeliveryController.dataFromPark(vehicle);

        cmbDriver.getItems().clear();
         updateCmbDriver();
    }


    //--after pressed the "Management login button load the Management login window"
    public void logIn(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/LoginForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) parkContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

}
//Stage primaryStage = (Stage) (this.root.getScene().getWindow());