package model;

public class VehiclePark {
    private String number;
    private String type;
    private String slot;
    private String time;

    public VehiclePark(String number, String type, String slot,String time) {
        this.number = number;
        this.type = type;
        this.slot = slot;
        this.time = time;
    }

    public VehiclePark() {
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

    public String getSlot() {
        return slot;
    }

    public void setSlot(String name) {
        this.slot = name;
    }

    public void setTime(String time){
        this.time=time;
    }
    public String getTime(){
        return time;
    }
}
