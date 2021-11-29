package classes;
public class MainRunner {
       static VehicleQueue queue1;
       static DriverQueue queue2;

       //--This method call in AppInitializer class, after called this all data add to tables and combo boxes
       public static void run() {
        queue1 = new VehicleQueue();
        queue1.enQueue(new Van("KA-4563","1000","7"));
        queue1.enQueue(new Van("58-3567","1500","4"));
        queue1.enQueue(new Van("GF-4358","800","4"));
        queue1.enQueue(new Van("CCB-3568","1800","8"));
        queue1.enQueue(new CargoLorry("KB-3668","2500","2"));
        queue1.enQueue(new CargoLorry("JJ-9878","3000","2"));
        queue1.enQueue(new CargoLorry("GH-5772","4000","3"));
        queue1.enQueue(new CargoLorry("XY-4456","3500","2"));
        queue1.enQueue(new CargoLorry("YQ-3536","2000","2"));
        queue1.enQueue(new CargoLorry("CBB-3566","2500","2"));
        queue1.enQueue(new CargoLorry("QH-3444","5000","4"));
        queue1.enQueue(new Van("LM-6679","1500","4"));
        queue1.enQueue(new Van("QA-3369","1800","6"));
        queue1.enQueue(new Bus("NA-3434","3500 ","60"));

        queue2 = new DriverQueue();
        queue2.enQueue(new Driver("Sumith Kumara","7835348345V","B6474845","Panadura","0725637456"));
        queue2.enQueue(new Driver("Amila Pathirana","8826253734V","B3354674","Galle","0717573583"));
        queue2.enQueue(new Driver("Jithmal Perera","9283289272V","B3674589","Horana","0772452457"));
        queue2.enQueue(new Driver("Sumith Dissanayaka","9425245373V","B8366399","Kaluthara","0782686390"));
        queue2.enQueue(new Driver("Sumanasiri Herath","8976544373V","B3537538","Beruwala","0772534436"));
        queue2.enQueue(new Driver("Awantha Fernando","9173537839V","B3554789","Colombo 5","0714534356"));
        queue2.enQueue(new Driver("Charith Sudara","9573536833V","B6835836","Baththaramulla ","0771536662"));
        queue2.enQueue(new Driver("Prashan Dineth","9362426738V","B2683536","Wadduwa","0715353434"));
        queue2.enQueue(new Driver("Chethiya Dilan","9162353436V","B6836836","Panadura ","0772436737"));
        queue2.enQueue(new Driver("Dushantha Perera","9255556343V","B3334435","Matara ","0777245343"));
        queue2.enQueue(new Driver("Sumith Udayanga","8735354355V","B3573783","Galle","0703635442"));
        queue2.enQueue(new Driver("Dinesh Udara","9026344373V","B5343783","Hettimulla","0713456878"));
        queue2.enQueue(new Driver("Udana Chathuranga","9692653338V","B7888632","Kottawa ","0772442444"));
        queue2.enQueue(new Driver("Mohommad Riaz","9124537733V","B3638537","Kaluthara ","0777544222"));
        queue2.enQueue(new Driver("Sandun Kumara","9563524267V","B2263333","Panadura","0772325544"));
        queue2.enQueue(new Driver("Priyanga Perera","9135343537V","B3853753","Matara","0723344562"));

       }

       //--when we add new vehicle that vehicle details save in combo box and tables
       public static void addNewVehicle(String type, String number,String weight,String noPassenger) {
           switch (type) {
               case "Van":
                   queue1.extendsArray(new Van(number, weight, noPassenger));
                   break;
               case "CargoLorry":
                   queue1.extendsArray(new CargoLorry(number, weight, noPassenger));
                   break;
               case "Bus":
                   queue1.extendsArray(new Bus(number, weight, noPassenger));
                   break;
           }
       }
        //--when we add new driver,that driver details save the combo box and tables
       public static void addNewDriver(String name,String nic,String license,String address,String contact){

        queue2.extendsArray(new Driver(name,nic,license,address,contact));
       }
}
