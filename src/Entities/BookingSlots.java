package Entities;

import DAO.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingSlots {
    private List<String> dayOfTheWeek=new ArrayList<>();
    public static final String [] daysInTheWeek ={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    private int clinicId;


    private Map<String,Map<Integer,Boolean>> availableSlots=new HashMap<>();

    public BookingSlots(Map<String,Map<Integer,Boolean>> workingDaySlots,  int clinicId){

        this.availableSlots = workingDaySlots;
        this.clinicId= clinicId;
    }

    public static void displayDays(){
        int i=0;
        for(String s: daysInTheWeek){
            System.out.println(i+" "+s);
            i++;
        }
    }

    public void displayAvailableDays(){
        System.out.println("Available Days: ");
        for(String day:availableSlots.keySet()){
            System.out.print(day+", ");
        }
        System.out.println();
    }
    public void displayAvailableSlots(String day){
        for(int slot: availableSlots.get(day).keySet()){
            if(availableSlots.get(day).get(slot)==true){
                    System.out.print(slot+", ");
            }
        }
    }

    public void bookSlot(String day,int slot){
        availableSlots.get(day).put(slot,false);
    }
    public void getSlot(String day,int slot){
        System.out.println("Day: "+availableSlots.get(day));
        System.out.println("Slot: "+slot);
    }
}
