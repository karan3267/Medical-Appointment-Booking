package Entities;

public class Clinic {
    private int id;
    private String clinicName;
    static int counter=0;

    public Clinic(String clinicName){
        this.clinicName=clinicName;
        counter++;
        this.id=counter;
    }

    public String getName(){
        return clinicName;
    }

    public int getId(){
        return id;
    }
}
