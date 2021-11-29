package controller;

import classes.Driver;
import classes.DriverQueue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.DriverDetails;

import java.util.Optional;

public class ManagementDriversController {

    public TableView tblDriverDetails;
    public TableColumn colName;
    public TableColumn colNic;
    public TableColumn colLicense;
    public TableColumn colAddress;
    public TableColumn colContact;

    ObservableList<DriverDetails>driverDetailsObservableList= FXCollections.observableArrayList();

    public void initialize(){

        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("Nic"));
        colLicense.setCellValueFactory(new PropertyValueFactory<>("License"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("Contact"));

        Driver driver[]=DriverQueue.getArray();
        for (Driver d:driver) {
            if(!d.getName().equals("null")) {
                driverDetailsObservableList.add(new DriverDetails(d.getName(), d.getNic(), d.getLicense(), d.getAddress(), d.getContact()));
            }
        }
        tblDriverDetails.setItems(driverDetailsObservableList);
    }

    //--when delete the selected row in driver details table,that data will be deleted in all other table and combo box
    public void deleteOnAction(ActionEvent actionEvent) {
        ButtonType yes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType no = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        Alert alert = new Alert(Alert.AlertType.WARNING, "Do you want delete this driver details", yes, no);
        alert.setTitle("Delete Confirmation");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.orElse(no) == yes) {

            ObservableList<DriverDetails> deleteRowObservableList=FXCollections.observableArrayList(tblDriverDetails.getSelectionModel().getSelectedItems());

            for (DriverDetails d:deleteRowObservableList) {

                Driver[] driver = DriverQueue.getArray();
                for (int i=0;i<driver.length;i++){
                    if (d.getName().equals(driver[i].getName())){

                        driver[i].setName("null");

                    }
                }

            }
            tblDriverDetails.getItems().removeAll(deleteRowObservableList);

        } else {

        }
    }
}
