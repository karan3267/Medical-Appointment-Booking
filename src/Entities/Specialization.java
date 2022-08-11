package Entities;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;


public class Specialization {
    public static final String [] specializations = {"General Medicine", "Orthopedics","Internal Medicine",
            "Obstetrics and Gynecology","Dermatology","Pediatrics","General Surgery","Chest Medicine"};
    public Specialization(){

    }

    public String getSpecialization(int choice){
        return (String) Array.get(specializations , choice);
    }

    public static void display(){
        int i=0;

        for(String s:specializations){
            System.out.println(i+" "+s);
            i++;
        }
    }
}
