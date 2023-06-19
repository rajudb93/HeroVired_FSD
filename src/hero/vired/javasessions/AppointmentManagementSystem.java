package hero.vired.javasessions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class AppointmentManagementSystem {
    private ArrayList<Visitor> visitors;
    private HashMap<String, ArrayList<Appointment>> appointmentsByDate;

    public AppointmentManagementSystem() {
        visitors = new ArrayList<>();
        appointmentsByDate = new HashMap<>();
    }

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public void editVisitorDetails(String visitorName, String newPhone, String newEmail) {
        for (Visitor visitor : visitors) {
            if (visitor.getName().equalsIgnoreCase(visitorName)) {
                visitor.setPhone(newPhone);
                visitor.setEmail(newEmail);
                System.out.println("Visitor details updated successfully.");
                return;
            }
        }
        System.out.println("Visitor not found in the list.");
    }

    public void viewVisitorList() {
        if (visitors.isEmpty()) {
            System.out.println("No visitors in the list.");
        } else {
            System.out.println("Visitor List:");
            for (Visitor visitor : visitors) {
                System.out.println(visitor.getName());
            }
        }
    }

    public void bookAppointment(String visitorName, String date, String time) {
        ArrayList<Appointment> appointments = appointmentsByDate.getOrDefault(date, new ArrayList<>());
        for (Appointment appointment : appointments) {
            if (appointment.getTime().equalsIgnoreCase(time)) {
                System.out.println("Appointment slot not available.");
                return;
            }
        }
        Appointment newAppointment = new Appointment(visitorName, date, time);
        appointments.add(newAppointment);
        appointmentsByDate.put(date, appointments);
        System.out.println("Appointment booked successfully.");
    }

    public void editOrCancelAppointment(String visitorName, String date, String newTime) {
        ArrayList<Appointment> appointments = appointmentsByDate.get(date);
        if (appointments != null) {
            for (Appointment appointment : appointments) {
                if (appointment.getVisitorName().equalsIgnoreCase(visitorName)) {
                    appointment.setTime(newTime);
                    System.out.println("Appointment updated successfully.");
                    return;
                }
            }
        }
        System.out.println("Appointment not found for the visitor on the specified date.");
    }

    public void viewAppointmentSchedule(String date) {
        ArrayList<Appointment> appointments = appointmentsByDate.get(date);
        if (appointments != null && !appointments.isEmpty()) {
            System.out.println("Appointment Schedule for " + date + ":");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        } else {
            System.out.println("No appointments scheduled for the specified date.");
        }
    }

    public static void main(String[] args) {
        AppointmentManagementSystem ams = new AppointmentManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("----- Appointment Management System Menu -----");
            System.out.println("1. View Visitors List");
            System.out.println("2. Add New Visitor");
            System.out.println("3. Edit Visitor Details");
            System.out.println("4. View Appointment Schedule for a Day");
            System.out.println("5. Book an Appointment");
            System.out.println("6. Edit/Cancel Appointment");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ams.viewVisitorList();
                    break;
                case 2:
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter visitor name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    Visitor visitor = new Visitor(name, phone, email);
                    ams.addVisitor(visitor);
                    System.out.println("Visitor added successfully.");
                    break;
                case 3:
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter visitor name: ");
                    String editVisitorName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhone = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    ams.editVisitorDetails(editVisitorName, newPhone, newEmail);
                    break;
                case 4:
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter the date (YYYY-MM-DD): ");
                    String viewDate = scanner.nextLine();
                    ams.viewAppointmentSchedule(viewDate);
                    break;
                case 5:
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter visitor name: ");
                    String bookVisitorName = scanner.nextLine();
                    System.out.print("Enter the date (YYYY-MM-DD): ");
                    String bookDate = scanner.nextLine();
                    System.out.print("Enter the time (HH:MM AM/PM): ");
                    String bookTime = scanner.nextLine();
                    ams.bookAppointment(bookVisitorName, bookDate, bookTime);
                    break;
                case 6:
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter visitor name: ");
                    String editVisitorName2 = scanner.nextLine();
                    System.out.print("Enter the date (YYYY-MM-DD): ");
                    String editDate = scanner.nextLine();
                    System.out.print("Enter the new time (HH:MM AM/PM): ");
                    String editTime = scanner.nextLine();
                    ams.editOrCancelAppointment(editVisitorName2, editDate, editTime);
                    break;
                case 0:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }

            System.out.println();
        } while (choice != 0);

        scanner.close();
    }
}