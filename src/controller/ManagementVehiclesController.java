package controller;

import classes.Vehicle;
import classes.VehicleQueue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.VehicleDetails;

import java.util.Optional;

public class ManagementVehiclesController {

    public TableView tblVehicleDetails;
    public TableColumn colNumber;
    public TableColumn colWeight;
    public TableColumn colType;
    public TableColumn colPassenger;

    ObservableList<VehicleDetails>vehicleDetailsObservableList= FXCollections.observableArrayList();

    public void initialize(){
        colNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        colType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colWeight.setCellValueFactory(new PropertyValueFactory<>("Weight"));
        colPassenger.setCellValueFactory(new PropertyValueFactory<>("NoPassenger"));

        Vehicle vehicle[]=VehicleQueue.getArray();
        for (Vehicle v:vehicle) {
            if(!v.getNumber().equals("null")) {

                vehicleDetailsObservableList.add(new VehicleDetails(v.getNumber(), v.getType(), v.getWeight(), v.getPassenger()));

            }
        }

        tblVehicleDetails.setItems(vehicleDetailsObservableList);

    }
    //--when press the selected row,delete that data in Vehicle details table,if data data has been saved in in parking
    // or on delivery table and combo box that has in parking window for selecting vehicle numbers
    public void deleteOnAction(){
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert alert = new Alert(Alert.AlertType.WARNING, "Do you want delete this vehicle details", yes, no);
        alert.setTitle("Delete Confirmation");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(no) == yes) {

            ObservableList<VehicleDetails> deleteRowObservableList=FXCollections.observableArrayList(tblVehicleDetails.getSelectionModel().getSelectedItems());

            for (VehicleDetails v:deleteRowObservableList) {

                Vehicle[] vehicle = VehicleQueue.getArray();
                for (int i=0;i<vehicle.length;i++){
                    if (v.getNumber().equals(vehicle[i].getNumber())){

                        ManagementParkController.dataFromDelivery(vehicle[i].getNumber());
                        ManagementDeliveryController.dataFromPark(vehicle[i].getNumber());
                        VehicleQueue.editArray(vehicle[i].getNumber());
                        vehicle[i].setNumber("null");

                    }
                }

            };
            tblVehicleDetails.getItems().removeAll(deleteRowObservableList);

        } else {

        }

    }
}
