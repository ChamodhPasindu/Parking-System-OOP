package controller;

import classes.Driver;
import classes.DriverQueue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.VehicleDeliver;

import java.util.ArrayList;

public class ManagementDeliveryController {

    public TableView tblDelivery;
    public TableColumn colNumber;
    public TableColumn colType;
    public TableColumn colName;
    public TableColumn colTime;

    static ObservableList <VehicleDeliver> vehicleDeliverObservableArray = FXCollections.observableArrayList();

    public void initialize(){

        colNumber.setCellValueFactory(new PropertyValueFactory<>("Number"));
        colType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colTime.setCellValueFactory(new PropertyValueFactory<>("Time"));

        tblDelivery.setItems(vehicleDeliverObservableArray);
    }

    //--get data from parking window when parking button is pressed,then delete that data from this in parking table
    public static void dataFromPark(String number){

        Driver[] driver = DriverQueue.getArray();
        ArrayList<VehicleDeliver> toRemove = new ArrayList();
        for(VehicleDeliver d : vehicleDeliverObservableArray) {
            if(d.getNumber().equals(number)){
                toRemove.add(d);
                for(int i=0;i<driver.length;i++){
                    if(d.getName().equals(driver[i].getName())){
                        driver[i].setStatus("Available");
                    }
                }
            }
        }
        vehicleDeliverObservableArray.removeAll(toRemove);
    }

    //--get data from parking window when delivery button is pressed,then save that data in this parking table
    public static void dataFromDelivery(String number,String type,String name,String time){

        VehicleDeliver vehicleDeliver = new VehicleDeliver(number,type,name,time);
        vehicleDeliverObservableArray.add(vehicleDeliver);
    }

}
