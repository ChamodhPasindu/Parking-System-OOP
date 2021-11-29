package classes;

public class CargoLorry implements Vehicle {
    private String number;
    private String status;
    private String type;
    private String weight;
    private String noPassenger;

    public CargoLorry(String number,String weight,String noPassenger) {
        this.number = number;
        this.weight = weight;
        this.noPassenger = noPassenger;
        this.status = "Available";
        this.type = "CargoLorry";
    }

    public String getNumber(){
        return number;
    }
    public void setNumber(String number){
        this.number=number;
    }

    public String getType(){
        return type;
    }
    public String getStatus(){
        return status;
    }

    @Override
    public String getWeight() {
        return weight;
    }

    @Override
    public String getPassenger() {
        return noPassenger;
    }

    public void park(String status) {
        this.status=status;
    }
    public void leavePark(String status){
        this.status=status;
    }
}
