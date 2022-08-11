package Entities;

public class User {
    private String firstName;
    private String lastName;
    private Address address;
    private Contact contact;

    private String appointmentDay;

    private int appointmentSlot;

    private int id;

    static int counter=0;



    public User(String firstName,String lastName, Address address, Contact contact){
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.contact=contact;
        counter++;
        this.id=counter;
    }

    public String getName(){
        return firstName+" "+lastName;
    }

    public int getId(){
        return id;
    }

    public void slotBooked(String day,int slot){
        this.appointmentDay=day;
        this.appointmentSlot=slot;
    }

    public int getAppointmentSlot(){
        return appointmentSlot;
    }

    public String getAppointmentDay(){
        return appointmentDay;
    }
}
