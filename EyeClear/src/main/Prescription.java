package main;

import java.io.*; // Importing classes for input and output operations
import java.time.LocalDate; // Importing LocalDate for date handling
import java.time.format.DateTimeFormatter; // Importing formatter for date formatting
import java.time.format.DateTimeParseException; // Importing exception for date parsing errors
import java.util.ArrayList; // Importing ArrayList for dynamic array handling
import java.util.List; // Importing List interface for list operations

public class Prescription {
    // Attributes of the Prescription class
    private String firstName; 
    private String lastName; 
    private String address; 
    private double sphere; 
    private double cylinder; 
    private int axis; 
    private String examDate; 
    private String optometristName; 
    private List<String> remarks; 

    // Constructor to initialize the remarks list
    public Prescription() {
        remarks = new ArrayList<>(); // Initialize remarks as an empty ArrayList
    }

    // Method to add a new prescription
    public boolean addPrescription(String firstName, String lastName, String address, 
                                   double sphere, double cylinder, int axis, 
                                   String examDate, String optometristName) {
        // Condition 1: Validate first and last name length
        if (firstName.length() < 4 || firstName.length() > 15 ||
            lastName.length() < 4 || lastName.length() > 15) {
            return false; 
        }

        // Condition 2: Validate address length
        if (address.length() < 20) {
            return false; 
        }

        // Condition 3: Validate prescription values
        if (sphere < -20.00 || sphere > 20.00 ||
            cylinder < -4.00 || cylinder > 4.00 ||
            axis < 0 || axis > 180) {
            return false; // Return false if validation fails
        }

        // Condition 4: Validate examination date format
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy"); // Define date format
            LocalDate.parse(examDate, formatter); // Attempt to parse the date
        } catch (DateTimeParseException e) {
            return false; // Return false if date parsing fails
        }

        // Condition 5: Validate optometrist name length
        if (optometristName.length() < 8 || optometristName.length() > 25) {
            return false; // Return false if validation fails
        }

        // If all conditions are met, save the prescription details to a file
        try (FileWriter fw = new FileWriter("presc.txt", true); // Open file in append mode
             BufferedWriter bw = new BufferedWriter(fw); // Wrap FileWriter in BufferedWriter for efficiency
             PrintWriter out = new PrintWriter(bw)) { // Wrap BufferedWriter in PrintWriter for easy output

            // Write prescription details to the file
            out.println("First Name: " + firstName);
            out.println("Last Name: " + lastName);
            out.println("Address: " + address);
            out.println("Sphere: " + String.format("%.2f", sphere)); // Format sphere to 2 decimal places
            out.println("Cylinder: " + String.format("%.2f", cylinder)); // Format cylinder to 2 decimal places
            out.println("Axis: " + axis);
            out.println("Exam Date: " + examDate);
            out.println("Optometrist: " + optometristName);
            out.println("------------------------"); // Separator for clarity

            return true; // Return true indicating success

        } catch (IOException e) {
            return false; // Return false if an I/O error occurs
        }
    }

 // Method to add a remark to the prescription

    public boolean addRemark(String remarkText, String category) {

        // Condition 1: Validate remark text for word count and capitalization

        String[] words = remarkText.trim().split("\\s+"); // Split the remark into words

        if (words.length < 6 || words.length > 20) {

            return false; 

        }


        if (!Character.isUpperCase(remarkText.charAt(0))) {

            return false; 

        }


        // Condition 2: Validate remark category and limit to 2 remarks

        if (!category.equals("client") && !category.equals("optometrist")) {

            return false; // Return false if category is invalid

        }


        if (remarks.size() >= 2) {

            return false; // Return false if there are already 2 remarks

        }


        // If all conditions are met, save the remark to a file

        try (FileWriter fw = new FileWriter("review.txt", true); // Open file in append mode

             BufferedWriter bw = new BufferedWriter(fw); // Wrap FileWriter in BufferedWriter for efficiency

             PrintWriter out = new PrintWriter(bw)) { // Wrap BufferedWriter in PrintWriter for easy output


            // Write remark details to the file

            out.println("Category: " + category);

            out.println("Remark: " + remarkText);

            out.println("------------------------"); // Separator for clarity


            remarks.add(remarkText); // Add the remark to the list

            return true; // Return true indicating success


        } catch (IOException e) {

            return false; // Return false if an I/O error occurs

        }

    }}