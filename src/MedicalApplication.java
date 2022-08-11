import Entities.BookingSlots;
import Entities.Specialization;
import Services.MedicalAppointmentBookingService;

import java.util.*;

public class MedicalApplication {
    public static String yn;
    public static void main(String[] args) {
        MedicalAppointmentBookingService service = new MedicalAppointmentBookingService();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (i != 9) {
            System.out.println("-------------------------------");
            System.out.println("Choose an Option From Below");
            System.out.println("1. Register a User");
            System.out.println("2. Register an Doctor");
            System.out.println("3. Search for Doctor With Specialization and City");
            System.out.println("4. Get Appointment Details");
            System.out.println("5. Exit the App");
            i = sc.nextInt();
            switch (i) {
                case 1:
                    registerUser(sc, service);
                    break;
                case 2:
                    registerDoctor(sc, service);
                    break;
                case 3:
                    displayDoctorsWithSpecializationAndCity(sc,service);
                    break;
                case 4:
                    getAppointmentDetails(sc,service);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Enter a Valid Option");
                    break;
            }
        }
    }

    private static void registerDoctor(Scanner sc, MedicalAppointmentBookingService service) {
        do{
            System.out.println("Enter the First Name of the Doctor");
            String firstName = sc.next();
            System.out.println("Enter the Last Name of the Doctor");
            String lastName = sc.next();
            System.out.println("Enter Email Id:");
            String emailId=sc.next();
            System.out.println("Enter Phone Number:");
            long phone = sc.nextLong();
            System.out.println("Enter the City:");
            String city=sc.next();
            System.out.println("Enter Locality:");
            String locality = sc.next();
            System.out.println("Enter State:");
            String state = sc.next();
            System.out.println("Enter Pincode:");
            int pinCode = sc.nextInt();
            System.out.println("Enter RegistrationNumber:");
            int registrationNumber=sc.nextInt();
            System.out.println("Enter Your Qualification:");
            String qualification = sc.next();
            System.out.println("Enter Years of Experience:");
            int yearsOfExperience = sc.nextInt();
            Specialization.display();
            System.out.println("Choose Your Specialization form Above(Enter Number from 0 to 7)");
            int specializationChoice = sc.nextInt();
            System.out.println("Enter Clinic Name:");
            String clinicName=sc.next();
            System.out.println("Enter Number of Working Days");
            int noOfWorkingDays = sc.nextInt();

            Map<String,Map<Integer,Boolean>> workingDaySlots = new HashMap<>();

            Map<Integer,Boolean> slotsAvailable = new TreeMap<>();

            String workingDay;
            int startHour,endHour;

            for(int i=0;i<noOfWorkingDays;i++){
                BookingSlots.displayDays();
                System.out.println("Enter Your Working Day");
                workingDay=(sc.next());
                String yn;
                do{
                    System.out.println("Enter Start Hour in 24hrs Format(0 to 23)");
                    startHour=(sc.nextInt());
                    System.out.println("Enter End Hour in 24hrs Format(0 to 23)");
                    endHour=sc.nextInt();
                    if(startHour>=0&&endHour<=23){
                        for(int k =startHour;k<=endHour;k++){
                            slotsAvailable.put(k,true);
                        }
                    }else{
                        System.out.println("Invalid Hours Input");
                    }
                    System.out.println(" If you Want to Add More hours for the Day "+ workingDay+" Enter Yes");
                    yn=sc.next();
                }while(yn.equals("Yes"));
                workingDaySlots.put(workingDay,slotsAvailable);
            }
            service.addDoctor(firstName,lastName,city,locality,state,pinCode,emailId,phone,registrationNumber,
                    yearsOfExperience,qualification,specializationChoice,clinicName,workingDaySlots);
            System.out.println("Would you Like To Register Another Doctor? (Y/N)");
            yn = sc.next();
        }while(yn.equals("Y"));
    }

    private static void registerUser(Scanner sc, MedicalAppointmentBookingService service) {
        do{
            System.out.println("Enter the First Name of the User");
            String firstName = sc.next();
            System.out.println("Enter the Last Name of the User");
            String lastName = sc.next();
            System.out.println("Enter Email Id:");
            String emailId=sc.next();
            System.out.println("Enter Phone Number:");
            long phone = sc.nextLong();
            System.out.println("Enter the City:");
            String city=sc.next();
            System.out.println("Enter Locality:");
            String locality = sc.next();
            System.out.println("Enter State:");
            String state = sc.next();
            System.out.println("Enter Pincode:");
            int pinCode = sc.nextInt();
            service.addUser(firstName,lastName,city,locality,state,pinCode,emailId,phone);
            System.out.println("Would you Like To Register Another User? (Y/N)");
            yn = sc.next();
        }while(yn.equals("Y"));
    }
    public static void displayDoctorsWithSpecializationAndCity(Scanner sc,MedicalAppointmentBookingService service){
        Specialization.display();
        System.out.println("Enter Specialization");
        sc.nextLine();
        String specialization = sc.nextLine();
        System.out.println("Entered Specialization:"+specialization);
        System.out.println("Enter City");
        String city=sc.next();
        service.displayDoctorsWithSpecializationAndCity(specialization,city);
        System.out.println("Enter Doctors Id to get Available Days");
        int doctorsId = sc.nextInt();
        service.displayAvailableDays(doctorsId);
        System.out.println("Enter the Day You Want to book an Appoint With the Doctor:");
        String day = sc.next();
        service.displayAvailableBookingSLots(doctorsId,day);
        System.out.println("Would You Like to Book a Slot(Enter - Yes or no)");
        String yn=sc.next();
        if(yn.equals("Yes")){
            System.out.println("Enter User Id");
            int userId =sc.nextInt();
            System.out.println("Enter Slot Hour you Want to Book(in 24hrs Format- 0 to 23)");
            int slot = sc.nextInt();
            service.bookAppointment(doctorsId,userId,day,slot);
        }
    }

    public static void getAppointmentDetails(Scanner sc, MedicalAppointmentBookingService service){
        System.out.println("Enter Appointment Id");
        int appointmentId=sc.nextInt();
        service.displayAppointmentDetails(appointmentId);
    }

}
