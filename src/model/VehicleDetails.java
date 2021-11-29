package model;

public class VehicleDetails {
    private String number;
    private String type;
    private String weight;
    private String noPassenger;

    public VehicleDetails(String number, String type, String weight, String noPassenger) {
        this.number = number;
        this.type = type;
        this.weight = weight;
        this.noPassenger = noPassenger;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getNoPassenger() {
        return noPassenger;
    }

    public void setNoPassenger(String noPassenger) {
        this.noPassenger = noPassenger;
    }
}
