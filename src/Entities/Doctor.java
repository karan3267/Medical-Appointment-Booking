package Entities;

import java.util.Map;

public class Doctor {
    private String firstName;
    private String lastName;
    private int registrationNumber;
    //Specialisation, Booking Slots
    private String specialization;
    private int yearsOfExperience;
    private String qualification;
    private Clinic clinic;
    private Address address;
    private Contact contact;

    private BookingSlots bookingSlots;
    private int id;
    static int counter=0;

    private int specializationChoice;

    public Doctor(String firstName, String lastName, Address address,Contact contact,int registrationNumber,
                  int yearsOfExperience, String qualification,String specialization,Clinic clinic,BookingSlots bookingSlots){
        Specialization s=new Specialization();
        this.firstName=firstName;
        this.lastName=lastName;
        this.address=address;
        this.contact=contact;
        this.registrationNumber=registrationNumber;
        this.yearsOfExperience=yearsOfExperience;
        this.qualification=qualification;
        this.clinic=clinic;
        this.specializationChoice=specializationChoice;
        this.specialization=specialization;
        counter++;
        this.id=counter;
        this.bookingSlots=bookingSlots;
    }

    public String getName(){
        return firstName+" "+lastName;
    }

    public static  int getCounter(){ return counter; }

    public int getId(){
        return id;
    }

    public int getClinicId(){
        return clinic.getId();
    }

    public String getClinicName(){
        return clinic.getName();
    }

    public String getSpecialization(){
        return specialization;
    }

    public void daysAvailable(){
        bookingSlots.displayAvailableDays();
    }
    public void slotsAvailable(String day){
        bookingSlots.displayAvailableSlots(day);
    }

    public void bookSlot(String day,int slot){
        bookingSlots.bookSlot(day,slot);
    }

    public String getCity() { return address.getCity();
    }

}
