package model;

public class VehicleDeliver {
    private String number;
    private String type;
    private String name;
    private String time;

    public VehicleDeliver(String number, String type, String name,String time) {
        this.number = number;
        this.type = type;
        this.name = name;
        this.time = time;
    }

    public VehicleDeliver() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setTime(String time){
        this.time = time;
    }
    public String getTime(){
        return time;
    }
}
