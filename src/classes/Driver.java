package classes;

public class Driver {
    private String name;
    private String nic;
    private String license;
    private String address;
    private String contact;
    private String status;

    public Driver() {

    }

    public Driver(String name, String nic, String license, String address, String contact) {
        this.name = name;
        this.nic = nic;
        this.license = license;
        this.address = address;
        this.contact = contact;
        this.status = "Available";
    }

    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }


    public String getLicense() {
        return license;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }
}

