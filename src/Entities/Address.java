package Entities;

public class Address {
    private String city;
    private String locality;
    private String state;
    private int pinCode;

    public Address(String city,String locality, String state, int pinCode){
        this.city=city;
        this.locality=locality;
        this.state=state;
        this.pinCode=pinCode;
    }

    public String getCity() {
        return city;
    }
}
