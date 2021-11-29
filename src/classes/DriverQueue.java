package classes;

public class DriverQueue {
    private static Driver[] array;
    private static int next;

    public DriverQueue(){
      array=new Driver[16];
      next=0;
     }

     public void enQueue(Driver data){
         array[next++]=data;
     }
     public static Driver[] getArray(){
        return array;
     }

     public void extendsArray(Driver data){
        Driver []tempDriver = new Driver[array.length+1];
        for(int i=0;i<next;i++){
            tempDriver[i]=array[i];
        }
        tempDriver[next++]=data;
        array=tempDriver;

    }
    public static boolean checkNic(String number){
        for(int i=0;i<next;i++){
            if(array[i].getNic().equals(number)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkLicense(String number){
        for (int i=0;i<next;i++){
            if(array[i].getLicense().equals(number)){
                return true;
            }
        }
        return false;
    }

}
