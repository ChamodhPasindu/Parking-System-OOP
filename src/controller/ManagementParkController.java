package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.VehiclePark;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

public class ManagementParkController {

    public AnchorPane mainContext;
    public AnchorPane subContext;

    public TableView tblVehiclePark;
    public TableColumn colNumber;
    public TableColumn colType;
    public TableColumn colTime;
    public TableColumn colSlot;

    static ObservableList<VehiclePark> vehicleParkArrayList =FXCollections.observableArrayList();

    public void initialize(){

    colNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
    colType.setCellValueFactory(new PropertyValueFactory<>("Type"));
    colSlot.setCellValueFactory(new PropertyValueFactory<>("Slot"));
    colTime.setCellValueFactory(new PropertyValueFactory<>("Time"));

    tblVehiclePark.setItems(vehicleParkArrayList);
    }

    //--get data from parking window when parking button is pressed,then save that data in this in parking table
    public static void dataFromPark(String number,String type,String slot,String time){

        VehiclePark vehiclePark =new VehiclePark(number,type,slot,time);
        vehicleParkArrayList.add(vehiclePark);
    }

    //--get data from parking window when delivery button is pressed,then delete that data from this parking table
    public static void dataFromDelivery(String number){

        ArrayList<VehiclePark> toRemove = new ArrayList();
        for(VehiclePark v : vehicleParkArrayList) {
            if(v.getNumber().equals(number)){
                toRemove.add(v);
            }
        }
        vehicleParkArrayList.removeAll(toRemove);
    }


    void loadUi(String fileName) throws IOException {

        URL resource = getClass().getResource("../view/"+fileName +".fxml");
        Parent load = FXMLLoader.load(resource);
        subContext.getChildren().clear();
        subContext.getChildren().add(load);
    }

    //--Management parking table window
    public void inParking(ActionEvent actionEvent) throws IOException {

        URL resource = getClass().getResource("../view/ManagementPark.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage window = (Stage) mainContext.getScene().getWindow();
        window.setScene(new Scene(load));
    }

    //--Management delivery table window
    public void onDelivery(ActionEvent actionEvent) throws IOException {
        loadUi("ManagementDelivery");
    }

    //--Management add vehicle window
    public void addVehicle(ActionEvent actionEvent) throws IOException {
        loadUi("ManagementAddVehicle");
    }

    //-Management add driver window
    public void addDriver(ActionEvent actionEvent) throws IOException {
        loadUi("ManagementAddDriver");
    }

    //--Management driving details table window
    public void showDriverDetails(ActionEvent actionEvent) throws IOException {
        loadUi("ManagementDrivers");
    }

    //--Management vehicle details table window
    public void showVehicleDetails(ActionEvent actionEvent) throws IOException {
        loadUi("ManagementVehicles");
    }

    //--when pressed this button load pop up window and it can be help to load the parking system again
    public void logOut(ActionEvent actionEvent) throws IOException {

        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to log out", yes, no);
        alert.setTitle("Log Out Confirmation");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(no) == yes) {

            Stage window = (Stage) mainContext.getScene().getWindow();
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ParkingSystem.fxml"))));

        } else {

        }
    }



}
