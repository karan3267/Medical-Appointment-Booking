package Entities;

import DAO.Inventory;

import java.util.Date;

public class Appointment {
    private String userName;
    private String doctorName;
    private Date date;

    private String appointmentDay;

    private int appointmentSlot;

    private int startHour;
    private String clinicName;
    private String city;
    private int id;
    static int counter=0;

    public Appointment(String userName, String doctorName, String day,int slot,String clinicName, String city){

        this.userName= userName;
        this.doctorName=doctorName;
        this.appointmentDay=day;
        this.appointmentSlot=slot;
        this.clinicName=clinicName;
        this.city=city;
        counter++;
        this.id=counter;
    }

    public int getId(){return id;}

    public void getAppointmentDetails(){
        System.out.println("Appointment Booked for User: "+ userName+ " With Doctor: "+doctorName+
                " on Day: "+ appointmentDay+" and Hour Slot: "+ appointmentSlot);
    }
}
