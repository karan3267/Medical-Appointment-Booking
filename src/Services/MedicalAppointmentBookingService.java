package Services;

import DAO.Inventory;
import Entities.*;

import java.util.*;

public class MedicalAppointmentBookingService {

    private Inventory inventory;

    public MedicalAppointmentBookingService(){this.inventory=new Inventory();}

    ;

    public void addDoctor(String firstName, String lastName, String city, String locality,
                          String state, int pinCode, String emailId, long phoneNumber,
                          int registrationNumber, int yearsOfExperience, String qualification, int specializationChoice,
                          String clinicName,
                          Map<String,Map<Integer,Boolean>> workingDaySlots){


        Address address = new Address(city,locality,state,pinCode);
        Contact contact = new Contact(emailId,phoneNumber);
        Clinic clinic = new Clinic(clinicName);
        Specialization specialization = new Specialization();
        BookingSlots bookingSlots = new BookingSlots( workingDaySlots, clinic.getId());
        Doctor doctor = new Doctor(firstName,lastName,address,contact,registrationNumber,yearsOfExperience,qualification,
                specialization.getSpecialization(specializationChoice),clinic,bookingSlots);
        inventory.addDoctor(doctor);
        System.out.println("Registered Doctor with DoctorId: "+doctor.getId()+", name: "+doctor.getName());

    }

    public void addUser(String firstName,String lastName, String city, String locality,
                        String state, int pinCode, String emailId, long phoneNumber){


        Address address = new Address(city,locality,state,pinCode);
        Contact contact = new Contact(emailId,phoneNumber);
        User user = new User(firstName,lastName,address,contact);
        inventory.addUser(user);
        System.out.println("Registered User with UsedId:"+user.getId()+", name:"+user.getName());

    }

    public void displayDoctorsWithSpecializationAndCity(String specialization, String city){
        List<Doctor> doctorsWithSpecifics = new ArrayList<>();
        doctorsWithSpecifics.addAll(inventory.getDoctorBySpecializationAndCity(specialization,city));
        System.out.println("Doctors Available in the city "+ city+" and With Specialization "+ specialization+":");
        int i=1;
        for(Doctor doctors:doctorsWithSpecifics){

            System.out.println(i+". Doctors Name: "+doctors.getName() + " with Doctor Id: "+doctors.getId()+
                    " And Clinic Id: "+ doctors.getClinicId());
            i++;
        }
    }

    public void displayAvailableDays(int doctorId){
        Doctor doctor= inventory.getDoctorById(doctorId);
        doctor.daysAvailable();

    }
    public void displayAvailableBookingSLots(int doctorId,String day){
        Doctor doctor= inventory.getDoctorById(doctorId);
        doctor.slotsAvailable(day);

    }
    public void bookAppointment(int doctorsId,int userId,String day,int slot){
        Doctor doctor= inventory.getDoctorById(doctorsId);
        User user = inventory.getUserById(userId);
        if(doctor == null||user==null){
            System.out.println("Invalid Doctors ID/User ID");
        }else{
            user.slotBooked(day, slot);
            doctor.bookSlot(day,slot);
            Appointment appointment=new Appointment(user.getName(), doctor.getName(),day,slot, doctor.getClinicName(),
                    doctor.getCity());
            System.out.println(" Appointment Booked with Appointment Id: "+appointment.getId());
            inventory.addAppointment(appointment);
        }

    }

    public void displayAppointmentDetails(int appointmentId){
        Appointment appointment=inventory.getAppointmentById(appointmentId);
        if(appointment == null){
            System.out.println("No Appointment Booked");
        }else{
            appointment.getAppointmentDetails();
        }
    }


}
