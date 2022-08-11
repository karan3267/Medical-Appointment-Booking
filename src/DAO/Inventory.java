package DAO;

import Entities.Appointment;
import Entities.Clinic;
import Entities.Doctor;
import Entities.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {

    private Map<Integer, User> userMap;
    private Map<Integer, Doctor> doctorMap;
    private Map<Integer, Appointment> appointmentMap;

    public Inventory(){
        this.userMap=new HashMap<>();
        this.doctorMap=new HashMap<>();
        this.appointmentMap=new HashMap<>();
    }

    public void addUser(User user){ userMap.put(user.getId(),user);}

    public void addDoctor(Doctor doctor){doctorMap.put(doctor.getId(),doctor);}

    public void addAppointment(Appointment appointment){appointmentMap.put(appointment.getId(),appointment);}

    public User getUserById(int userId){    return userMap.get(userId); }

    public Doctor getDoctorById(int doctorId){  return doctorMap.get(doctorId); }

    public List<Doctor> getDoctorBySpecializationAndCity(String specialization,String city){
        List <Doctor> doctorsWithSpecializations = new ArrayList<>();
        for(int i=1;i<=Doctor.getCounter();i++){
            if((doctorMap.get(i).getSpecialization()).equals(specialization)&&((doctorMap.get(i).getCity()).equals(city))){
                doctorsWithSpecializations.add(doctorMap.get(i));
            }
        }
        return doctorsWithSpecializations;
    }

    public Appointment getAppointmentById(int appointmentId){   return  appointmentMap.get(appointmentId);  }
}
