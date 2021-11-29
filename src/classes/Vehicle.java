package classes;

public interface Vehicle {
     String getNumber();
     void setNumber(String number);

     String getType();
     String getWeight();
     String getPassenger();
     String getStatus();

     void park(String status);
     void leavePark(String status);
}
