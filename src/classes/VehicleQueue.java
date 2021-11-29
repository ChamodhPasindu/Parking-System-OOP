package classes;

public class VehicleQueue {
     private static  Vehicle[] vehicle;
     private static int next;

    public VehicleQueue() {
        vehicle=new Vehicle[14];
        next=0;
    }
    public void enQueue(Vehicle data){

        vehicle[next++]=data;
    }

    public static String searchType(String number){
        for(int i=0;i<next;i++){
            if (number.equals(vehicle[i].getNumber())){
                return vehicle[i].getType();
            }
        }
        return "invalid";
    }

    public static int searchIndex(String number){
        for (int i=0;i<next;i++){
            if(number.equals(vehicle[i].getNumber())){
                for (int j=0;j<14;j++) {
                    if(vehicle[i].getType().equals(vehicle[j].getType())){
                       if(vehicle[j].getStatus().equals(number)){
                            return 0;
                        }
                    }
                }
                for(int k=0;k<14;k++){
                    if(vehicle[i].getType().equals(vehicle[k].getType())){
                        if(vehicle[k].getStatus().equals("Available")) {
                            return k + 1;
                        }
                    }

                }

            }
        }
        return -1;
    }

    public static Vehicle[] getArray(){
        return vehicle;
    }

    public static void editArray(String data){

        for(int i=0;i<next;i++){
            if(vehicle[i].getStatus().equals(data)){
                vehicle[i].leavePark("Available");
            }
        }
    }

    public static boolean isExists(String number){
        for(int i=0;i<next;i++){
            if(vehicle[i].getNumber().equals(number)){
                return true;
            }
        }
        return false;
    }

    public static int getSlot(String number){
        int slot=0;
        for(int i=0;i<next;i++){
            if(vehicle[i].getStatus().equals(number)){
                slot=i+1;
            }
        }
        return slot;
    }

    public void extendsArray(Vehicle data){
        Vehicle []tempVehicle = new Vehicle[vehicle.length+1];
        for(int i=0;i<next;i++){
            tempVehicle[i]=vehicle[i];
        }
        tempVehicle[next++]=data;
        vehicle=tempVehicle;

    }

}
