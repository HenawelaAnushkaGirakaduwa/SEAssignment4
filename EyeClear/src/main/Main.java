package main; // Ensure this matches the package of your Prescription class

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Prescription prescription = new Prescription();

        // Input for adding a prescription
        System.out.print("Enter First Name (4-15 characters): ");
        String firstName = scanner.nextLine();
        
        System.out.print("Enter Last Name (4-15 characters): ");
        String lastName = scanner.nextLine();
        
        System.out.print("Enter Address (minimum 20 characters): ");
        String address = scanner.nextLine();
        
        System.out.print("Enter Sphere (between -20.00 and +20.00): ");
        double sphere = scanner.nextDouble();
        
        System.out.print("Enter Cylinder (between -4.00 and +4.00): ");
        double cylinder = scanner.nextDouble();
        
        System.out.print("Enter Axis (between 0 and 180): ");
        int axis = scanner.nextInt();
        
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter Exam Date (DD/MM/YY): ");
        String examDate = scanner.nextLine();
        
        System.out.print("Enter Optometrist Name (8-25 characters): ");
        String optometristName = scanner.nextLine();

        // Add prescription
        boolean prescriptionAdded = prescription.addPrescription(firstName, lastName, address, sphere, cylinder, axis, examDate, optometristName);
        if (prescriptionAdded) {
            System.out.println("\nPrescription added successfully.\n");
        } else {
            System.out.println("\nFailed to add prescription. Please check the input.\n");
        }

        // Input for adding a remark
        System.out.println("Enter Remark (6-20 words, first letter capitalized): ");
        String remarkText = scanner.nextLine();
        
        System.out.println("Enter Remark Category (client or optometrist): ");
        String category = scanner.nextLine();

        // Add remark
        boolean remarkAdded = prescription.addRemark(remarkText, category);
        if (remarkAdded) {
            System.out.println("\nRemark added successfully.\n");
        } else {
            System.out.println("\nFailed to add remark. Please check the input.\n");
        }

        scanner.close();
    }
}